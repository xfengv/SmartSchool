package com.xfeng.smartschool.Thacher.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfeng.smartschool.R;

/**
 * Created by xfeng
 * data 17/3/27 20:54
 * email xfengv@yeah.net
 */

public class SmartServiceFragment extends Fragment {
    private static final String PARAM = "param";
    private String mParam;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_2_container, null);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
