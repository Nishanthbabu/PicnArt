package com.example.skilledanswers_d1.picnart.Adapter;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.graphics.Paint;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.skilledanswers_d1.picnart.Model.SingleItemModel;
import com.example.skilledanswers_d1.picnart.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public ItemAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);

        holder.imageView.setImageResource(singleItem.get_image());
        holder.company.setText(""+singleItem.get_company());
        holder.name.setText(""+singleItem.get_Pname());
        holder.selling.setText(""+singleItem.get_sellingPrice());
        holder.actual.setText(""+singleItem.get_actualPrice());
        holder.ratingBar.setRating(Float.parseFloat(singleItem.get_rating()));
        holder.ratingBar.setIsIndicator(true);
        //// likeimages not used for present
        holder.likes.setText(""+singleItem.get_likes());
        /// share images not used for present
        holder.shares.setText(""+singleItem.get_shares());
        //// love image not used for present

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView=null;
        protected TextView company=null;
        protected TextView name=null;
        protected TextView selling=null;
        protected TextView actual=null;
        protected RatingBar ratingBar=null;
        protected ImageView likeImage=null;
        protected TextView likes=null;
        protected ImageView shareImage=null;
        protected TextView shares=null;
        protected ImageView loveImage=null;
        public SingleItemRowHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.list_singleimageview);
            this.company = (TextView) view.findViewById(R.id.list_singleCompanyText);
            this.name = (TextView) view.findViewById(R.id.list_singleNameText);
            this.selling = (TextView) view.findViewById(R.id.list_singleSellingText);
            this.actual = (TextView) view.findViewById(R.id.list_singleActualText);
            this.ratingBar=(RatingBar)view.findViewById(R.id.list_singlerating);
            this.likeImage = (ImageView) view.findViewById(R.id.list_singleThumbUpImage);
            this.likes = (TextView) view.findViewById(R.id.list_singlethumbUpCount);
            this.shareImage = (ImageView) view.findViewById(R.id.list_singleShareImage);
            this.shares = (TextView) view.findViewById(R.id.list_singleShareCount);
            this.loveImage = (ImageView) view.findViewById(R.id.list_singleLove);
            this.actual.setPaintFlags(this.actual.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}