package com.mtinalo.amaysim.presenter;

import android.app.Activity;
import android.content.res.AssetManager;

import org.json.JSONObject;
public interface JsonReaderPresenter {
    public JSONObject loadJSONFromAsset(AssetManager assetManager);
}
