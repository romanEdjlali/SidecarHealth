
package com.sidecarhealth.sidecarhealth.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cost {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("providerRate")
    @Expose
    private Double providerRate;
    @SerializedName("sidecarRate")
    @Expose
    private Double sidecarRate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getProviderRate() {
        return providerRate;
    }

    public void setProviderRate(Double providerRate) {
        this.providerRate = providerRate;
    }

    public Double getSidecarRate() {
        return sidecarRate;
    }

    public void setSidecarRate(Double sidecarRate) {
        this.sidecarRate = sidecarRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
