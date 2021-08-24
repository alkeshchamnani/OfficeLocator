package com.alkesh.officelocator.dataProvider.network.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseApiResponse {

    @Expose
    @SerializedName("isSuccessful")
    private Boolean isSuccessful;

    @Expose
    @SerializedName("message")
    private String message;

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}