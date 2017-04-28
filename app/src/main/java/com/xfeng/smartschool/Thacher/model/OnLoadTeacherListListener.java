package com.xfeng.smartschool.Thacher.model;

import com.xfeng.smartschool.beans.TeacherBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:38
 * email xfengv@yeah.net
 */

public interface OnLoadTeacherListListener {
    void onSuccess(List<TeacherBean> list);
    void onFailure(String msg, Exception e);
}
