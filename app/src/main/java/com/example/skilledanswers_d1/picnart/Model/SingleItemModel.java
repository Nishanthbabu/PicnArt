package com.example.skilledanswers_d1.picnart.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nishanth on 01-12-2015.
 */
public class SingleItemModel  implements Parcelable{

    private int _image=0;
    private String _company=null;
    private String _Pname=null;
    private String _sellingPrice=null;
    private String _actualPrice=null;
    private String _rating=null;
    private String _likes=null;
    private String _shares=null;
    private boolean _love=false;
    private String _cvategory=null;
    private String _specification1=null;
    private String _specification2=null;
    private String _specification3=null;

    public SingleItemModel(int _image, String _company, String _Pname,
                           String _sellingPrice, String _actualPrice, String _rating, String _likes,
                           String _shares, boolean _love, String _cvategory,
                           String _specification1, String _specification2, String _specification3) {
        this._image = _image;
        this._company = _company;
        this._Pname = _Pname;
        this._sellingPrice = _sellingPrice;
        this._actualPrice = _actualPrice;
        this._rating = _rating;
        this._likes = _likes;
        this._shares = _shares;
        this._love = _love;
        this._cvategory = _cvategory;
        this._specification1 = _specification1;
        this._specification2 = _specification2;
        this._specification3 = _specification3;
    }

    protected SingleItemModel(Parcel in) {
        _image = in.readInt();
        _company = in.readString();
        _Pname = in.readString();
        _sellingPrice = in.readString();
        _actualPrice = in.readString();
        _rating = in.readString();
        _likes = in.readString();
        _shares = in.readString();
        _love = in.readByte() != 0;
        _cvategory = in.readString();
        _specification1 = in.readString();
        _specification2 = in.readString();
        _specification3 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_image);
        dest.writeString(_company);
        dest.writeString(_Pname);
        dest.writeString(_sellingPrice);
        dest.writeString(_actualPrice);
        dest.writeString(_rating);
        dest.writeString(_likes);
        dest.writeString(_shares);
        dest.writeByte((byte) (_love ? 1 : 0));
        dest.writeString(_cvategory);
        dest.writeString(_specification1);
        dest.writeString(_specification2);
        dest.writeString(_specification3);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SingleItemModel> CREATOR = new Creator<SingleItemModel>() {
        @Override
        public SingleItemModel createFromParcel(Parcel in) {
            return new SingleItemModel(in);
        }

        @Override
        public SingleItemModel[] newArray(int size) {
            return new SingleItemModel[size];
        }
    };

    public int get_image() {
        return _image;
    }

    public void set_image(int _image) {
        this._image = _image;
    }

    public String get_company() {
        return _company;
    }

    public void set_company(String _company) {
        this._company = _company;
    }

    public String get_Pname() {
        return _Pname;
    }

    public void set_Pname(String _Pname) {
        this._Pname = _Pname;
    }

    public String get_sellingPrice() {
        return _sellingPrice;
    }

    public void set_sellingPrice(String _sellingPrice) {
        this._sellingPrice = _sellingPrice;
    }

    public String get_actualPrice() {
        return _actualPrice;
    }

    public void set_actualPrice(String _actualPrice) {
        this._actualPrice = _actualPrice;
    }

    public String get_rating() {
        return _rating;
    }

    public void set_rating(String _rating) {
        this._rating = _rating;
    }

    public String get_likes() {
        return _likes;
    }

    public void set_likes(String _likes) {
        this._likes = _likes;
    }

    public String get_shares() {
        return _shares;
    }

    public void set_shares(String _shares) {
        this._shares = _shares;
    }

    public boolean get_love() {
        return _love;
    }

    public void set_love(boolean _love) {
        this._love = _love;
    }

    public String get_cvategory() {
        return _cvategory;
    }

    public void set_cvategory(String _cvategory) {
        this._cvategory = _cvategory;
    }

    public String get_specification1() {
        return _specification1;
    }

    public void set_specification1(String _specification1) {
        this._specification1 = _specification1;
    }

    public String get_specification2() {
        return _specification2;
    }

    public void set_specification2(String _specification2) {
        this._specification2 = _specification2;
    }

    public String get_specification3() {
        return _specification3;
    }

    public void set_specification3(String _specification3) {
        this._specification3 = _specification3;
    }

    public static Creator<SingleItemModel> getCREATOR() {
        return CREATOR;
    }
}
