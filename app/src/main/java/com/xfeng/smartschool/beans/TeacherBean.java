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
    private String imageuri;
    /**
     * 标题
     */
    private String title;
    /**
     * 信息分类
     */
    private String major;
    /**
     * 时间
     */
    private String time;
    /**
     * url
     */
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

    public String getImageuri() {
        return imageuri;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
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
