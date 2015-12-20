package com.muktiwbowo.projectpam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muktiwbowo on 06/12/15.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private final List<Fragment> FragmentList = new ArrayList();
    private final List<String> FragmentTitles = new ArrayList();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        FragmentList.add(fragment);
        FragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }

    public CharSequence getPageTitle(int position) {
        return FragmentTitles.get(position);
    }
}
