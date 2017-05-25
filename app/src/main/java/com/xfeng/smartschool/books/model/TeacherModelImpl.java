package com.xfeng.smartschool.books.model;

import com.xfeng.smartschool.beans.Meizi;
import com.xfeng.smartschool.books.TeacherJsonUtils;
import com.xfeng.smartschool.commons.Urls;
import com.xfeng.smartschool.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:52
 * email xfengv@yeah.net
 */

public class TeacherModelImpl implements ThacherModel {
    @Override
    public void loadTeacherList(final OnLoadTeacherListListener listener) {
        String teacherUrl = Urls.BOOK_URL;
        OkHttpUtils.ResultCallback<String> resultCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<Meizi> teacherBeenList = TeacherJsonUtils.readJsonTeacherBean(response);
                listener.onSuccess(teacherBeenList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load Teacher list failure.", e);
            }
        };
        OkHttpUtils.get(teacherUrl,resultCallback);
    }
}
