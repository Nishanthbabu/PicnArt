package com.example.skilledanswers_d1.picnart.Adapter;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.skilledanswers_d1.picnart.Fragment.CategoryOpen;
import com.example.skilledanswers_d1.picnart.Model.CategoriesModel;
import com.example.skilledanswers_d1.picnart.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemRowHolder> {

    private ArrayList<CategoriesModel> dataList;
    private Context mContext;
    public static ArrayList<CategoriesModel>passCategoryModel=null;

    public CategoryAdapter(Context context, ArrayList<CategoriesModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, final int i) {

        final String sectionName = dataList.get(i).get_categoryTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);

        ItemAdapter itemListDataAdapter = new ItemAdapter(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
        itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
        itemRowHolder.btnMore.setBackgroundColor(Color.TRANSPARENT);
        itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(mContext, Recycleview_activity.class);
////                intent.putExtra("WHICHCATEGORY",dataList.get(i).get_categoryTitle());
                ArrayList<CategoriesModel> arrayList=new ArrayList<CategoriesModel>();
                for(int j=0;j<dataList.get(i).getAllItemsInSection().size();j++)
                {
                    if(dataList.get(j).get_categoryTitle().
                            equals(dataList.get(j).getAllItemsInSection().get(j).get_cvategory()))
                    {
                        arrayList.add(new CategoriesModel(dataList.get(j).get_categoryTitle(),
                                dataList.get(j).getAllItemsInSection()));
                    }
                }
//                intent.putParcelableArrayListExtra("ARRAYLIST",arrayList);
//                intent.putExtra("CATEGORYTITLE",dataList.get(i).get_categoryTitle());
//                mContext.startActivity(intent);
                Fragment fragment=new CategoryOpen();
//                Bundle bundle=new Bundle();
//                bundle.putParcelableArrayList("ARRAYLIST",arrayList);
//                bundle.putString("CATEGORYTITLE",dataList.get(i).get_categoryTitle());
//                fragment.setArguments(bundle);
                passCategoryModel=arrayList;
                FragmentTransaction transaction=((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null);

                transaction.replace(R.id.content_main,fragment);
                transaction.commit();




            }
        });







       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;



        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) view.findViewById(R.id.btnMore);


        }

    }

}