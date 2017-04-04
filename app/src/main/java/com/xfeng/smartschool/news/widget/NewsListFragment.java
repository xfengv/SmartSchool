package com.xfeng.smartschool.news.widget;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by xfeng
 * data 17/4/3 16:54
 * email xfengv@yeah.net
 */

public class NewsListFragment extends Fragment {
    private int mType = NewsFragment.NEWS_TYPE_SCHOOL_NEWS;
    private int pageIndex = 0;
    public static NewsListFragment newInstance(int type) {
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }
}
