package com.xfeng.smartschool.news.model;

/**
 * Created by xfeng
 * data 17/4/3 15:42
 * email xfengv@yeah.net
 */

public interface NewModel {

    void loadNews(String url, int type, OnLoadNewsListListener listener);
    void loadNewsDetail(String docid, OnLoadNewsDetailListener listener);
}
