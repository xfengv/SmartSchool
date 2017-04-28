package com.xfeng.smartschool.beans;

/**
 * Created by xfeng
 * data 17/4/8 10:39
 * email xfengv@yeah.net
 */

public class TeacherBean {
    /**
     * 老师姓名
     */
    private String teacher;
    /**
     * 课程名称
     */
    private String course;
    /**
     * 信息分类
     */
    private String tab;
    /**
     * 标题
     */
    private String title;
    /**
     * 学院
     */
    private String major;
    /**
     * 时间
     */
    private String time;
    /**
     * url
     */
    private String url;

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
