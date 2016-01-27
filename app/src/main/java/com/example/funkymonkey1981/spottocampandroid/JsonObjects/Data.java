package com.example.funkymonkey1981.spottocampandroid.JsonObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public final class Data implements Serializable {

    public String identifier;
    public String name;
    public String shortname;
    public String thumbnail;
    public String address;
    public String zipcode;
    public String city;
    public String country;
    public String lng;
    public String lat;
    public double distance;
    public Prices prices;
    public String countryTranslated;
    public boolean hasThumbnail;
    public double distanceKM;
    public long distanceMiles;
    public Ratings ratings;
    public double priceEurCourse;

    public double getPriceEurCourse() {
        return priceEurCourse;
    }

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

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setPriceEurCourse(double priceEurCourse) {
        this.priceEurCourse = priceEurCourse;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public void setCountryTranslated(String countryTranslated) {
        this.countryTranslated = countryTranslated;
    }

    public void setHasThumbnail(boolean hasThumbnail) {
        this.hasThumbnail = hasThumbnail;
    }

    public void setDistanceKM(double distanceKM) {
        this.distanceKM = distanceKM;
    }

    public void setDistanceMiles(long distanceMiles) {
        this.distanceMiles = distanceMiles;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

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
                @JsonProperty("price_eur_course") double priceEurCourse,
                @JsonProperty("distance") double distance,
                @JsonProperty("prices") Prices prices,
                @JsonProperty("countryTranslated") String countryTranslated,
                @JsonProperty("hasThumbnail") boolean hasThumbnail,
                @JsonProperty("distanceKM") double distanceKM,
                @JsonProperty("distanceMiles") long distanceMiles,
                @JsonProperty("ratings") Ratings ratings
    ){
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
        this.priceEurCourse = priceEurCourse;
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
