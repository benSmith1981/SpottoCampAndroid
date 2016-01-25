package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Prices;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class PricesProvider extends  DatabaseProvider {

    public PricesProvider(Context context) {
        super(context);
    }

    public long save(Prices prices) {
        ContentValues values = new ContentValues();
        values.put(SCContract.SCPrices.COLUMN_NAME_PRICE, prices.getPrice());
        values.put(SCContract.SCPrices.COLUMN_NAME_HAS_PRICE, prices.isHasprice());

        return database.insert(SCContract.SCPrices.TABLE_NAME, null, values);
    }
}
