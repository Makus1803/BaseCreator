package com.basecreator.utils;

import com.basecreator.domain.model.verimail.Verimail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

@ConfigurationProperties(prefix = "mailcheck")
public class CheckMailUtils {
    // mamipi7349@nnacell.com
    // test12
    @Value("${mailcheck.verimailApi}")
    private static String APIKey = "E9F0611F9C554142A93E8F54822CB81A";
    private static final Logger logger = LogManager.getLogger(CheckMailUtils.class);

    private static int hear(BufferedReader in) throws IOException {
        String line;
        int res = 0;

        while ((line = in.readLine()) != null) {
            String pfx = line.substring(0, 3);
            try {
                res = Integer.parseInt(pfx);
            } catch (Exception ex) {
                res = -1;
            }
            if (line.charAt(3) != '-') break;
        }

        return res;
    }

    private static void say(BufferedWriter wr, String text)
            throws IOException {
        wr.write(text + "\r\n");
        wr.flush();
    }


    private static ArrayList<String> getMX(String hostName)
            throws NamingException {
        // Perform a DNS lookup for MX records in the domain
        Hashtable<String, String> env = new Hashtable<>();
        env.put("java.naming.factory.initial",
                "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext(env);
        Attributes attrs = ictx.getAttributes
                (hostName, new String[]{"MX"});
        Attribute attr = attrs.get("MX");

        // if we don't have an MX record, try the machine itself
        if ((attr == null) || (attr.size() == 0)) {
            attrs = ictx.getAttributes(hostName, new String[]{"A"});
            attr = attrs.get("A");
            if (attr == null)
                throw new NamingException
                        ("No match for name '" + hostName + "'");
        }
        // Huzzah! we have machines to try. Return them as an array list
        // NOTE: We SHOULD take the preference into account to be absolutely
        //   correct. This is left as an exercise for anyone who cares.
        ArrayList<String> res = new ArrayList<>();
        NamingEnumeration en = attr.getAll();

        while (en.hasMore()) {
            String mailhost;
            String x = (String) en.next();
            String[] f = x.split(" ");
            //  THE fix *************
            if (f.length == 1)
                mailhost = f[0];
            else if (f[1].endsWith("."))
                mailhost = f[1].substring(0, (f[1].length() - 1));
            else
                mailhost = f[1];
            //  THE fix *************
            res.add(mailhost);
        }
        return res;
    }


    public static String isAddressValid(String address) {
        // Find the separator for the domain name
        int pos = address.indexOf('@');

        // If the address does not contain an '@', it's not valid
        if (pos == -1) return "Regex address is not valid";

        // Isolate the domain/machine name and get a list of mail exchangers
        String domain = address.substring(++pos);
        ArrayList<String> mxList;
        try {
            mxList = getMX(domain);
        } catch (NamingException ex) {
            return "Problem with host name";
        }

        // Just because we can send mail to the domain, doesn't mean that the
        // address is valid, but if we can't, it's a sure sign that it isn't
        if (mxList.size() == 0) return "Hard bounce";

        // Now, do the SMTP validation, try each mail exchanger until we get
        // a positive acceptance. It *MAY* be possible for one MX to allow
        // a message [store and forwarder for example] and another [like
        // the actual mail server] to reject it. This is why we REALLY ought
        // to take the preference into account.
        for (Object o : mxList) {
            boolean valid = false;
            try {
                int res;
                //
                Socket skt = new Socket((String) o, 25);
                BufferedReader rdr = new BufferedReader
                        (new InputStreamReader(skt.getInputStream()));
                BufferedWriter wtr = new BufferedWriter
                        (new OutputStreamWriter(skt.getOutputStream()));

                res = hear(rdr);
                if (res != 220)
                    throw new Exception("Invalid header");
                say(wtr, "EHLO orbaker.com");

                res = hear(rdr);
                if (res != 250)
                    throw new Exception("Not ESMTP");

                // validate the sender address
                say(wtr, "MAIL FROM: <alpaca@lamassistant.com>");
                res = hear(rdr);
                if (res != 250)
                    throw new Exception("Sender rejected");

                say(wtr, "RCPT TO: <" + address + ">");
                res = hear(rdr);

                // be polite
                say(wtr, "RSET");
                hear(rdr);
                say(wtr, "QUIT");
                hear(rdr);
                System.out.println("res = " + res);
                logger.info(new Date().toString() + "     " + address + " : " + res);
                if (res != 250)
                    return "Undeliverable. Address not valid";

                rdr.close();
                wtr.close();
                skt.close();

                return "Deliverable";
            } catch (Exception ex) {
                // Do nothing but try next host
//                ex.printStackTrace();
            }
        }
        return "Undeliverable";
    }

    public static String checkFromApi(String address){
        logger.info(new Date().toString() + "     " + "Pobieranie danych z API dla: " + address);
        RestTemplate restTemplate = new RestTemplate();

        Verimail response = restTemplate.getForObject("https://api.verimail.io/v3/verify?email=" + address + "&key="+APIKey, Verimail.class);
        assert response != null;
        if (response.getResult().equals("catch_all"))
            return "Catch_all";
        else if (response.getResult().equals("deliverable"))
            return "Deliverable";
        else
            return "Undeliverable";
    }

}
