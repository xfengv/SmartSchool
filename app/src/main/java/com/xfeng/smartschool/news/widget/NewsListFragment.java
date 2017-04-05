package com.xfeng.smartschool.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.beans.NewsBean;
import com.xfeng.smartschool.news.view.NewsView;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/3 16:54
 * email xfengv@yeah.net
 */

public class NewsListFragment extends Fragment implements NewsView{
    private int mType = NewsFragment.NEWS_TYPE_SCHOOL_NEWS;
    private int pageIndex = 0;
    public static NewsListFragment newInstance(int type) {
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newslist, null);
        return view;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addNews(List<NewsBean> newsList) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg() {

    }
}
