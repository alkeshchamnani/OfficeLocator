package com.alkesh.officelocator.dataProvider.network.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationsAppModel {
    @SerializedName("FileVer")
    @Expose
    private String fileVer;
    @SerializedName("Dist")
    @Expose
    private String dist;
    @SerializedName("Cordinate")
    @Expose
    private CoordinateModel coordinateModel;

    public String getFileVer() {
        return fileVer;
    }

    public void setFileVer(String fileVer) {
        this.fileVer = fileVer;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public CoordinateModel getCoordinateModel() {
        return coordinateModel;
    }

    public void setCoordinateModel(CoordinateModel coordinateModel) {
        this.coordinateModel = coordinateModel;
    }
}