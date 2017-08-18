package com.mtinalo.amaysim.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mtinalo.amaysim.R;
import com.mtinalo.amaysim.model.Product;

import java.text.NumberFormat;

public class PlanFragment extends Fragment {

    public static final String BUNDLE_KEY_PRODUCT = "plan_product";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        Product product = (Product) bundle.getSerializable(BUNDLE_KEY_PRODUCT);
        View parent = inflater.inflate(R.layout.fragment_plan, container, false);

        ((TextView) parent.findViewById(R.id.product_name)).setText(product.getName());
        ((CheckBox) parent.findViewById(R.id.unli_text_check))
                .setChecked(product.isUnlimitedText());
        ((CheckBox) parent.findViewById(R.id.unli_talk_check))
                .setChecked(product.isUnlimitedTalk());
        ((CheckBox) parent.findViewById(R.id.unli_int_text_check))
                .setChecked(product.isUnlimitedInternationalText());
        ((CheckBox) parent.findViewById(R.id.unli_int_talk_check))
                .setChecked(product.isUnlimitedInternationalTalk());

        NumberFormat monetaryFormat = NumberFormat.getCurrencyInstance();
        ((TextView) parent.findViewById(R.id.price)).setText(
                monetaryFormat.format(product.getPrice()));
        return parent;
    }
}
