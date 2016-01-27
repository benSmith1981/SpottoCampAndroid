package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class DataProvider extends Provider {

    public DataProvider(Context context) {
        super(context);
    }

    public long save(Data data) {
        ContentValues values = new ContentValues();
        values.put(SCContract.SCData.COLUMN_NAME_NAME, data.getName());
        values.put(SCContract.SCData.COLUMN_NAME_SHORTNAME, data.getShortname());
        values.put(SCContract.SCData.COLUMN_NAME_THUMBNAIL, data.getThumbnail());
        values.put(SCContract.SCData.COLUMN_NAME_ADDRESS, data.getAddress());
        values.put(SCContract.SCData.COLUMN_NAME_ZIPCODE, data.getZipcode());
        values.put(SCContract.SCData.COLUMN_NAME_CITY, data.getCity());
        values.put(SCContract.SCData.COLUMN_NAME_COUNTRY, data.getCountry());
        values.put(SCContract.SCData.COLUMN_NAME_LONGITUDE, data.getLng());
        values.put(SCContract.SCData.COLUMN_NAME_LATITUDE, data.getLat());
        values.put(SCContract.SCData.COLUMN_NAME_PRICEEURCOURSE, data.getPriceEurCourse());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCE, data.getDistance());
        values.put(SCContract.SCData.COLUMN_NAME_IDENTIFIER, data.getIdentifier());
        values.put(SCContract.SCData.COLUMN_NAME_COUNTRYTRANSLATED, data.getCountryTranslated());
        values.put(SCContract.SCData.COLUMN_NAME_HASTHUMBNAIL, data.isHasThumbnail());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEKM, data.getDistanceKM());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEMILES, data.getDistanceMiles());

        return database.insert(SCContract.SCData.TABLE_NAME, null, values);
    }


    public int deleteData(Data campData) {
        return database.delete(SCContract.SCData.TABLE_NAME, SCContract.SCData.WHERE_DATA_ID_EQUALS,
                new String[] { campData.getIdentifier() + "" });
    }

    public long update(Data data) {
        ContentValues values = new ContentValues();
        values.put(SCContract.SCData.COLUMN_NAME_NAME, data.getName());
        values.put(SCContract.SCData.COLUMN_NAME_SHORTNAME, data.getShortname());
        values.put(SCContract.SCData.COLUMN_NAME_THUMBNAIL, data.getThumbnail());
        values.put(SCContract.SCData.COLUMN_NAME_ADDRESS, data.getAddress());
        values.put(SCContract.SCData.COLUMN_NAME_ZIPCODE, data.getZipcode());
        values.put(SCContract.SCData.COLUMN_NAME_CITY, data.getCity());
        values.put(SCContract.SCData.COLUMN_NAME_COUNTRY, data.getCountry());
        values.put(SCContract.SCData.COLUMN_NAME_LONGITUDE, data.getLng());
        values.put(SCContract.SCData.COLUMN_NAME_LATITUDE, data.getLat());
        values.put(SCContract.SCData.COLUMN_NAME_PRICEEURCOURSE, data.getPriceEurCourse());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCE, data.getDistance());
        values.put(SCContract.SCData.COLUMN_NAME_IDENTIFIER, data.getIdentifier());
        values.put(SCContract.SCData.COLUMN_NAME_COUNTRYTRANSLATED, data.getCountryTranslated());
        values.put(SCContract.SCData.COLUMN_NAME_HASTHUMBNAIL, data.isHasThumbnail());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEKM, data.getDistanceKM());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEMILES, data.getDistanceMiles());

        long result = database.update(SCContract.SCData.TABLE_NAME, values,
                SCContract.SCData.WHERE_DATA_ID_EQUALS,
                new String[] { String.valueOf(data.getIdentifier()) });
        return result;

    }

    public List<Data> getAllData() {
        List<Data> campsites = new ArrayList<Data>();

        String[] projection = {
                SCContract.SCData.COLUMN_NAME_NAME,
                SCContract.SCData.COLUMN_NAME_SHORTNAME,
                SCContract.SCData.COLUMN_NAME_THUMBNAIL,
                SCContract.SCData.COLUMN_NAME_ADDRESS,
                SCContract.SCData.COLUMN_NAME_ZIPCODE,
                SCContract.SCData.COLUMN_NAME_CITY,
                SCContract.SCData.COLUMN_NAME_COUNTRY,
                SCContract.SCData.COLUMN_NAME_LONGITUDE,
                SCContract.SCData.COLUMN_NAME_LATITUDE,
                SCContract.SCData.COLUMN_NAME_PRICEEURCOURSE,
                SCContract.SCData.COLUMN_NAME_DISTANCE,
                SCContract.SCData.COLUMN_NAME_IDENTIFIER,
                SCContract.SCData.COLUMN_NAME_COUNTRYTRANSLATED,
                SCContract.SCData.COLUMN_NAME_HASTHUMBNAIL,
                SCContract.SCData.COLUMN_NAME_DISTANCEKM,
                SCContract.SCData.COLUMN_NAME_DISTANCEMILES
        };
        Cursor cursor = database.query(SCContract.SCData.TABLE_NAME,
                projection, null, null, null, null,null);

        cursor.moveToFirst();
//        while (cursor.moveToNext()) {
//            Data campsite = new Data(cursor.getString(0),
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getString(3),
//                    cursor.getString(4),
//                    cursor.getString(5),
//                    cursor.getString(6),
//                    cursor.getString(7),
//                    cursor.getString(8),
//                    cursor.getString(9),
//                    cursor.getDouble(10),
//                    cursor.getString(12),
//                    cursor.getString(13),
//                    cursor.getString(14));
//            campsites.add(campsite);
//        }
        return campsites;
    }


}
