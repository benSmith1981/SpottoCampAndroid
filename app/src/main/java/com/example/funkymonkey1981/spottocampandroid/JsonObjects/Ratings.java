package com.example.funkymonkey1981.spottocampandroid.JsonObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Ratings implements Serializable {
    public final int ratingsTotal;
    public final int ratingsStars;
    public final int ratingsLowerbound;

    @JsonCreator
    public Ratings(@JsonProperty("ratings_total") int ratings_total, @JsonProperty("ratings_stars") int ratings_stars, @JsonProperty("ratings_lowerbound") int ratings_lowerbound) {
        this.ratingsTotal = ratings_total;
        this.ratingsStars = ratings_stars;
        this.ratingsLowerbound = ratings_lowerbound;
    }

    public int getRatingsTotal() {
        return ratingsTotal;
    }

    public int getRatingsStars() {
        return ratingsStars;
    }

    public int getRatingsLowerbound() {
        return ratingsLowerbound;
    }

}
