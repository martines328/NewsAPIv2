package com.example.newsapiv2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {


    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("totalResults")
    @Expose
    private int totalResult;

    @SerializedName("articles")
    @Expose
    private List<Arcticle> arcticles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<Arcticle> getArcticles() {
        return arcticles;
    }

    public void setArcticles(List<Arcticle> arcticles) {
        this.arcticles = arcticles;
    }
}
