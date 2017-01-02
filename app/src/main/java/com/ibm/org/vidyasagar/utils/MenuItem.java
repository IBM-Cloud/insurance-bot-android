package com.ibm.org.vidyasagar.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vidyasagar Machupalli on 27/12/16.
 */

public class MenuItem implements Parcelable {
    String label;
    int iconResource;
    String iconUrl;
    Class fragmentClass;
    //Action action;
    public static final Creator CREATOR = new Creator() {
        public Object createFromParcel(Parcel parcel) {
            return (new MenuItem()).setLabel(parcel.readString()).setIcon(parcel.readInt()).setIconUrl(parcel.readString());
        }

        public Object[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    public MenuItem() {
    }

    public String getLabel() {
        return this.label;
    }

    public MenuItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public int getIcon() {
        return this.iconResource;
    }

    public MenuItem setIcon(int imgRes) {
        this.iconResource = imgRes;
        return this;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public MenuItem setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    /*public Action getAction() {
        return this.action;
    }

    public MenuItem setAction(Action action) {
        this.action = action;
        return this;
    }*/


    public String toString() {
        return this.label;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.label);
        parcel.writeInt(this.iconResource);
        parcel.writeString(this.iconUrl);
    }
}
