package com.example.funkymonkey1981.spottocampandroid.JsonObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Data implements Serializable {

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
                @JsonProperty("ratings") Ratings ratings) {
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
        this.prices.setForeignKey(this.getIdentifier()); //set prices foreign key to that of identifier here
        this.countryTranslated = countryTranslated;
        this.hasThumbnail = hasThumbnail;
        this.distanceKM = distanceKM;
        this.distanceMiles = distanceMiles;
        this.ratings = ratings;
    }

}
