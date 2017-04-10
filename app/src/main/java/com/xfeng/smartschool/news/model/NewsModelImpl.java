package com.xfeng.smartschool.news.model;

import com.xfeng.smartschool.beans.NewsBean;
import com.xfeng.smartschool.beans.NewsDetailBean;
import com.xfeng.smartschool.commons.Urls;
import com.xfeng.smartschool.news.NewsJsonUtils;
import com.xfeng.smartschool.news.widget.NewsFragment;
import com.xfeng.smartschool.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/5 11:31
 * email xfengv@yeah.net
 */

public class NewsModelImpl implements NewsModel {
    public static  String TAG ="NewsModelImpl";
    @Override
    public void loadNews(String url, final int type, final OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {


            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    @Override
    public void loadNewsDetail(final String docid, final OnLoadNewsDetailListener listener) {
        String url = getDetailUrl(docid);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docid);
                listener.onSuccess(newsDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news detail info failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);

    }

    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        switch (type) {
            case NewsFragment.NEWS_TYPE_SCHOOL_NEWS:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_COMMUNICATE:
                id = Urls.NBA_ID;
                break;
            case NewsFragment.NEWS_TYPE_LEARNING:
                id = Urls.CAR_ID;
                break;
            case NewsFragment.NEWS_TYPE_JOB:
                id = Urls.JOKE_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }
        return id;
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }
}
