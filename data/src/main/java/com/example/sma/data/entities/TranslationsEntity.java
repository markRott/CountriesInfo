package com.example.sma.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sma on 10.10.17.
 */

public class TranslationsEntity {

    @SerializedName("de")
    private String de;
    @SerializedName("es")
    private String es;
    @SerializedName("fr")
    private String fr;
    @SerializedName("ja")
    private String ja;
    @SerializedName("it")
    private String it;
    @SerializedName("br")
    private String br;
    @SerializedName("pt")
    private String pt;
    @SerializedName("nl")
    private String nl;
    @SerializedName("hr")
    private String hr;
    @SerializedName("fa")
    private String fa;

    public void setDe(String de) {
        this.de = de;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getDe() {
        return de;
    }

    public String getEs() {
        return es;
    }

    public String getFr() {
        return fr;
    }

    public String getJa() {
        return ja;
    }

    public String getIt() {
        return it;
    }

    public String getBr() {
        return br;
    }

    public String getPt() {
        return pt;
    }

    public String getNl() {
        return nl;
    }

    public String getHr() {
        return hr;
    }

    public String getFa() {
        return fa;
    }
}
