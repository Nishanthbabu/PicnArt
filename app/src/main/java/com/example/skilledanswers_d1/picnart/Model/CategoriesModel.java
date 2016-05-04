package com.example.skilledanswers_d1.picnart.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class CategoriesModel implements Parcelable {



    private String _categoryTitle;
    private ArrayList<SingleItemModel> allItemsInSection;

    public CategoriesModel() {
    }

    public CategoriesModel(String _categoryTitle, ArrayList<SingleItemModel> allItemsInSection) {
        this._categoryTitle = _categoryTitle;
        this.allItemsInSection = allItemsInSection;
    }

    protected CategoriesModel(Parcel in) {
        _categoryTitle = in.readString();
        allItemsInSection = in.createTypedArrayList(SingleItemModel.CREATOR);
    }

    public static final Creator<CategoriesModel> CREATOR = new Creator<CategoriesModel>() {
        @Override
        public CategoriesModel createFromParcel(Parcel in) {
            return new CategoriesModel(in);
        }

        @Override
        public CategoriesModel[] newArray(int size) {
            return new CategoriesModel[size];
        }
    };

    public String get_categoryTitle() {
        return _categoryTitle;
    }

    public void set_categoryTitle(String _categoryTitle) {
        this._categoryTitle = _categoryTitle;
    }

    public ArrayList<SingleItemModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_categoryTitle);
        dest.writeTypedList(allItemsInSection);
    }
}
