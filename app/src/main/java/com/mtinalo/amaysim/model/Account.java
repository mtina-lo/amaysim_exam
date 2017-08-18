package com.mtinalo.amaysim.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Account extends CommonModel {
    private String paymentType;
    private String titleName;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String contactNumber;
    private String emailAddr;
    private Boolean isEmailAddrVerified;
    private Boolean isEmailSubscribed;

    public Account() {

    }

    public Account(JSONObject data) throws JSONException {
        JSONObject attributes = data.getJSONObject("attributes");

        id = data.getString("id");
        paymentType = attributes.optString("payment-type");
        titleName = attributes.optString("title");
        firstName = attributes.optString("first-name");
        lastName = attributes.optString("last-name");
        dateOfBirth = attributes.optString("date-of-birth");
        contactNumber = attributes.optString("contact-number");
        emailAddr = attributes.optString("email-address");
        isEmailAddrVerified = attributes.getBoolean("email-address-verified");
        isEmailSubscribed = attributes.getBoolean("email-subscription-status");
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public Boolean getIsEmailAddrVerified() {
        return isEmailAddrVerified;
    }

    public Boolean getIsEmailSubscribed() {
        return isEmailSubscribed;
    }
}
