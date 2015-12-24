package com.example.syhwang.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by syhwang on 2015. 12. 24..
 */
@SuppressWarnings("ValidFragment")
public class BFragment extends Fragment{

    Context mContext;

    public BFragment(Context context) {
        mContext = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_b, null);
        return view;
    }
}
