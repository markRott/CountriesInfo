package com.example.sma.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sma on 10.10.17.
 */

public class Currency {

    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
}
