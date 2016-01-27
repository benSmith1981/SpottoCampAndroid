package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Prices;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class PricesProvider extends Provider {

    public PricesProvider(Context context) {
        super(context);
    }

    public long save(Prices prices) {
        ContentValues values = new ContentValues();
        values.put(SCContract.SCPrices.COLUMN_NAME_PRICE, prices.getPrice());
        values.put(SCContract.SCPrices.COLUMN_NAME_HAS_PRICE, prices.isHasprice());
        values.put(SCContract.SCPrices.COLUMN_NAME_DATA_IDENTIFIER, prices.getForeignKey()); //put foreign key in DB
        return database.insertWithOnConflict(SCContract.SCPrices.TABLE_NAME, null, values, database.CONFLICT_REPLACE);
    }

    public Prices getAllPrices() {
        //print value of the prices query
        Prices prices = new Prices();
        String getPricesQuery = SCContract.SCPrices.SQL_GET_ALLPRICES;
        Cursor cursorAllPrices = database.rawQuery(getPricesQuery, null);
        if(cursorAllPrices.moveToFirst())
        {
            do {
                for(int i=0; i<cursorAllPrices.getColumnCount();i++) {
                    Log.i("PRICESCURSOR", cursorAllPrices.getString(i));
                    switch (cursorAllPrices.getColumnName(i))
                    {

                    }
                }
            } while (cursorAllPrices.moveToNext());
        }

        return prices;
    }

    public Prices getPricesFor(){
        //print value of the prices query
        Prices prices = new Prices();
        String getPricesQuery = SCContract.SCPrices.SQL_GET_DATA_AND_PRICES;
        Cursor cursorAllPrices = database.rawQuery(getPricesQuery, null);
        if(cursorAllPrices.moveToFirst())
        {
            do {
                for(int i=0; i<cursorAllPrices.getColumnCount();i++) {
                    Log.i("PRICESCURSOR", cursorAllPrices.getString(i));
                    switch (cursorAllPrices.getColumnName(i))
                    {

                    }
                }
            } while (cursorAllPrices.moveToNext());
        }

        return prices;
    }
}
