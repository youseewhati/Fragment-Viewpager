package com.example.admin.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Admin on 2018/3/17.
 */

public class HomeFragment extends Fragment {

    private View view;
    private ListView listView;
    private ArrayList list;

    public static HomeFragment InstanceFragment(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home_fm, null);
        list = new ArrayList<>();
        for (int i = 0; i<=200; i++){
            list.add(i);
        }

        listView = view.findViewById(R.id.home_lv);
        listView.setAdapter(new myAdapter());
        return view;
    }
    class myAdapter extends BaseAdapter{

        private TextView textView;

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            textView = new TextView(getContext());
            textView.setText(list.get(position)+"");
            textView.setTextColor(Color.RED);
            return textView;
        }
    }
}
