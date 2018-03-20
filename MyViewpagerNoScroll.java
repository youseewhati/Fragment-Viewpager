package com.example.admin.myapplication.Utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Admin on 2018/3/17.
 */

public class MyViewpagerNoScroll extends ViewPager {
//private boolean flag = true;

    public MyViewpagerNoScroll(Context context) {
        super(context);
    }

    public MyViewpagerNoScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
//    public void setViewPagerScroll(boolean flag){
//        this.flag = flag;
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
