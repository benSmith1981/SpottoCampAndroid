package com.example.funkymonkey1981.spottocampandroid.JsonObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Prices implements Serializable {
    public boolean hasprice;
    public String price;
    public String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }

    public String getPrice() {
        return price;
    }

    public boolean isHasprice() {
        return hasprice;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setHasprice(boolean hasprice) {
        this.hasprice = hasprice;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public Prices() {}
    @JsonCreator
    public Prices(@JsonProperty("hasprice") boolean hasprice, @JsonProperty("price") String price) {
        this.hasprice = hasprice;
        this.price = price;
    }
}
