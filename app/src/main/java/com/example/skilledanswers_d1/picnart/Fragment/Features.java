package com.example.skilledanswers_d1.picnart.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skilledanswers_d1.picnart.R;

/**
 * Created by SkilledAnswers-D1 on 04-05-2016.
 */
public class Features  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.features,container,false);
        return view;
    }
}
