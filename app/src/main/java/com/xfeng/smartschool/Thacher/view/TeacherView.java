package com.xfeng.smartschool.Thacher.view;

import com.xfeng.smartschool.beans.TeacherBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:49
 * email xfengv@yeah.net
 */

public interface TeacherView {
    void addTeacher(List<TeacherBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();

}
