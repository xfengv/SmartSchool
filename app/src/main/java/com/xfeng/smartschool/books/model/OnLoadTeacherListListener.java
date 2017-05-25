package com.xfeng.smartschool.books.model;

import com.xfeng.smartschool.beans.Meizi;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:38
 * email xfengv@yeah.net
 */

public interface OnLoadTeacherListListener {
    void onSuccess(List<Meizi> list);
    void onFailure(String msg, Exception e);
}
