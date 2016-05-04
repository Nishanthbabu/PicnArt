package com.example.skilledanswers_d1.picnart.Adapter;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.content.Intent;
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


import com.example.skilledanswers_d1.picnart.Activities.ProductDetails;
import com.example.skilledanswers_d1.picnart.Fragment.CategoryOpen;
import com.example.skilledanswers_d1.picnart.Model.CategoriesModel;
import com.example.skilledanswers_d1.picnart.Model.SingleItemModel;
import com.example.skilledanswers_d1.picnart.R;
import com.example.skilledanswers_d1.picnart.RecyclerItemClickListener;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemRowHolder> {

    private ArrayList<CategoriesModel> dataList;
    private Context mContext;
    public static ArrayList<CategoriesModel> passCategoryModel=null;

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
    public void onBindViewHolder(ItemRowHolder itemRowHolder, final int position) {

        final String sectionName = dataList.get(position).get_categoryTitle();

        final ArrayList<SingleItemModel> singleSectionItems = dataList.get(position).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);

        ItemAdapter itemListDataAdapter = new ItemAdapter(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
        itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
        ///////////
        itemRowHolder.recycler_view_list.addOnItemTouchListener(new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                private int _image=0;
//                private String _company=null;
//                private String _Pname=null;
//                private String _sellingPrice=null;
//                private String _actualPrice=null;
//                private String _rating=null;
//                private String _likes=null;
//                private String _shares=null;
//                private boolean _love=false;
//                private String _cvategory=null;
//                private String _specification1=null;
//                private String _specification2=null;
//                private String _specification3=null;
                Intent intent=new Intent(mContext, ProductDetails.class);
                intent.putExtra("CATEGORY_ADAPTER_PIMAGE",singleSectionItems.get(position).get_image());
                intent.putExtra("CATEGORY_ADAPTER_PCOMPANY",singleSectionItems.get(position).get_company());
                intent.putExtra("CATEGORY_ADAPTER_PNAME",singleSectionItems.get(position).get_Pname());
                intent.putExtra("CATEGORY_ADAPTER_PSELLINGPRICE",singleSectionItems.get(position).get_sellingPrice());
                intent.putExtra("CATEGORY_ADAPTER_PACTUALPRICE",singleSectionItems.get(position).get_actualPrice());
                intent.putExtra("CATEGORY_ADAPTER_PRATING",singleSectionItems.get(position).get_rating());
                intent.putExtra("CATEGORY_ADAPTER_PLIKES",singleSectionItems.get(position).get_likes());
                intent.putExtra("CATEGORY_ADAPTER_PSHARES",singleSectionItems.get(position).get_shares());
                intent.putExtra("CATEGORY_ADAPTER_PLOVE",singleSectionItems.get(position).get_love());
                intent.putExtra("CATEGORY_ADAPTER_PCATEGORY",singleSectionItems.get(position).get_cvategory());
                intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION1",singleSectionItems.get(position).get_specification1());
                intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION2",singleSectionItems.get(position).get_specification2());
                intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION3",singleSectionItems.get(position).get_specification3());
                System.out.println("ooooooooooooooootitle "+singleSectionItems.get(position).get_sellingPrice());
                mContext.startActivity(intent);

            }
        }));
        itemRowHolder.btnMore.setBackgroundColor(Color.TRANSPARENT);
        itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(mContext, Recycleview_activity.class);
////                intent.putExtra("WHICHCATEGORY",dataList.get(i).get_categoryTitle());
                ArrayList<CategoriesModel> arrayList=new ArrayList<CategoriesModel>();
                for(int j=0;j<dataList.get(position).getAllItemsInSection().size();j++)
                {
                    if(dataList.get(j).get_categoryTitle().
                            equals(dataList.get(j).getAllItemsInSection().get(j).get_cvategory()))
                    {
                        arrayList.add(new CategoriesModel(dataList.get(j).get_categoryTitle(),
                                dataList.get(j).getAllItemsInSection()));
                    }
                }

                Fragment fragment=new CategoryOpen();
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