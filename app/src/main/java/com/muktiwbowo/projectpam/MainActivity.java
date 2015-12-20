package com.muktiwbowo.projectpam;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    TabLayout mTabs;
    private ViewPager tabsviewPager;
    private TabAdapter mTabsAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabsviewPager = (ViewPager) findViewById(R.id.viewpager);

        mTabsAdapter = new TabAdapter(getSupportFragmentManager());

        //creating the tabs and adding them to adapter class
        mTabsAdapter.addFragment(new CategoryActivity(), "Kategori");
        mTabsAdapter.addFragment(new About(), "About");

        //setup viewpager to give swipe effect
        tabsviewPager.setAdapter(mTabsAdapter);

        mTabs = (TabLayout) findViewById(R.id.tabs);
        mTabs.setupWithViewPager(tabsviewPager);

        imageView = (ImageView) findViewById(R.id.search);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SearchActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}
