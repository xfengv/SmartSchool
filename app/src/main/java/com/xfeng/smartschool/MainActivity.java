package com.xfeng.smartschool;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.xfeng.smartschool.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "XFeng";
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;//代替监听器
    private RadioGroup mMainRadios;
    private FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            if (position == R.id.rb_tab_common) {
                return NewsFragment.newInstance("FirstFragment");
            } else if (position == R.id.rb_tab_sale) {
                return NewsFragment.newInstance("FirstFragment");
            } else {
                return NewsFragment.newInstance("FirstFragment");
            }
        }
        @Override
        public int getCount() {
            return 3;
        }
    };
    private FrameLayout mFrameComtent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
        setListener();
        initToolbar();
    }

    private void setListener() {
        mMainRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.i(TAG,"选中 "+checkedId);
                Fragment fragment =
                        (Fragment) mFragmentPagerAdapter.instantiateItem(mFrameComtent, checkedId);
                mFragmentPagerAdapter.setPrimaryItem(mFrameComtent, checkedId, fragment);
                mFragmentPagerAdapter.finishUpdate(mFrameComtent);
            }
        });
    }

    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMainRadios = (RadioGroup) findViewById(R.id.main_radios);
        mFrameComtent = (FrameLayout) findViewById(R.id.frame_content);
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
}
