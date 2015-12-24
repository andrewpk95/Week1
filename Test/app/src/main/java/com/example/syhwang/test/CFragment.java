package com.example.syhwang.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by syhwang on 2015. 12. 24..
 */
@SuppressWarnings("ValidFragment")
public class CFragment extends Fragment {
    Context mContext;

    public CFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_c, null);
        return view;
    }
}
