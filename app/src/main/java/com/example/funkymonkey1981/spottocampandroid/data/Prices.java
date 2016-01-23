package com.example.funkymonkey1981.spottocampandroid.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Prices implements Serializable {
    public final boolean hasprice;
    public final String price;

    @JsonCreator
    public Prices(@JsonProperty("hasprice") boolean hasprice, @JsonProperty("price") String price) {
        this.hasprice = hasprice;
        this.price = price;
    }
}
