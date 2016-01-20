package com.example.funkymonkey1981.spottocampandroid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        private final List<Data> data;

        @JsonCreator
        public Spots(@JsonProperty("totalRecords") long totalRecords, @JsonProperty("data") List<Data> data){
            this.totalRecords = totalRecords;
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }

        public static final class Data {
            public String getIdentifier() {
                return identifier;
            }

            public String getName() {
                return name;
            }

            public String getShortname() {
                return shortname;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public String getAddress() {
                return address;
            }

            public String getZipcode() {
                return zipcode;
            }

            public String getCity() {
                return city;
            }

            public String getCountry() {
                return country;
            }

            public String getLng() {
                return lng;
            }

            public String getLat() {
                return lat;
            }

            public double getDistance() {
                return distance;
            }

            public Prices getPrices() {
                return prices;
            }

            public String getCountryTranslated() {
                return countryTranslated;
            }

            public boolean isHasThumbnail() {
                return hasThumbnail;
            }

            public double getDistanceKM() {
                return distanceKM;
            }

            public long getDistanceMiles() {
                return distanceMiles;
            }

            public Ratings getRatings() {
                return ratings;
            }

            private final String identifier;
            private final String name;
            private final String shortname;
            private final String thumbnail;
            private final String address;
            private final String zipcode;
            private final String city;
            private final String country;
            private final String lng;
            private final String lat;
            private final double distance;
            private final Prices prices;
            private final String countryTranslated;
            private final boolean hasThumbnail;
            private final double distanceKM;
            private final long distanceMiles;
            private final Ratings ratings;

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