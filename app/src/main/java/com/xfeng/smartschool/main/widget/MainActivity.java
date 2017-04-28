package com.xfeng.smartschool.main.widget;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xfeng.smartschool.R;
import com.xfeng.smartschool.aboutme.widget.AboutMeFragment;
import com.xfeng.smartschool.main.FragmentFactory;
import com.xfeng.smartschool.images.widget.ImageFragment;
import com.xfeng.smartschool.news.widget.NewsFragment;
import com.xfeng.smartschool.main.view.MainView;
import com.xfeng.smartschool.main.presenter.SidePresenter;
import com.xfeng.smartschool.main.presenter.SidePreshenterImpl;
import com.xfeng.smartschool.weather.widget.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;//代替监听器
    private RadioGroup mMainRadios;
    private static final String savedTab = "savedTab";
    private FrameLayout mFrameComtent;
    RadioButton mNewsButton;
    RadioButton mSmartServiceButton;
    RadioButton mStudentGuideButton;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private SidePresenter mSidePreshenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFragmentManager = getSupportFragmentManager();


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

        setupDrawerContent(mNavigationView);

        mSidePreshenter = new SidePreshenterImpl(this);
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
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                transaction.replace(R.id.frame_content, fragment);
                transaction.commit();
                if(mToolbar!=null){
                    mToolbar.setTitle(getToolBarName(checkedId));
                }
            }
        });
    }

    private int getToolBarName(int checkedId) {
        switch (checkedId){
            case R.id.radio_button1:
                return R.string.main_tab_first;
            case R.id.radio_button2:
                return R.string.main_tab_second;
            case R.id.radio_button3:
                return R.string.main_tab_third;
            default:
                return R.string.main_tab_first;
        }
    }

    private void initToolbar() {
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        //mToolbar.setSubtitle(R.string.main_tab_first);
        //mToolbar.setLogo(R.drawable.log_school);



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


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Log.i(TAG,menuItem.getItemId()+"");
                        mSidePreshenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    @Override
    public void switch2News() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        mToolbar.setTitle(R.string.navigation_news);
        mMainRadios.setVisibility(View.VISIBLE);
        Log.i(TAG,"切换到新闻");
    }

    @Override
    public void switch2Images() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImageFragment()).commit();
        mToolbar.setTitle(R.string.navigation_images);
        mMainRadios.setVisibility(View.GONE);
        Log.i(TAG,"切换到图片");
    }

    @Override
    public void switch2Weather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
        mToolbar.setTitle(R.string.navigation_weather);
        mMainRadios.setVisibility(View.GONE);
        Log.i(TAG,"切换到天气");
    }

    @Override
    public void switch2About() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutMeFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
        mMainRadios.setVisibility(View.GONE);
        Log.i(TAG,"切换到关于");
    }
}
