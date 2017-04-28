package com.xfeng.smartschool.Thacher.presenter;

import com.xfeng.smartschool.Thacher.model.OnLoadTeacherListListener;
import com.xfeng.smartschool.Thacher.model.TeacherModelImpl;
import com.xfeng.smartschool.Thacher.view.TeacherView;
import com.xfeng.smartschool.beans.TeacherBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 11:05
 * email xfengv@yeah.net
 */

public class TeacherPresentImpl implements TeacherPresent,OnLoadTeacherListListener{

    private  TeacherView teacherView;
    private final TeacherModelImpl mTeacherModel;

    public TeacherPresentImpl(TeacherView teacherView) {
        this.teacherView=teacherView;
        mTeacherModel = new TeacherModelImpl();
    }

    @Override
    public void loadTeacherList() {
        teacherView.showProgress();
        mTeacherModel.loadTeacherList(this);
    }

    @Override
    public void onSuccess(List<TeacherBean> list) {
        teacherView.addTeacher(list);
        teacherView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        teacherView.hideProgress();
        teacherView.showLoadFailMsg();
    }
}
