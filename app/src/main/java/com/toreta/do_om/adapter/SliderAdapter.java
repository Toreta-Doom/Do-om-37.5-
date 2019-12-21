package com.toreta.do_om.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private static int RC_SIGN_IN = 9001;


    private Context context;
    private ArrayList<Integer> layouts;

    public SliderAdapter(Context context, ArrayList<Integer> layouts) {

        this.context = context;
        this.layouts = layouts;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts.get(position), container, false);

        return view;

    }

    @Override
    public int getCount() {
        return layouts.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {

        View view = (View) object;
        container.removeView(view);

    }
}
