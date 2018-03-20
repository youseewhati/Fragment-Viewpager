package com.example.admin.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.myapplication.fragment.HomeFragment;
import com.example.admin.myapplication.fragment.MyFragment;
import com.example.admin.myapplication.fragment.NewsFragment;
import com.example.admin.myapplication.fragment.ShoppingFragment;

public class MainActivity extends FragmentActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private int VIEWPAGER_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        vp = findViewById(R.id.main_vp);//初始化viewpager
        rg = findViewById(R.id.main_rg);//初始化底部按钮
//        RadioButton rb = findViewById(R.id.main_rb);
//        rb.setVisibility(View.INVISIBLE);
        //设置viewpager
        vp.setOffscreenPageLimit(VIEWPAGER_COUNT);//预加载几页
        vp.setAdapter(new RecyclerFragmentPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        rg.check(R.id.home);
        //底部按钮RadioGroup
        rg.setOnCheckedChangeListener(new myRadioGroupCheckedListener());
    }

    //rg选中监听
    class myRadioGroupCheckedListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.home:
                    vp.setCurrentItem(0,false);
                    break;
                case R.id.rg_news:
                    vp.setCurrentItem(1,false);
                    break;

                case R.id.shopping:
                    vp.setCurrentItem(2,false);
                    break;
                case R.id.my:
                    vp.setCurrentItem(3,false);
                    break;
            }

        }
    }

    /**
     * Fragment 有关的必须用V4包
     */

    class RecyclerFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public RecyclerFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HomeFragment.InstanceFragment();

                case 1:
                    return NewsFragment.InstanceFragment();

                case 2:
                    return ShoppingFragment.InstanceFragment();

                case 3:
                    return MyFragment.InstanceFragment();
                default:
                    return HomeFragment.InstanceFragment();
            }
        }

        @Override
        public int getCount() {
            return VIEWPAGER_COUNT;
        }
    }
}
