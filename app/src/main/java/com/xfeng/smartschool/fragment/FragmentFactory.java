package com.xfeng.smartschool.fragment;

import android.support.v4.app.Fragment;

import com.xfeng.smartschool.R;

/**
 * Created by xfeng
 * data 17/3/29 11:18
 * email xfengv@yeah.net
 */

public class FragmentFactory {
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case R.id.radio_button1:
                fragment = NewsFragment.newInstance("FirstFragment");
                break;
            case R.id.radio_button2:
                fragment = SmartServiceFragment.newInstance("SecondFragment");
                break;
            case R.id.radio_button3:
                fragment = StudentGuideFragment.newInstance("ThirdFragment");
                break;
        }
        return fragment;
    }
}
