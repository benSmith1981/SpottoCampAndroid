package com.example.funkymonkey1981.spottocampandroid.JsonObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Spots implements Serializable {
    public final long totalRecords;
    private final List<Data> data;

    @JsonCreator
    public Spots(@JsonProperty("totalRecords") long totalRecords, @JsonProperty("data") List<Data> data) {
        this.totalRecords = totalRecords;
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

}
