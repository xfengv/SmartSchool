package com.xfeng.smartschool.books.view;

import com.xfeng.smartschool.beans.Meizi;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:49
 * email xfengv@yeah.net
 */

public interface TeacherView {
    void addTeacher(List<Meizi> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();

}
