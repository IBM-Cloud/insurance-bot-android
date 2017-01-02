package com.ibm.org.vidyasagar.models;

/**
 * Created by VMac on 28/12/16.
 */

import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("entity")
    @Expose
    private String entity;
    @SerializedName("location")
    @Expose
    private List<Integer> location = null;
    @SerializedName("value")
    @Expose
    private String value;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<Integer> getLocation() {
        return location;
    }

    public void setLocation(List<Integer> location) {
        this.location = location;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}