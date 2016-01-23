package com.example.funkymonkey1981.spottocampandroid.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Ratings implements Serializable {
    public final Ratings_total ratings_total;
    public final Ratings_stars ratings_stars;
    public final Ratings_lowerbound ratings_lowerbound;

    @JsonCreator
    public Ratings(@JsonProperty("ratings_total") Ratings_total ratings_total, @JsonProperty("ratings_stars") Ratings_stars ratings_stars, @JsonProperty("ratings_lowerbound") Ratings_lowerbound ratings_lowerbound) {
        this.ratings_total = ratings_total;
        this.ratings_stars = ratings_stars;
        this.ratings_lowerbound = ratings_lowerbound;
    }

    public static final class Ratings_total {

        @JsonCreator
        public Ratings_total() {
        }
    }

    public static final class Ratings_stars {

        @JsonCreator
        public Ratings_stars() {
        }
    }

    public static final class Ratings_lowerbound {

        @JsonCreator
        public Ratings_lowerbound() {
        }
    }
}
