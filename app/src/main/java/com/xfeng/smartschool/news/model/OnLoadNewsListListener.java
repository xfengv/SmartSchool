package com.xfeng.smartschool.news.model;

import com.xfeng.smartschool.beans.NewsBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/3 15:44
 * email xfengv@yeah.net
 */

public interface OnLoadNewsListListener {
    void onSuccess(List<NewsBean> list);

    void onFailure(String msg, Exception e);
}
