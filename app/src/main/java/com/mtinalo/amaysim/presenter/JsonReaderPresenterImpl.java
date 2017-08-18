package com.mtinalo.amaysim.presenter;

import android.app.Activity;
import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class JsonReaderPresenterImpl implements JsonReaderPresenter {

    public JSONObject loadJSONFromAsset(AssetManager assetManager) {
        String json = null;
        try {
            InputStream is = assetManager.open("collections.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            return new JSONObject(json);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
