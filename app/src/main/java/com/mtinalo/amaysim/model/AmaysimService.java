package com.mtinalo.amaysim.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class AmaysimService extends CommonModel {
    private String msn;
    private Double credit;
    private String creditExpiry;
    private Boolean dataUsageThreshold;

    public AmaysimService() {

    }

    public AmaysimService(JSONObject data) throws JSONException{
        JSONObject attr = data.getJSONObject("attributes");

        id = data.getString("id");
        msn = attr.getString("msn");
        credit = attr.optDouble("credit");
        creditExpiry = attr.optString("credit-expiry");
        dataUsageThreshold = attr.getBoolean("data-usage-threshold");
    }

    public String getMsn() {
        return msn;
    }

    public Double getCredit() {
        return credit/100;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public Boolean getDataUsageThreshold() {
        return dataUsageThreshold;
    }

    public enum DataCap {
        GB70(7168);

        int capMB;

        DataCap(int capMB) {
            this.capMB = capMB;
        }

        public int getCapMB() {
            return capMB;
        }
    }
}
