
package com.sidecarhealth.sidecarhealth.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorInfo {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("specialties")
    @Expose
    private List<String> specialties = null;
    @SerializedName("price")
    @Expose
    private String price;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
