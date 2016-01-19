package com.example.funkymonkey1981.spottocampandroid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class SpottoCampJSON {
    public final String query;
    public final long resultsPerPage;
    public final Spots spots;
    public final long currentDistance;

    @JsonCreator
    public SpottoCampJSON(@JsonProperty("query") String query,
                          @JsonProperty("resultsPerPage") long resultsPerPage,
                          @JsonProperty("spots") Spots spots,
                          @JsonProperty("currentDistance") long currentDistance){
        this.query = query;
        this.resultsPerPage = resultsPerPage;
        this.spots = spots;
        this.currentDistance = currentDistance;
    }

    public static final class Spots {
        public final long totalRecords;
        public final Data data[];

        @JsonCreator
        public Spots(@JsonProperty("totalRecords") long totalRecords, @JsonProperty("data") Data[] data){
            this.totalRecords = totalRecords;
            this.data = data;
        }

        public static final class Data {
            public final String identifier;
            public final String name;
            public final String shortname;
            public final String thumbnail;
            public final String address;
            public final String zipcode;
            public final String city;
            public final String country;
            public final String lng;
            public final String lat;
            public final double distance;
            public final Prices prices;
            public final String countryTranslated;
            public final boolean hasThumbnail;
            public final double distanceKM;
            public final long distanceMiles;
            public final Ratings ratings;

            @JsonCreator
            public Data(@JsonProperty("identifier") String identifier,
                        @JsonProperty("name") String name,
                        @JsonProperty("shortname") String shortname,
                        @JsonProperty("thumbnail") String thumbnail,
                        @JsonProperty("address") String address,
                        @JsonProperty("zipcode") String zipcode,
                        @JsonProperty("city") String city,
                        @JsonProperty("country") String country,
                        @JsonProperty("lng") String lng,
                        @JsonProperty("lat") String lat,
                        @JsonProperty("distance") double distance,
                        @JsonProperty("prices") Prices prices,
                        @JsonProperty("countryTranslated") String countryTranslated,
                        @JsonProperty("hasThumbnail") boolean hasThumbnail,
                        @JsonProperty("distanceKM") double distanceKM,
                        @JsonProperty("distanceMiles") long distanceMiles,
                        @JsonProperty("ratings") Ratings ratings){
                this.identifier = identifier;
                this.name = name;
                this.shortname = shortname;
                this.thumbnail = thumbnail;
                this.address = address;
                this.zipcode = zipcode;
                this.city = city;
                this.country = country;
                this.lng = lng;
                this.lat = lat;
                this.distance = distance;
                this.prices = prices;
                this.countryTranslated = countryTranslated;
                this.hasThumbnail = hasThumbnail;
                this.distanceKM = distanceKM;
                this.distanceMiles = distanceMiles;
                this.ratings = ratings;
            }

            public static final class Prices {
                public final boolean hasprice;
                public final String price;

                @JsonCreator
                public Prices(@JsonProperty("hasprice") boolean hasprice, @JsonProperty("price") String price){
                    this.hasprice = hasprice;
                    this.price = price;
                }
            }

            public static final class Ratings {
                public final Ratings_total ratings_total;
                public final Ratings_stars ratings_stars;
                public final Ratings_lowerbound ratings_lowerbound;

                @JsonCreator
                public Ratings(@JsonProperty("ratings_total") Ratings_total ratings_total, @JsonProperty("ratings_stars") Ratings_stars ratings_stars, @JsonProperty("ratings_lowerbound") Ratings_lowerbound ratings_lowerbound){
                    this.ratings_total = ratings_total;
                    this.ratings_stars = ratings_stars;
                    this.ratings_lowerbound = ratings_lowerbound;
                }

                public static final class Ratings_total {

                    @JsonCreator
                    public Ratings_total(){
                    }
                }

                public static final class Ratings_stars {

                    @JsonCreator
                    public Ratings_stars(){
                    }
                }

                public static final class Ratings_lowerbound {

                    @JsonCreator
                    public Ratings_lowerbound(){
                    }
                }
            }
        }
    }
}