package com.ibm.org.vidyasagar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Vidyasagar MSC on 28/12/16.
 */

public class ChatRequest {

    private static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'", Locale.US);
    static {
        DATE_FORMATTER.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @SerializedName("user_time")
    @Expose
    private String usertime = DATE_FORMATTER.format(new Date());
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("context")
    @Expose
    private Context context;

    public String getUsertime() { return usertime; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
