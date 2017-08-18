package com.mtinalo.amaysim.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.mtinalo.amaysim.R;
import com.mtinalo.amaysim.model.AmaysimService;
import com.mtinalo.amaysim.presenter.JsonReaderPresenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity implements View.OnClickListener {

    private String saveMSN;
    private EditText msnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login).setOnClickListener(this);
        msnEdit = (EditText) findViewById(R.id.msn);

        try {
            JsonReaderPresenterImpl mJsonReaderPresenter = new JsonReaderPresenterImpl();
            JSONObject collections = mJsonReaderPresenter.loadJSONFromAsset(getAssets());
            JSONArray included = collections.getJSONArray("included");

            for (int i = 0; i < included.length(); i++) {
                JSONObject object = included.getJSONObject(i);
                String type = object.getString("type");

                if ("services".equals(type)) {
                    AmaysimService service = new AmaysimService(object);
                    saveMSN = service.getMsn();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        String msn = ((EditText) findViewById(R.id.msn)).getText().toString();
        if(!saveMSN.isEmpty() && saveMSN.equals(msn)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            msnEdit.setError(getString(R.string.login_err));
        }
    }
}
