package com.xfeng.smartschool.studentGuid.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bm.library.PhotoView;
import com.xfeng.smartschool.R;

/**
 * Created by xfeng
 * data 17/3/27 20:56
 * email xfengv@yeah.net
 */

public class StudentGuideFragment extends Fragment {
    private static final String PARAM = "param";
    private String mParam;
    private PhotoView mSchoolMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_3_container, null);
        mSchoolMap = (PhotoView) view.findViewById(R.id.school_map);
        mSchoolMap.enable();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(PARAM);
        }
    }


    public static StudentGuideFragment newInstance(String param) {
        StudentGuideFragment fragment = new StudentGuideFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
