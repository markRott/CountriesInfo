package com.example.sma.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sma on 10.10.17.
 */

public class CountryEntity {

    @SerializedName("name")
    private String name;
    @SerializedName("alpha2Code")
    private String alpha2Code;
    @SerializedName("alpha3Code")
    private String alpha3Code;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("subregion")
    private String subregion;
    @SerializedName("population")
    private int population;
    @SerializedName("demonym")
    private String demonym;
    @SerializedName("area")
    private float area;
    @SerializedName("gini")
    private double gini;
    @SerializedName("nativeName")
    private String nativeName;
    @SerializedName("numericCode")
    private String numericCode;
    @SerializedName("flag")
    private String flag;
    @SerializedName("cioc")
    private String cioc;

    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public String getDemonym() {
        return demonym;
    }

    public float getArea() {
        return area;
    }

    public Double getGini() {
        return gini;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public String getFlag() {
        return flag;
    }

    public String getCioc() {
        return cioc;
    }
}
