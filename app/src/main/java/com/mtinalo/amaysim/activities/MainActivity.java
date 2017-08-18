package com.mtinalo.amaysim.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ToggleButton;

import com.mtinalo.amaysim.CommonConstants;
import com.mtinalo.amaysim.R;
import com.mtinalo.amaysim.adapter.MainViewPageAdapter;
import com.mtinalo.amaysim.presenter.JsonReaderPresenter;
import com.mtinalo.amaysim.presenter.JsonReaderPresenterImpl;

public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private JsonReaderPresenter mJsonReaderPresenter;

    private ToggleButton homeBtn;
    private ToggleButton planBtn;
    private ToggleButton acctBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJsonReaderPresenter = new JsonReaderPresenterImpl();

        mAdapter = new MainViewPageAdapter(getSupportFragmentManager(),
                mJsonReaderPresenter.loadJSONFromAsset(getAssets()));

        mViewPager = (ViewPager) findViewById(R.id.display_area);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setAdapter(mAdapter);

        homeBtn = (ToggleButton) findViewById(R.id.home_button);
        planBtn = (ToggleButton) findViewById(R.id.plan_button);
        acctBtn = (ToggleButton) findViewById(R.id.acct_button);

        homeBtn.setOnClickListener(this);
        planBtn.setOnClickListener(this);
        acctBtn.setOnClickListener(this);

        setButtonBackground(CommonConstants.COLLECTION_ARRAY_POSITION_HOME);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                mViewPager.setCurrentItem(CommonConstants.COLLECTION_ARRAY_POSITION_HOME, true);
                break;
            case R.id.plan_button:
                mViewPager.setCurrentItem(CommonConstants.COLLECTION_ARRAY_POSITION_PLAN, true);
                break;
            case R.id.acct_button:
                mViewPager.setCurrentItem(CommonConstants.COLLECTION_ARRAY_POSITION_ACCOUNT, true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setButtonBackground(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setButtonBackground(int position) {
        switch (position) {
            case CommonConstants.COLLECTION_ARRAY_POSITION_HOME:
                homeBtn.setChecked(true);
                planBtn.setChecked(false);
                acctBtn.setChecked(false);
                break;
            case CommonConstants.COLLECTION_ARRAY_POSITION_PLAN:
                homeBtn.setChecked(false);
                planBtn.setChecked(true);
                acctBtn.setChecked(false);
                break;
            case CommonConstants.COLLECTION_ARRAY_POSITION_ACCOUNT:
                homeBtn.setChecked(false);
                planBtn.setChecked(false);
                acctBtn.setChecked(true);
                break;
        }
    }
}
