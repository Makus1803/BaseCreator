package com.basecreator.domain.model.verimail;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "email",
        "result",
        "deliverable",
        "user",
        "domain",
        "did_you_mean"
})
@Generated("jsonschema2pojo")
public class Verimail {

    @JsonProperty("status")
    private String status;
    @JsonProperty("email")
    private String email;
    @JsonProperty("result")
    private String result;
    @JsonProperty("deliverable")
    private Boolean deliverable;
    @JsonProperty("user")
    private String user;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("did_you_mean")
    private String didYouMean;

    /**
     * No args constructor for use in serialization
     *
     */
    public Verimail() {
    }

    /**
     *
     * @param result
     * @param didYouMean
     * @param domain
     * @param deliverable
     * @param user
     * @param email
     * @param status
     */
    public Verimail(String status, String email, String result, Boolean deliverable, String user, String domain, String didYouMean) {
        super();
        this.status = status;
        this.email = email;
        this.result = result;
        this.deliverable = deliverable;
        this.user = user;
        this.domain = domain;
        this.didYouMean = didYouMean;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("deliverable")
    public Boolean getDeliverable() {
        return deliverable;
    }

    @JsonProperty("deliverable")
    public void setDeliverable(Boolean deliverable) {
        this.deliverable = deliverable;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("did_you_mean")
    public String getDidYouMean() {
        return didYouMean;
    }

    @JsonProperty("did_you_mean")
    public void setDidYouMean(String didYouMean) {
        this.didYouMean = didYouMean;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Verimail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("result");
        sb.append('=');
        sb.append(((this.result == null)?"<null>":this.result));
        sb.append(',');
        sb.append("deliverable");
        sb.append('=');
        sb.append(((this.deliverable == null)?"<null>":this.deliverable));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("domain");
        sb.append('=');
        sb.append(((this.domain == null)?"<null>":this.domain));
        sb.append(',');
        sb.append("didYouMean");
        sb.append('=');
        sb.append(((this.didYouMean == null)?"<null>":this.didYouMean));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.result == null)? 0 :this.result.hashCode()));
        result = ((result* 31)+((this.didYouMean == null)? 0 :this.didYouMean.hashCode()));
        result = ((result* 31)+((this.domain == null)? 0 :this.domain.hashCode()));
        result = ((result* 31)+((this.deliverable == null)? 0 :this.deliverable.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Verimail) == false) {
            return false;
        }
        Verimail rhs = ((Verimail) other);
        return ((((((((this.result == rhs.result)||((this.result!= null)&&this.result.equals(rhs.result)))&&((this.didYouMean == rhs.didYouMean)||((this.didYouMean!= null)&&this.didYouMean.equals(rhs.didYouMean))))&&((this.domain == rhs.domain)||((this.domain!= null)&&this.domain.equals(rhs.domain))))&&((this.deliverable == rhs.deliverable)||((this.deliverable!= null)&&this.deliverable.equals(rhs.deliverable))))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}

