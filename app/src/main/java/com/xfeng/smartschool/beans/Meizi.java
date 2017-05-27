package com.xfeng.smartschool.beans;

/**
 * Created by xfengimac
 * data 2017/4/30 16:38
 * email xfengv@yeah.net
 */

public class Meizi {

    private String url;//图片地址
    private int page;//页数
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
