package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Prices;

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

        return database.insertWithOnConflict(SCContract.SCData.TABLE_NAME, null, values, database.CONFLICT_REPLACE);
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

        String selectALLQuery = SCContract.SCPrices.SQL_GET_DATA_AND_PRICES;
        Cursor cursorAllData = database.rawQuery(selectALLQuery, null);

        if (cursorAllData.moveToFirst()) {
            do {
                //override old data object to create a new one
                Data campData = new Data();
                Prices prices = new Prices();

                // get  the  data into array,or class variable
                for(int i=0; i<cursorAllData.getColumnCount();i++)
                {
                    switch (cursorAllData.getColumnName(i))
                    {
                        case SCContract.SCPrices.COLUMN_NAME_PRICE:
                            prices.setPrice(cursorAllData.getString(i));
                            break;

                        case SCContract.SCPrices.COLUMN_NAME_DATA_IDENTIFIER:
                            prices.setForeignKey(cursorAllData.getString(i));
                            break;
                        case SCContract.SCPrices.COLUMN_NAME_HAS_PRICE:
                            if(cursorAllData.getString(i).equals("true"))
                                prices.setHasprice(true);
                            else
                                prices.setHasprice(false);
                            break;
                        case SCContract.SCData.COLUMN_NAME_NAME:
                            campData.setName(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_IDENTIFIER:
                            campData.setIdentifier(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_PRICEEURCOURSE:
                            campData.setPriceEurCourse(cursorAllData.getDouble(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_ZIPCODE:
                            campData.setZipcode(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_ADDRESS:
                            campData.setAddress(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_CITY:
                            campData.setCity(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_COUNTRY:
                            campData.setCountry(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_COUNTRYTRANSLATED:
                            campData.setCountryTranslated(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_DISTANCE:
                            campData.setDistance(cursorAllData.getDouble(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_DISTANCEKM:
                            campData.setDistanceKM(cursorAllData.getDouble(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_DISTANCEMILES:
                            campData.setDistanceMiles(cursorAllData.getLong(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_HASTHUMBNAIL:
                            if(cursorAllData.getString(i).equals("true"))
                                campData.setHasThumbnail(true);
                            else
                                campData.setHasThumbnail(false);
                            break;
                        case SCContract.SCData.COLUMN_NAME_LATITUDE:
                            campData.setLat(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_LONGITUDE:
                            campData.setLng(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_SHORTNAME:
                            campData.setShortname(cursorAllData.getString(i));
                            break;
                        case SCContract.SCData.COLUMN_NAME_THUMBNAIL:
                            campData.setThumbnail(cursorAllData.getString(i));
                            break;
                        default: throw new IllegalArgumentException("There is no column type in switch statemtn for column name " + cursorAllData.getColumnName(i));

                    }
                    Log.d(TAG, "getAllData: Data type" + cursorAllData.getType(i) +
                            " " + cursorAllData.getString(i) + " COLUMN_NAME_NAME Index:" +
                            cursorAllData.getColumnIndex(SCContract.SCData.COLUMN_NAME_NAME) +
                            " ColumnName" + cursorAllData.getColumnName(i));
                }
                campData.setPrices(prices);//add the prices object associated with campData
                campsites.add(campData);
            } while (cursorAllData.moveToNext());
        }

        return campsites;
    }


}
