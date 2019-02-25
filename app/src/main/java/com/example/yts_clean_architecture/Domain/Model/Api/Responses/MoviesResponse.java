package com.example.yts_clean_architecture.Domain.Model.Api.Responses;

import com.google.gson.annotations.SerializedName;
import com.example.yts_clean_architecture.Domain.Model.Api.Subs.Data;
import java.io.Serializable;

public class MoviesResponse implements Serializable {

    @SerializedName("status")
    private final String status;

    @SerializedName("status_message")
    private final String status_message;

    @SerializedName("data")
    private final Data data;


    public MoviesResponse(String status, String status_message, Data data) {
        this.status = status;
        this.status_message = status_message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getStatus_message() {
        return status_message;
    }

    public Data getData() {
        return data;
    }
}
