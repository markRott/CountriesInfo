package com.example.sma.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sma on 10.10.17.
 */

public class RegionalBloc {

    @SerializedName("acronym")
    private String acronym;
    @SerializedName("name")
    private String name;
    @SerializedName("otherAcronyms")
    private List<String> otherAcronyms;
    @SerializedName("otherNames")
    private List<String> otherNames;

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }
}
