package com.basecreator.web.payload.response;

public class OneMailResponse {
    private String mail;
    private String status;

    public OneMailResponse(String mail, String status) {
        this.mail = mail;
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
