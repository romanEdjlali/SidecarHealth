package com.sidecarhealth.sidecarhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by romanedjlali on 7/15/18.
 */

public class Cost_Demo {

    @SerializedName("image")
    @Expose
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage (int image) {
        this.image = image;
    }

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("cost")
    @Expose
    private double cost;

    public double getCost() {
        return cost;
    }
}
