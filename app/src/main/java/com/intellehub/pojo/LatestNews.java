package com.intellehub.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rita on 23-Feb-16.
 */
public class LatestNews implements Parcelable {

    int _id;
    String _title;
    String _image;
    String _abstract;
    String _author;
    String _category;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_image() {
        return _image;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this._title);
        dest.writeString(this._image);
        dest.writeString(this._abstract);
        dest.writeString(this._author);
        dest.writeString(this._category);
    }

    public LatestNews() {
    }

    protected LatestNews(Parcel in) {
        this._id = in.readInt();
        this._title = in.readString();
        this._image = in.readString();
        this._abstract = in.readString();
        this._author = in.readString();
        this._category = in.readString();
    }

    public static final Parcelable.Creator<LatestNews> CREATOR = new Parcelable.Creator<LatestNews>() {
        public LatestNews createFromParcel(Parcel source) {
            return new LatestNews(source);
        }

        public LatestNews[] newArray(int size) {
            return new LatestNews[size];
        }
    };
}
