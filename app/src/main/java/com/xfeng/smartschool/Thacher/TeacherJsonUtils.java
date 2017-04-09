package com.xfeng.smartschool.Thacher;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xfeng.smartschool.beans.TeacherBean;
import com.xfeng.smartschool.utils.JsonUtils;
import com.xfeng.smartschool.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xfeng
 * data 17/4/8 10:57
 * email xfengv@yeah.net
 */

public class TeacherJsonUtils {
    private final static String TAG = "ImageJsonUtils";
    /**
     * 将获取到的json转换为图片列表对象
     * @param res
     * @return
     */
    public static List<TeacherBean> readJsonTeacherBean(String res) {
        List<TeacherBean> beans = new ArrayList<TeacherBean>();
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(res).getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                TeacherBean news = JsonUtils.deserialize(jo, TeacherBean.class);
                beans.add(news);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "TeacherBeanBeans error", e);
        }
        return beans;
    }
}
