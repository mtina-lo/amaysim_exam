package com.mtinalo.amaysim.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.mtinalo.amaysim.CommonConstants;
import com.mtinalo.amaysim.fragments.AccountFragment;
import com.mtinalo.amaysim.fragments.HomeFragment;
import com.mtinalo.amaysim.fragments.PlanFragment;
import com.mtinalo.amaysim.model.Account;
import com.mtinalo.amaysim.model.AmaysimService;
import com.mtinalo.amaysim.model.Product;
import com.mtinalo.amaysim.model.Subscription;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainViewPageAdapter extends FragmentPagerAdapter {

    private JSONObject mCollections;

    public MainViewPageAdapter(FragmentManager fm, JSONObject collections) {
        super(fm);
        mCollections = collections;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle bundles = new Bundle();

        switch (position) {
            case CommonConstants.COLLECTION_ARRAY_POSITION_HOME:
                try {
                    JSONArray included = mCollections.getJSONArray("included");
                    for (int i = 0; i < included.length(); i++) {
                        JSONObject object = included.getJSONObject(i);
                        String type = object.getString("type");
                        switch (type) {
                            case "services":
                                AmaysimService service = new AmaysimService(object);
                                bundles.putSerializable(HomeFragment.BUNDLE_KEY_SERVICE, service);
                                break;
                            case "subscriptions":
                                Subscription subscription = new Subscription(object);
                                bundles.putDouble(HomeFragment.BUNDLE_KEY_DATA_USAGE, subscription.getIncludedDataBal());
                                break;
                            case "products":
                                Product product = new Product(object);
                                bundles.putString(HomeFragment.BUNDLE_KEY_PRODUCT_NAME, product.getName());
                                break;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                fragment = new HomeFragment();
                fragment.setArguments(bundles);
                break;
            case CommonConstants.COLLECTION_ARRAY_POSITION_PLAN:
                try {
                    Product product = null;
                    JSONArray included2 = mCollections.getJSONArray("included");
                    for (int i = 0; i < included2.length(); i++) {
                        JSONObject object2 = included2.getJSONObject(i);
                        String type = object2.getString("type");
                        if ("products".equals(type)) {
                            product = new Product(object2);
                            bundles.putString(HomeFragment.BUNDLE_KEY_PRODUCT_NAME, product.getName());
                        }
                    }
                    bundles.putSerializable(PlanFragment.BUNDLE_KEY_PRODUCT, product);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                fragment = new PlanFragment();
                fragment.setArguments(bundles);
                break;
            case CommonConstants.COLLECTION_ARRAY_POSITION_ACCOUNT:
                try {
                    Account acct = new Account(mCollections.getJSONObject("data"));
                    bundles.putSerializable(AccountFragment.BUNDLE_KEY_ACCOUNT, acct);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                fragment = new AccountFragment();
                fragment.setArguments(bundles);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
