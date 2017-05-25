package com.xfeng.smartschool.commons;

/**
 * Description : 接口API的URL
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/13
 */
public class Urls {

    //http://c.m.163.com/nc/article/headline/T1348647909107/0-5.html  头条

    public static final int PAZE_SIZE = 20;

    //public static final String HOST = "http://c.m.163.com/";
    public static final String HOST = "http://10.0.2.2:8080/";

    public static final String END_DETAIL_URL = "/full.html";


    public static final String BOOK_URL = HOST+"smartschool/book/book.json";






    public static final String TOP_URL = HOST + "smartschool/news/";
    // 新闻详情
    public static final String NEW_DETAIL = HOST + "smartschool/news/";

    public static final String COMMON_URL = HOST + "smartschool/news/";




    public static final String NEWS_ID = "shcoolnews";

    public static final String COMMUN_ID = "communicate";

    public static final String LEARN_ID = "learning";

    public static final String JOB_ID = "job";



    public static final String NEWS_JSON = "/schoolnews1.json";
    // 汽车
    public static final String COMMUN_JSON = "/communicate2.json";
    // 笑话
    public static final String LEARN_JSON = "/learning2.json";
    // nba
    public static final String JOB_JSON = "/job2.json";






    //智慧服务
    public static final String SMART_SERVICR = HOST+"/smartschool/smartservice1.json";

    // 图片
    public static final String IMAGES_URL = "http://10.0.2.2:8080/zhbj/photos/photos_1.json";

    // 天气预报url
    public static final String WEATHER = "http://wthrcdn.etouch.cn/weather_mini?city=";

    //百度定位
    public static final String INTERFACE_LOCATION = "http://api.map.baidu.com/geocoder";

}
