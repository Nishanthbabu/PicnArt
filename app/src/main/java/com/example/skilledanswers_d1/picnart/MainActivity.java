package com.example.skilledanswers_d1.picnart;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.skilledanswers_d1.picnart.Adapter.CategoryAdapter;
import com.example.skilledanswers_d1.picnart.Adapter.SlidingAdapter;
import com.example.skilledanswers_d1.picnart.Model.CategoriesModel;
import com.example.skilledanswers_d1.picnart.Model.SingleItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarLayout appBarLayout=null;
    private CollapsingToolbarLayout collapsingToolbarLayout=null;
    private ViewPager viewPager =null;
    private ImageButton btnNext, btnFinish;
    private LinearLayout pager_indicator;
    private RecyclerView my_recycler_view=null;
    private RecyclerView.LayoutManager layoutManager=null;
    ///////// references
    private SlidingAdapter viewPagerAdapter=null;
    //////////////////////////////////
    private int dotsCount;
    private ImageView[] dots;
    /////////// temp images source for the viewpager
    private int[] pagerImages={R.drawable.album_image,
            R.drawable.camara_image,
            R.drawable.painting_image1,
            R.drawable.painting_image2,
            R.drawable.painting_image3,
            R.drawable.painting_image4};
    private ArrayList<CategoriesModel> allSampleData=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createDummyData();
         my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        CategoryAdapter adapter = new CategoryAdapter(this, allSampleData);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setAdapter(adapter);
        my_recycler_view.setHasFixedSize(true);
        //////////////////


        //////////
        appBarLayout=(AppBarLayout)findViewById(R.id.appbar_picnArtID);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsableToolbar_picnArtID);
        viewPager =(ViewPager)findViewById(R.id.pager_introduction);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        //////////
        viewPagerAdapter = new SlidingAdapter(this, pagerImages);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
                }
                dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUiPageViewController();
        /////////////////




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    /////////////////////////
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //////////////////////////////////////////////////

    private void setUiPageViewController() {

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    private void createDummyData() {
//
        String[] categories={"Todays Deal","Arts","Jewellery","Books","Camera","Pictures"};
        ////
        String[] company={"Flipcart","Dhamakha"};
        String[] name={"painting","picture"};
        String[] sellingPrice={"Rs.1,300","Rs.2000"};
        String[] actualPrice={"Rs.1,600","Rs.2500"};
        String[] rating={"2","5"};
        String[] likes={"10","500"};
        String[] share={"100","200"};
        String[] specification1={"android","windows"};
        String[] specification2={"android","windows"};
        String[] specification3={"android","windows"};
        boolean[] love={false,true};
        for(int i=0;i<categories.length;i++)
        {
            CategoriesModel categoriesModel=new CategoriesModel();
            categoriesModel.set_categoryTitle(categories[i]);
            ArrayList<SingleItemModel> singleItemModels=new ArrayList<>();
            for(int j=0;j<company.length;j++)
            {
                singleItemModels.add(new SingleItemModel(pagerImages[j],company[j],
                        name[j],sellingPrice[j],actualPrice[j],rating[j],likes[j],share[j],love[j],categories[i]
                ,specification1[j],specification2[j],specification3[j]));
            }
            categoriesModel.setAllItemsInSection(singleItemModels);
            allSampleData.add(categoriesModel);
        }




    }
}
