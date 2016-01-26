package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class DataProvider extends DatabaseProvider {

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
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCE, data.getDistance());
        values.put(SCContract.SCData.COLUMN_NAME_IDENTIFIER, data.getIdentifier());
        values.put(SCContract.SCData.COLUMN_NAME_COUNTRYTRANSLATED, data.getCountryTranslated());
        values.put(SCContract.SCData.COLUMN_NAME_HASTHUMBNAIL, data.isHasThumbnail());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEKM, data.getDistanceKM());
        values.put(SCContract.SCData.COLUMN_NAME_DISTANCEMILES, data.getDistanceMiles());

        return database.insert(SCContract.SCData.TABLE_NAME, null, values);
    }

    public void deleteData(String dataName) {

    }

}
