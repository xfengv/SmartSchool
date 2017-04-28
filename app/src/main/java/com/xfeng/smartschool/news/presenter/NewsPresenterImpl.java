package com.xfeng.smartschool.news.presenter;

import com.xfeng.smartschool.beans.NewsBean;
import com.xfeng.smartschool.commons.Urls;
import com.xfeng.smartschool.news.model.NewsModel;
import com.xfeng.smartschool.news.model.NewsModelImpl;
import com.xfeng.smartschool.news.model.OnLoadNewsListListener;
import com.xfeng.smartschool.news.view.NewsView;
import com.xfeng.smartschool.news.widget.NewsFragment;
import com.xfeng.smartschool.utils.LogUtils;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/5 11:33
 * email xfengv@yeah.net
 */

public class NewsPresenterImpl implements NewsPresenter,OnLoadNewsListListener{

    private static final String TAG = "NewsPresenterImpl";

    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenterImpl(NewsView newsView) {
        this.mNewsView = newsView;
        this.mNewsModel = new NewsModelImpl();
    }


    @Override
    public void loadNews(final int type,final int page) {
        String url = getUrl(type, page);
        LogUtils.d(TAG, url);
        //只有第一页的或者刷新的时候才显示刷新进度条
        if(page == 0) {
            mNewsView.showProgress();
        }
        mNewsModel.loadNews(url, type, this);
    }

    /**
     * 根据类别和页面索引创建url
     * @param type
     * @param page
     * @return
     */
    private String getUrl(int type, int page) {
        StringBuffer sb = new StringBuffer();
        switch (type) {
            case NewsFragment.NEWS_TYPE_SCHOOL_NEWS:
                sb.append(Urls.TOP_URL).append(Urls.NEWS_ID).append(Urls.NEWS_JSON);
                break;
            case NewsFragment.NEWS_TYPE_COMMUNICATE:
                sb.append(Urls.COMMON_URL).append(Urls.COMMUN_ID).append(Urls.COMMUN_JSON);
                break;
            case NewsFragment.NEWS_TYPE_LEARNING:
                sb.append(Urls.COMMON_URL).append(Urls.LEARN_ID).append(Urls.LEARN_JSON);
                break;
            case NewsFragment.NEWS_TYPE_JOB:
                sb.append(Urls.COMMON_URL).append(Urls.JOB_ID).append(Urls.JOB_JSON);
                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.NEWS_ID).append(Urls.NEWS_JSON);
                break;
        }
        return sb.toString();
    }


    //加载数据成功OnLoadNewsListListener的回调
    @Override
    public void onSuccess(List<NewsBean> list) {
        mNewsView.hideProgress();
        mNewsView.addNews(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsView.hideProgress();
        mNewsView.showLoadFailMsg();
    }
}
