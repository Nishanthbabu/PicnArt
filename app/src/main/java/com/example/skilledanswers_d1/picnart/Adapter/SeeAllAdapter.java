package com.example.skilledanswers_d1.picnart.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.skilledanswers_d1.picnart.Model.CategoriesModel;
import com.example.skilledanswers_d1.picnart.R;
import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 03-05-2016.
 */
public class SeeAllAdapter extends RecyclerView.Adapter<SeeAllAdapter.Holder> {
    private Context context=null;
    private ArrayList<CategoriesModel> categoriesModels=null;

    public SeeAllAdapter(Context context, ArrayList<CategoriesModel> categoriesModels) {
        this.context = context;
        this.categoriesModels = categoriesModels;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.see_all_row, null);
        Holder mh = new Holder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        try {
            CategoriesModel model = categoriesModels.get(position);
            holder.imageView.setImageResource(model.getAllItemsInSection().get(position).get_image());
            System.out.println("oooooooooooooooooooooooooooooooooooo " + model.getAllItemsInSection().get(position).get_Pname());
            holder.pName.setText(model.getAllItemsInSection().get(position).get_Pname());
            holder.sellingPrice.setText(model.getAllItemsInSection().get(position).get_sellingPrice());
            holder.actualPrice.setText(model.getAllItemsInSection().get(position).get_actualPrice());
            holder.companyName.setText(model.getAllItemsInSection().get(position).get_company());
            holder.ratingBar.setRating(Float.parseFloat(model.getAllItemsInSection().get(position).get_rating()));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return categoriesModels.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        protected ImageView imageView=null;
        protected TextView pName=null;
        protected  TextView actualPrice=null;
        protected  TextView sellingPrice=null;
        protected  TextView companyName=null;
        protected RatingBar ratingBar=null;
        public Holder(View itemView) {
            super(itemView);
            this.imageView=(ImageView)itemView.findViewById(R.id.seeall_imageview);
            this.pName =(TextView)itemView.findViewById(R.id.seeall_pname);
            this.actualPrice=(TextView)itemView.findViewById(R.id.seeall_actualprice);
            this.sellingPrice=(TextView)itemView.findViewById(R.id.seeall_sellingprice);
            this.companyName=(TextView)itemView.findViewById(R.id.seeall_companyname);
            this.ratingBar=(RatingBar)itemView.findViewById(R.id.seeall_rattingbar);
            this.ratingBar.setIsIndicator(true);    ///// not giving access to user
        }
    }

}
