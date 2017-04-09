package com.xfeng.smartschool.Thacher.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.Thacher.presenter.TeacherPresentImpl;
import com.xfeng.smartschool.Thacher.view.TeacherView;
import com.xfeng.smartschool.beans.TeacherBean;
import com.xfeng.smartschool.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xfeng
 * data 17/3/27 20:54
 * email xfengv@yeah.net
 */

public class SmartServiceFragment extends Fragment implements TeacherView{
    private List<TeacherBean> mData;
    private static final String TAG = "SmartServiceFragment";
    private static final String PARAM = "param";
    private String mParam;
    private TeacherPresentImpl mTeacherPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_2_container, null);
        onRefresh();
        return view;
    }

    private void onRefresh() {
        mTeacherPresent.loadTeacherList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeacherPresent = new TeacherPresentImpl(this);
        if (getArguments() != null) {
            mParam = getArguments().getString(PARAM);
        }
    }


    public static SmartServiceFragment newInstance(String param) {
        SmartServiceFragment fragment = new SmartServiceFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void addTeacher(List<TeacherBean> list) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.clear();
        mData.addAll(list);

        ListIterator<TeacherBean> teacherBeanListIterator = mData.listIterator();
        while (teacherBeanListIterator.hasNext()){
            LogUtils.i(TAG,teacherBeanListIterator.next().getTeacher());
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg() {

    }
}
