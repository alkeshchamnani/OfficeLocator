package com.alkesh.officelocator.dataProvider.network.models.response;

import com.alkesh.officelocator.dataProvider.network.models.dto.LocationsAppModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetOfficeLocationsApiResponse extends BaseApiResponse {
    @SerializedName("LocationsApp")
    @Expose
    private LocationsAppModel locationsAppModel;

    public LocationsAppModel getLocationsAppModel() {
        return locationsAppModel;
    }

    public void setLocationsAppModel(LocationsAppModel locationsAppModel) {
        this.locationsAppModel = locationsAppModel;
    }
}