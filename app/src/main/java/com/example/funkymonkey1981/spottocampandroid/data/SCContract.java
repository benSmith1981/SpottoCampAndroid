package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.sql.SQLException;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public final class SCContract {

    private static final String TEXT_TYPE = " TEXT";
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INT_TYPE = " INT";
    private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String LONG_TYPE = " LONG";
    private static final String BOOLEAN_TYPE = " BOOLEAN";
    private static final String COMMA_SEP = ", ";
    private static final String NOT_NULL_UNIQUE = " NOT NULL UNIQUE";
    private static final String PRIMARY_KEY = " PRIMARY KEY";

    public SCContract(){};

    public static abstract class SCData implements BaseColumns {
        public static final String TABLE_NAME = "data";
        public static final String COLUMN_NAME_IDENTIFIER = "identifier";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SHORTNAME = "shortname";
        public static final String COLUMN_NAME_THUMBNAIL = "thumbnail";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_ZIPCODE = "zipcode";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_LONGITUDE = "lng";
        public static final String COLUMN_NAME_LATITUDE = "lat";
        public static final String COLUMN_NAME_PRICEEURCOURSE = "priceEurCourse";
        public static final String COLUMN_NAME_DISTANCE = "distance";
        public static final String COLUMN_NAME_COUNTRYTRANSLATED = "countryTranslated";
        public static final String COLUMN_NAME_HASTHUMBNAIL = "hasThumbnail";
        public static final String COLUMN_NAME_DISTANCEKM = "distanceKM";
        public static final String COLUMN_NAME_DISTANCEMILES = "distanceMiles";

        public static final String SQL_CREATE_DATA =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_IDENTIFIER + INT_TYPE + NOT_NULL_UNIQUE + COMMA_SEP +
                        COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_SHORTNAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_THUMBNAIL + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_ZIPCODE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_CITY + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_COUNTRY + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LONGITUDE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LATITUDE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_PRICEEURCOURSE + DOUBLE_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCE + DOUBLE_TYPE + COMMA_SEP +
                        COLUMN_NAME_COUNTRYTRANSLATED + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCEKM + DOUBLE_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCEMILES + LONG_TYPE + COMMA_SEP +
                        COLUMN_NAME_HASTHUMBNAIL + BOOLEAN_TYPE +
                        " );";
        public static final String SQL_DELETE_DATA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String WHERE_DATA_ID_EQUALS = SCData.COLUMN_NAME_IDENTIFIER + " =?";
        public static final String SQL_GET_ALL_DATA = "SELECT  * FROM " + SCContract.SCData.TABLE_NAME;


    }

    public static abstract class SCPrices implements BaseColumns {
        public static final String TABLE_NAME = "prices";
        public static final String COLUMN_NAME_DATA_IDENTIFIER = "identifierFK";
        public static final String COLUMN_NAME_HAS_PRICE = "hasprice";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String SQL_CREATE_PRICES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_HAS_PRICE + BOOLEAN_TYPE + COMMA_SEP +
                        COLUMN_NAME_PRICE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DATA_IDENTIFIER + TEXT_TYPE + COMMA_SEP +
                        "FOREIGN KEY (" + COLUMN_NAME_DATA_IDENTIFIER + ") REFERENCES " + SCData.TABLE_NAME + " ("+SCData.COLUMN_NAME_IDENTIFIER +") " +
                        " );";
        public static final String SQL_DELETE_PRICES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String SQL_GET_ALLPRICES =
                "SELECT * " + "FROM " + TABLE_NAME;
        public static final String SQL_GET_DATA_AND_PRICES =
                "SELECT " + COLUMN_NAME_PRICE + COMMA_SEP +
                        COLUMN_NAME_HAS_PRICE + COMMA_SEP +
                        COLUMN_NAME_DATA_IDENTIFIER + COMMA_SEP +
                        SCData.COLUMN_NAME_IDENTIFIER + COMMA_SEP +
                        SCData.COLUMN_NAME_NAME + COMMA_SEP +
                        SCData.COLUMN_NAME_SHORTNAME + COMMA_SEP +
                        SCData.COLUMN_NAME_THUMBNAIL + COMMA_SEP +
                        SCData.COLUMN_NAME_ADDRESS + COMMA_SEP +
                        SCData.COLUMN_NAME_ZIPCODE + COMMA_SEP +
                        SCData.COLUMN_NAME_CITY + COMMA_SEP +
                        SCData.COLUMN_NAME_COUNTRY + COMMA_SEP +
                        SCData.COLUMN_NAME_LONGITUDE + COMMA_SEP +
                        SCData.COLUMN_NAME_LATITUDE + COMMA_SEP +
                        SCData.COLUMN_NAME_PRICEEURCOURSE + COMMA_SEP +
                        SCData.COLUMN_NAME_DISTANCE + COMMA_SEP +
                        SCData.COLUMN_NAME_COUNTRYTRANSLATED + COMMA_SEP +
                        SCData.COLUMN_NAME_DISTANCEKM + COMMA_SEP +
                        SCData.COLUMN_NAME_DISTANCEMILES + COMMA_SEP +
                        SCData.COLUMN_NAME_HASTHUMBNAIL +
                        " FROM " + SCData.TABLE_NAME + COMMA_SEP  + SCPrices.TABLE_NAME +
                        " WHERE " + SCPrices.TABLE_NAME + "." + SCPrices.COLUMN_NAME_DATA_IDENTIFIER + " = " + SCData.TABLE_NAME +"." + SCData.COLUMN_NAME_IDENTIFIER;
    }

    public static abstract class SCRatings implements BaseColumns {
        public static final String TABLE_NAME = "ratings";
        public static final String COLUMN_NAME_RATINGS_TOTAL = "ratings_total";
        public static final String COLUMN_NAME_RATINGS_STARS = "ratings_stars";
        public static final String COLUMN_NAME_RATINGS_LOWERBOUND = "ratings_lowerbound";
    }
}
