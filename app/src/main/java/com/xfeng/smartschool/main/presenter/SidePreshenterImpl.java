package com.xfeng.smartschool.main.presenter;

import android.util.Log;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.main.view.MainView;

/**
 * Created by xfeng
 * data 17/4/2 16:03
 * email xfengv@yeah.net
 */

public class SidePreshenterImpl implements SidePresenter {
    private static final String TAG = "SidePreshenterImpl:";
    private MainView mSideMenu;

    public SidePreshenterImpl(MainView sideMenu) {
        this.mSideMenu = sideMenu;
    }

    @Override
    public void switchNavigation(int id) {
        Log.i(TAG, id + "");
        switch (id) {
            case R.id.navigation_item_news:
                Log.i(TAG, "切换到新闻"+R.id.navigation_item_news);
                mSideMenu.switch2News();
                break;
            case R.id.navigation_item_images:
                Log.i(TAG, "切换到组图"+R.id.navigation_item_images);
                mSideMenu.switch2Images();
                break;
            case R.id.navigation_item_weather:
                Log.i(TAG, "切换到天气"+R.id.navigation_item_weather);
                mSideMenu.switch2Weather();
                break;
            case R.id.navigation_item_about:
                Log.i(TAG, "切换到关于"+R.id.navigation_item_about);
                mSideMenu.switch2About();
                break;
            default:
                mSideMenu.switch2News();
                break;
        }
    }
}
