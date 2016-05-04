package com.example.skilledanswers_d1.picnart.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.skilledanswers_d1.picnart.R;

/**
 * Created by SkilledAnswers-D1 on 04-05-2016.
 */
public class Overview  extends Fragment{
    /////////////////////////////////////////////////////
    private TextView productName=null;
    private ImageView productImage=null;
    private TextView productSellingPrice=null,productActualPrice=null,company=null;
    private RatingBar ratingBar=null;
    private ImageView loveImageview=null,addtoCartImageView=null,giftitemImageview=null;
    private TextView specification1TextView=null,specification2TextView=null,specification3TextView=null;
    private Button rentKnowButton=null,buyknowButton=null;
    private RecyclerView releventProductRecycleview=null,accesseroriesRecycleview=null;
    ////////////////////////////////////////////////
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.overview,container,false);
        productName=(TextView)view.findViewById(R.id.overviewProductNameID);
        productImage=(ImageView)view.findViewById(R.id.overviewProductImageID);
        productSellingPrice=(TextView) view.findViewById(R.id.overviewSellingPriceID);
        productActualPrice=(TextView) view.findViewById(R.id.overviewActualPriceID);
        company=(TextView) view.findViewById(R.id.overviewCompanyID);
        ratingBar=(RatingBar)view.findViewById(R.id.overviewRattingBar);
        loveImageview=(ImageView)view.findViewById(R.id.overview_loveID);
        addtoCartImageView=(ImageView)view.findViewById(R.id.overview_cartID);
        giftitemImageview=(ImageView)view.findViewById(R.id.overview_giftID);
        specification1TextView=(TextView) view.findViewById(R.id.overviewSpecification1ID);
        specification2TextView=(TextView) view.findViewById(R.id.overviewSpecification2ID);
        specification3TextView=(TextView) view.findViewById(R.id.overviewSpecification3ID);
        rentKnowButton=(Button)view.findViewById(R.id.overviewRentKnowButtonID);
        buyknowButton=(Button)view.findViewById(R.id.overviewBuyKnowButtonId);
        releventProductRecycleview=(RecyclerView)view.findViewById(R.id.overviewRecycleviewReleventProductId);
        accesseroriesRecycleview=(RecyclerView)view.findViewById(R.id.overviewRecycleviewAccessoriesId);
//        intent.putExtra("CATEGORY_ADAPTER_PIMAGE",singleSectionItems.get(position).get_image());
//        intent.putExtra("CATEGORY_ADAPTER_PCOMPANY",singleSectionItems.get(position).get_company());
//        intent.putExtra("CATEGORY_ADAPTER_PNAME",singleSectionItems.get(position).get_Pname());
//        intent.putExtra("CATEGORY_ADAPTER_PSELLINGPRICE",singleSectionItems.get(position).get_sellingPrice());
//        intent.putExtra("CATEGORY_ADAPTER_PACTUALPRICE",singleSectionItems.get(position).get_actualPrice());
//        intent.putExtra("CATEGORY_ADAPTER_PRATING",singleSectionItems.get(position).get_rating());
//        intent.putExtra("CATEGORY_ADAPTER_PLIKES",singleSectionItems.get(position).get_likes());
//        intent.putExtra("CATEGORY_ADAPTER_PSHARES",singleSectionItems.get(position).get_shares());
//        intent.putExtra("CATEGORY_ADAPTER_PLOVE",singleSectionItems.get(position).get_love());
//        intent.putExtra("CATEGORY_ADAPTER_PCATEGORY",singleSectionItems.get(position).get_cvategory());
//        intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION1",singleSectionItems.get(position).get_specification1());
//        intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION2",singleSectionItems.get(position).get_specification2());
//        intent.putExtra("CATEGORY_ADAPTER_PSEPCIFICATION3",singleSectionItems.get(position).get_specification3());
        //////// setting the data
        productName.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PNAME"));
        productImage.setImageResource(getActivity().getIntent().getIntExtra("CATEGORY_ADAPTER_PIMAGE",0));
        productSellingPrice.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PSELLINGPRICE"));
        productActualPrice.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PACTUALPRICE"));
        ratingBar.setRating(Float.parseFloat(getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PRATING")));
        specification1TextView.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PSEPCIFICATION1"));
        specification2TextView.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PSEPCIFICATION2"));
        specification3TextView.setText(""+getActivity().getIntent().getStringExtra("CATEGORY_ADAPTER_PSEPCIFICATION3"));


        return view;
    }
}
