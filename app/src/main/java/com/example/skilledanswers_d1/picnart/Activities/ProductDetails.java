package com.example.skilledanswers_d1.picnart.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.skilledanswers_d1.picnart.Adapter.ViewpagerAdapter;
import com.example.skilledanswers_d1.picnart.Fragment.Features;
import com.example.skilledanswers_d1.picnart.Fragment.Overview;
import com.example.skilledanswers_d1.picnart.Fragment.Review;
import com.example.skilledanswers_d1.picnart.R;

public class ProductDetails extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    String[] frag_titles={"Overview","Features","Review"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setupViewPager(ViewPager viewPager) {
        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Overview(), frag_titles[0]);
        adapter.addFrag(new Features(),frag_titles[1]);
        adapter.addFrag(new Review(), frag_titles[2]);

        viewPager.setAdapter(adapter);
    }

}
