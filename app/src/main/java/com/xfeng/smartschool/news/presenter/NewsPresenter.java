package com.xfeng.smartschool.news.presenter;

/**
 * Created by xfeng
 * data 17/4/3 15:47
 * email xfengv@yeah.net
 */

public interface NewsPresenter {
    //获取新闻的逻辑
    void loadNews(int type, int page);
}
