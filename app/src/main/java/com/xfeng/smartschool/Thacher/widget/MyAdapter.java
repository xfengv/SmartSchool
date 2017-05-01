package com.xfeng.smartschool.Thacher.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.beans.TeacherBean;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/9 10:41
 * email xfengv@yeah.net
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MusicListHolder> {


    private final Context mContext;
    private List<TeacherBean> mData;
    private final LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;

    MyAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setmDate(List<TeacherBean> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }



    @Override
    public MusicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teacher, null);
        MusicListHolder musicListHolder = new MusicListHolder(view);
        return musicListHolder;
    }



    @Override
    public void onBindViewHolder(MusicListHolder holder, int position) {
        TeacherBean musicInfo = mData.get(position);
        if (musicInfo == null) {
            return;
        }
        switch (musicInfo.getTab()) {
            case "课后作业":
                holder.mItemBackground.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_corner_pop));
                break;
            case "教学动态":
                holder.mItemBackground.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_corner_green));
                break;
            case "老师要求":
                 holder.mItemBackground.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_corner_yell));
                break;
            default:
                break;
        }

         holder.mContent.setText(musicInfo.getMajor());
         holder.mCourse.setText(musicInfo.getCourse());
         holder.mMItemTitie.setText(musicInfo.getTitle());
         holder.mTab.setText(musicInfo.getTab());
         holder.mTime.setText(musicInfo.getTime());
         holder.mTeacherName.setText(musicInfo.getTeacher());
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    class MusicListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mContent;
        TextView mTab;
        TextView mMItemTitie;
        TextView mTeacherName;
        TextView mCourse;
        TextView mTime;
        LinearLayout mItemBackground;

        public MusicListHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.item_content);
            mMItemTitie = (TextView) itemView.findViewById(R.id.item_titie);
            mTab = (TextView) itemView.findViewById(R.id.tab);
            mTeacherName = (TextView) itemView.findViewById(R.id.teacher_name);
            mCourse = (TextView) itemView.findViewById(R.id.course);
            mTime = (TextView) itemView.findViewById(R.id.time);
            mItemBackground = (LinearLayout) itemView.findViewById(R.id.item_background);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}
