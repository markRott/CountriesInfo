package com.example.sma.data.cache;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sma on 11.10.17.
 */

public class CountryEntityForRealm extends RealmObject {

    @PrimaryKey
    private String name;
    private double area;
    private double gini;
    private String flag;
    private String cioc;
    private String alpha2Code;
    private String alpha3Code;
    private String capital;
    private String region;
    private String subregion;
    private int population;
    private String demonym;
    private String nativeName;
    private String numericCode;

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
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

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public String getFlag() {
        return flag;
    }

    public String getCioc() {
        return cioc;
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

    public int getPopulation() {
        return population;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }
}
