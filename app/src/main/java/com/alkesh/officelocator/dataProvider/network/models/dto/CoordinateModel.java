package com.alkesh.officelocator.dataProvider.network.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CoordinateModel {
    @SerializedName("item")
    @Expose
    private ArrayList<OfficeLocationModel> officeLocations = null;

    public ArrayList<OfficeLocationModel> getItem() {
        return officeLocations;
    }

    public void setItem(ArrayList<OfficeLocationModel> officeLocations) {
        this.officeLocations = officeLocations;
    }
}