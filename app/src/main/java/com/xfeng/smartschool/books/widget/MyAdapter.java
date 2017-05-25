package com.xfeng.smartschool.books.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.beans.Meizi;
import com.xfeng.smartschool.utils.ImageLoaderUtils;
import com.xfeng.smartschool.utils.LogUtils;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/9 10:41
 * email xfengv@yeah.net
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MusicListHolder> {



    private static String TAG="Book:MyAdapter";
    private final Context mContext;
    private List<Meizi> mData;
    private final LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;

    MyAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setmDate(List<Meizi> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }



    @Override
    public MusicListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.grid_meizi_item, null);
        MusicListHolder musicListHolder = new MusicListHolder(view);
        return musicListHolder;
    }



    @Override
    public void onBindViewHolder(MusicListHolder holder, int position) {
        Meizi musicInfo = mData.get(position);
        if (musicInfo == null) {
            return;
        }
        String imageurl= musicInfo.getUrl();
        LogUtils.i(TAG,"getImgsrc"+imageurl);
        ImageLoaderUtils.display(mContext, holder.mImageButton, imageurl);
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

        ImageButton mImageButton;

        public MusicListHolder(View itemView) {
            super(itemView);
            mImageButton = (ImageButton) itemView.findViewById(R.id.iv);
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
