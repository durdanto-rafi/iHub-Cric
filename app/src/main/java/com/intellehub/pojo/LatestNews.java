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
    String _full_image;
    String _full_story;


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

    public String get_full_image() {
        return _full_image;
    }

    public void set_full_image(String _full_image) {
        this._full_image = _full_image;
    }

    public String get_full_story() {
        return _full_story;
    }

    public void set_full_story(String _full_story) {
        this._full_story = _full_story;
    }

    public LatestNews() {
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
        dest.writeString(this._full_image);
        dest.writeString(this._full_story);
    }

    protected LatestNews(Parcel in) {
        this._id = in.readInt();
        this._title = in.readString();
        this._image = in.readString();
        this._abstract = in.readString();
        this._author = in.readString();
        this._category = in.readString();
        this._full_image = in.readString();
        this._full_story = in.readString();
    }

    public static final Creator<LatestNews> CREATOR = new Creator<LatestNews>() {
        public LatestNews createFromParcel(Parcel source) {
            return new LatestNews(source);
        }

        public LatestNews[] newArray(int size) {
            return new LatestNews[size];
        }
    };
}
