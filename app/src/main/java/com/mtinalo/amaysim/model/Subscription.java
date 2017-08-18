package com.mtinalo.amaysim.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Subscription extends CommonModel {
    private Double includedDataBal;
    private Double includedCreditBal;
    private Double includedRolloverCreditBal;
    private Double includedRolloverDataBal;
    private Double includedInternationalTalkBal;
    private String subExpiryDate;
    private Boolean isAutoRenewal;
    private Boolean isPrimarySubscription;

    public Subscription() {

    }

    public Subscription(JSONObject data) throws JSONException {
        JSONObject attr = data.getJSONObject("attributes");

        id = data.getString("id");
        includedDataBal = attr.optDouble("included-data-balance");
        includedCreditBal = attr.optDouble("included-credit-balance");
        includedRolloverCreditBal = attr.optDouble("included-rollover-credit-balance");
        includedRolloverDataBal = attr.optDouble("included-rollover-data-balance");
        includedInternationalTalkBal = attr.optDouble("included-international-talk-balance");
        subExpiryDate = attr.optString("expiry-date");
        isAutoRenewal = attr.optBoolean("auto-renewal");
        isPrimarySubscription = attr.optBoolean("primary-subscription");
    }

    public Double getIncludedDataBal() {
        return includedDataBal;
    }

    public Double getIncludedCreditBal() {
        return includedCreditBal;
    }

    public Double getIncludedRolloverCreditBal() {
        return includedRolloverCreditBal;
    }

    public Double getIncludedRolloverDataBal() {
        return includedRolloverDataBal;
    }

    public Double getIncludedInternationalTalkBal() {
        return includedInternationalTalkBal;
    }

    public String getSubExpiryDate() {
        return subExpiryDate;
    }

    public Boolean getIsAutoRenewal() {
        return isAutoRenewal;
    }

    public Boolean getIsPrimarySubscription() {
        return isPrimarySubscription;
    }
}
