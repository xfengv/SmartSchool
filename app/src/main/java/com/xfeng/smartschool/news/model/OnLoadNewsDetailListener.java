package com.xfeng.smartschool.news.model;

import com.xfeng.smartschool.beans.NewsDetailBean;

/**
 * Created by xfeng
 * data 17/4/3 15:43
 * email xfengv@yeah.net
 */

public interface OnLoadNewsDetailListener {
    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg, Exception e);
}
