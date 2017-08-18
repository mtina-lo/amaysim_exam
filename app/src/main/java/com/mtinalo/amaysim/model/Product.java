package com.mtinalo.amaysim.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Product extends CommonModel {
    private String name;
    private Boolean isUnlimitedText;
    private Boolean isUnlimitedTalk;
    private Boolean isUnlimitedInternationalText;
    private Boolean isUnlimitedInternationalTalk;
    private Double price = 0.0;

    public Product() {

    }

    public Product(JSONObject data) throws JSONException {
        JSONObject attr = data.getJSONObject("attributes");

        id = data.getString("id");
        name = attr.getString("name");
        isUnlimitedText = attr.getBoolean("unlimited-text");
        isUnlimitedTalk = attr.getBoolean("unlimited-talk");
        isUnlimitedInternationalText = attr.getBoolean("unlimited-international-text");
        isUnlimitedInternationalTalk = attr.getBoolean("unlimited-international-talk");
        price = attr.getDouble("price");
    }

    public String getName() {
        return name;
    }

    public Boolean isUnlimitedText() {
        return isUnlimitedText;
    }

    public Boolean isUnlimitedTalk() {
        return isUnlimitedTalk;
    }

    public Boolean isUnlimitedInternationalText() {
        return isUnlimitedInternationalText;
    }

    public Boolean isUnlimitedInternationalTalk() {
        return isUnlimitedInternationalTalk;
    }

    public Double getPrice() {
        return price/100;
    }
}
