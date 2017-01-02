package com.ibm.org.vidyasagar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Input {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("context")
    @Expose
    private Context context;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(String text) {
        this.context = context;
    }

}
