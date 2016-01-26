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

    private static final String COMMA_SEP = ", ";
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
        public static final String COLUMN_NAME_DISTANCE = "distance";
        public static final String COLUMN_NAME_COUNTRYTRANSLATED = "countryTranslated";
        public static final String COLUMN_NAME_HASTHUMBNAIL = "hasThumbnail";
        public static final String COLUMN_NAME_DISTANCEKM = "distanceKM";
        public static final String COLUMN_NAME_DISTANCEMILES = "distanceMiles";

        public static final String SQL_CREATE_DATA =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_IDENTIFIER + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_SHORTNAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_THUMBNAIL + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_ZIPCODE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_CITY + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_COUNTRY + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LONGITUDE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LATITUDE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCE + FLOAT_TYPE + COMMA_SEP +
                        COLUMN_NAME_COUNTRYTRANSLATED + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCEKM + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DISTANCEMILES + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_HASTHUMBNAIL + TEXT_TYPE +
                        " );";

    }

    public static abstract class SCPrices implements BaseColumns {
        public static final String TABLE_NAME = "prices";
        public static final String COLUMN_NAME_DATA_IDENTIFIER = "identifier";
        public static final String COLUMN_NAME_HAS_PRICE = "hasprice";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String SQL_CREATE_PRICES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_HAS_PRICE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_PRICE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_DATA_IDENTIFIER + TEXT_TYPE + COMMA_SEP +
                        "FOREIGN KEY (" + COLUMN_NAME_DATA_IDENTIFIER + ") REFERENCES " + SCData.TABLE_NAME + " ("+SCData.COLUMN_NAME_IDENTIFIER +") " +
                        " );";
    }

    public static abstract class SCRatings implements BaseColumns {
        public static final String TABLE_NAME = "ratings";
        public static final String COLUMN_NAME_RATINGS_TOTAL = "ratings_total";
        public static final String COLUMN_NAME_RATINGS_STARS = "ratings_stars";
        public static final String COLUMN_NAME_RATINGS_LOWERBOUND = "ratings_lowerbound";
    }
}
