package com.mtinalo.amaysim.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mtinalo.amaysim.CommonConstants;
import com.mtinalo.amaysim.R;
import com.mtinalo.amaysim.model.AmaysimService;

import java.text.NumberFormat;

public class HomeFragment extends Fragment {
    public static final String BUNDLE_KEY_SERVICE = "home_service";
    public static final String BUNDLE_KEY_PRODUCT_NAME = "home_product_name";
    public static final String BUNDLE_KEY_DATA_USAGE = "home_data_usage";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        AmaysimService service = (AmaysimService) bundle.getSerializable(BUNDLE_KEY_SERVICE);
        double data = bundle.getDouble(BUNDLE_KEY_DATA_USAGE, 0);
        String productName = bundle.getString(BUNDLE_KEY_PRODUCT_NAME);
        int cap = AmaysimService.DataCap.GB70.getCapMB();
        double remaining = data - AmaysimService.DataCap.GB70.getCapMB();

        NumberFormat monetaryFormat = NumberFormat.getCurrencyInstance();

        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        ((TextView) parent.findViewById(R.id.msn)).setText(service.getMsn());
        ((TextView) parent.findViewById(R.id.plan_name)).setText(productName);
        ((TextView) parent.findViewById(R.id.price)).setText(monetaryFormat.format(service.getCredit()));
        ((TextView) parent.findViewById(R.id.data_capacity)).setText(
                getString(R.string.home_data_capacity, Math.round(data), cap));

        ProgressBar progressBar = ((ProgressBar) parent.findViewById(R.id.data_cap_bar));
        if(service.getDataUsageThreshold()) {
            progressBar.setMax(AmaysimService.DataCap.GB70.getCapMB());
            progressBar.setProgress((int) Math.round(data));
            ((TextView) parent.findViewById(R.id.data_cap_progress_label)).setText(
                    getString(R.string.home_remaining_progress_label, Math.round(remaining)));
        } else {
            progressBar.setVisibility(View.GONE);
        }


        return parent;
    }
}
