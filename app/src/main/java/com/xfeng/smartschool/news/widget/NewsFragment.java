package com.xfeng.smartschool.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfeng.smartschool.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xfeng
 * data 17/3/27 20:27
 * email xfengv@yeah.net
 */

public class NewsFragment extends Fragment{

    public static final int NEWS_TYPE_SCHOOL_NEWS = 0;
    public static final int NEWS_TYPE_COMMUNICATE = 1;
    public static final int NEWS_TYPE_LEARNING = 2;
    public static final int NEWS_TYPE_JOB = 3;

    private static final String PARAM = "param";
    private String mParam;
    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_1_container, null);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.school_news));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.communicate));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.learning));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.job));
        mTablayout.setupWithViewPager(mViewPager);
        return view;
    }
    public void setupViewPager(ViewPager upViewPager) {
        //Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_SCHOOL_NEWS), getString(R.string.school_news));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_COMMUNICATE), getString(R.string.communicate));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_LEARNING), getString(R.string.learning));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_JOB), getString(R.string.job));
        mViewPager.setAdapter(adapter);
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(PARAM);
        }
    }


    public static NewsFragment newInstance(String param) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


}
