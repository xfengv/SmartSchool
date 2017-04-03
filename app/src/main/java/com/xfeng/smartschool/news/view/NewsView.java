package com.xfeng.smartschool.news.view;

import com.xfeng.smartschool.beans.NewsBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/3 15:48
 * email xfengv@yeah.net
 */

public interface NewsView {
    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();

}
