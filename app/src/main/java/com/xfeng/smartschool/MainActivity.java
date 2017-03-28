package com.xfeng.smartschool;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xfeng.smartschool.fragment.NewsFragment;
import com.xfeng.smartschool.fragment.SmartServiceFragment;
import com.xfeng.smartschool.fragment.StudentGuideFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "XFeng";
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;//代替监听器
    private RadioGroup mMainRadios;
    private static final String savedTab = "savedTab";
    private FrameLayout mFrameComtent;
    RadioButton mNewsButton;
    RadioButton mSmartServiceButton;
    RadioButton mStudentGuideButton;
    private FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            if (position == R.id.radio_button1) {
                return NewsFragment.newInstance("FirstFragment");
            } else if (position == R.id.radio_button2) {
                return SmartServiceFragment.newInstance("SecondFragment");
            } else {
                return StudentGuideFragment.newInstance("ThirdFragment");
            }
        }
        @Override
        public int getCount() {
            return 3;
        }
    };
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
        setListener();
        initToolbar();

        if (savedInstanceState == null) {
            //默认将第一个RadioButton设为选中
            mNewsButton.performClick();
        } else {
            RadioButton radioButton = (RadioButton) findViewById(savedInstanceState.getInt(savedTab));
            radioButton.performClick();
        }
    }

    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMainRadios = (RadioGroup) findViewById(R.id.main_radios);
        mFrameComtent = (FrameLayout) findViewById(R.id.frame_content);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNewsButton = (RadioButton) findViewById(R.id.radio_button1);
        mSmartServiceButton = (RadioButton) findViewById(R.id.radio_button2);
        mStudentGuideButton = (RadioButton) findViewById(R.id.radio_button3);
    }

    private void setListener() {
        mMainRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.i(TAG,"选中 "+checkedId);
                checked(checkedId);
            }
        });
    }

    private void checked(int checkedId) {
        Fragment fragment =
                (Fragment) mFragmentPagerAdapter.instantiateItem(mFrameComtent, checkedId);
        mFragmentPagerAdapter.setPrimaryItem(mFrameComtent, checkedId, fragment);
        mFragmentPagerAdapter.finishUpdate(mFrameComtent);
    }

    private void initToolbar() {
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        mToolbar.setNavigationIcon(R.drawable.ic_menu);


        //setTile 要在下面这句话上面，不然会失效
        setSupportActionBar(mToolbar);

        //监听DrawerLayout
        //将抽屉事件和 toolbar联系起来，这是 material design 的设计
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(savedTab, mMainRadios.getCheckedRadioButtonId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int position = savedInstanceState.getInt(MainActivity.savedTab);
        checked(position);
    }
}
