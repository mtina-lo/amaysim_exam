package com.mtinalo.amaysim.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtinalo.amaysim.R;
import com.mtinalo.amaysim.model.Account;

import java.text.NumberFormat;

public class AccountFragment extends Fragment {

    public static final String BUNDLE_KEY_ACCOUNT = "account";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        Account acct = (Account) bundle.get(BUNDLE_KEY_ACCOUNT);
        View parent = inflater.inflate(R.layout.fragment_acct, container, false);

        ((TextView) parent.findViewById(R.id.payment)).setText(acct.getPaymentType());
        ((TextView) parent.findViewById(R.id.name)).setText(
                getString(R.string.acct_name, acct.getTitleName(),
                        acct.getFirstName(), acct.getLastName()));
        ((TextView) parent.findViewById(R.id.birthday)).setText(acct.getDateOfBirth());
        ((TextView) parent.findViewById(R.id.contact)).setText(acct.getContactNumber());
        ((TextView) parent.findViewById(R.id.email)).setText(acct.getEmailAddr());

        return parent;
    }
}
