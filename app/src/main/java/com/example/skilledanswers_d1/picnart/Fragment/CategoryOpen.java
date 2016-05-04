package com.example.skilledanswers_d1.picnart.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.skilledanswers_d1.picnart.Adapter.CategoryAdapter;
import com.example.skilledanswers_d1.picnart.Adapter.SeeAllAdapter;
import com.example.skilledanswers_d1.picnart.Model.CategoriesModel;
import com.example.skilledanswers_d1.picnart.R;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 04-05-2016.
 */
public class CategoryOpen extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView=null;
    private SeeAllAdapter adapter=null;
    private RecyclerView.LayoutManager layoutManager=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycleview_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleviewFragmentID);



        adapter=new SeeAllAdapter(getActivity(), CategoryAdapter.passCategoryModel);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);



        return view;
    }
}
