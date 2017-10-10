package com.example.sma.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sma on 10.10.17.
 */

public class LanguageEntity {

    @SerializedName("iso639_1")
    private String iso6391;
    @SerializedName("iso639_2")
    private String iso6392;
    @SerializedName("name")
    private String name;
    @SerializedName("nativeName")
    private String nativeName;

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public void setIso6392(String iso6392) {
        this.iso6392 = iso6392;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getIso6391() {
        return iso6391;
    }

    public String getIso6392() {
        return iso6392;
    }

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }
}
