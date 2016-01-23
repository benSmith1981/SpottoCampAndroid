package com.example.funkymonkey1981.spottocampandroid.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class Query implements Serializable{
    public final String query;
    public final long resultsPerPage;
    public final Spots spots;
    public final long currentDistance;

    @JsonCreator
    public Query(@JsonProperty("query") String query,
                 @JsonProperty("resultsPerPage") long resultsPerPage,
                 @JsonProperty("spots") Spots spots,
                 @JsonProperty("currentDistance") long currentDistance){
        this.query = query;
        this.resultsPerPage = resultsPerPage;
        this.spots = spots;
        this.currentDistance = currentDistance;
    }

}