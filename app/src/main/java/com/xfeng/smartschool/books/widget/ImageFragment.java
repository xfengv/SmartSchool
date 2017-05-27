package com.xfeng.smartschool.books.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.Thacher.widget.SmartServiceFragment;
import com.xfeng.smartschool.beans.Meizi;
import com.xfeng.smartschool.books.presenter.TeacherPresentImpl;
import com.xfeng.smartschool.books.view.TeacherView;
import com.xfeng.smartschool.commons.Urls;
import com.xfeng.smartschool.news.widget.NewsDetileActivity;
import com.xfeng.smartschool.utils.LogUtils;
import com.xfeng.smartschool.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xfeng
 * data 17/3/27 20:54
 * email xfengv@yeah.net
 */

public class ImageFragment extends Fragment implements TeacherView {
    private List<Meizi> mData;
    private static final String TAG = "SmartServiceFragment";
    private static final String PARAM = "param";
    private String mParam;
    private TeacherPresentImpl mTeacherPresent;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private Context mContext;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_2_container, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //mLinearLayoutManager = new LinearLayoutManager(mContext);
        //mGridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());



        mMyAdapter = new MyAdapter(mContext);
        mMyAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), NewsDetileActivity.class);
                intent.putExtra("url",Urls.HOST+"smartschool/book/bookde.html");
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mMyAdapter);

        SpacesItemDecoration decoration=new SpacesItemDecoration(6);
        mRecyclerView.addItemDecoration(decoration);

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
    public void addTeacher(List<Meizi> list) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.clear();
        mData.addAll(list);

        mMyAdapter.setmDate(mData);



        ListIterator<Meizi> teacherBeanListIterator = mData.listIterator();
        while (teacherBeanListIterator.hasNext()){
            LogUtils.i(TAG,teacherBeanListIterator.next().getUrl());
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
