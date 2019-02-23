package com.example.omar.graduationproject1.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.omar.graduationproject1.R;
import com.example.omar.graduationproject1.Utils.BottomNavigationViewHelper;
import com.example.omar.graduationproject1.Utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private static final int ACTIVITY_NUM = 4;
    private Context mContext;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mviewPager;
    private RelativeLayout mrelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG,"onCreate: started");
        mviewPager =(ViewPager)findViewById(R.id.container);
        mrelativeLayout =(RelativeLayout)findViewById(R.id.relLayout1);

        setupSettingsList();
        setupBottomNavigationView();
        setupFragmnets();

        //setup the backarrow for navigating back to "ProfileActivity"
        ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: navigating back to 'ProfileActivity' ");
                finish();
            }
        });
    }
    private void setupFragmnets(){
        pagerAdapter =new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile_fragment));//fragment0
        pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out_fragment));//fragment1
    }
    private  void setViewpager(int fragmentNumber){
        mrelativeLayout.setVisibility(View.GONE);
        Log.d(TAG,"setViewPager: navigating to fragment#:"+fragmentNumber);

        mviewPager.setAdapter(pagerAdapter);
        mviewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList(){
        Log.d(TAG,"setupSettingsList: intializing ' Account Settings ' List");
        ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));//fragment0
        options.add(getString(R.string.sign_out_fragment));//fragment1

        ArrayAdapter adapter = new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemCreate:navigation to Fragment#"+position);
                setViewpager(position);

            }
        });
    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
