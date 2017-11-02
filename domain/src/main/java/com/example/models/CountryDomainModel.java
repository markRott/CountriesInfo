package com.example.models;

import java.io.Serializable;

/**
 * Created by sma on 10.10.17.
 */

public class CountryDomainModel implements Serializable {

    private float area;
    private String flag;
    private String region;
    private int population;
    private String capital;
    private String countryName;
    private String numericCode;
    private String alpha3Code;

    private String urlForLoadFlag;

    public void setArea(float area) {
        this.area = area;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public float getArea() {
        return area;
    }

    public String getFlag() {
        return flag;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getUrlForLoadFlag() {
        return urlForLoadFlag;
    }

    public void setUrlForLoadFlag(String urlForLoadFlag) {
        this.urlForLoadFlag = urlForLoadFlag;
    }

    @Override
    public String toString() {
        return "CountryDomainModel{" +
                "area=" + area +
                ", flag='" + flag + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                ", countryName='" + countryName + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", urlForLoadFlag='" + urlForLoadFlag + '\'' +
                '}';
    }
}
