package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Prices;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Ratings;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class RatingsProvider extends DatabaseProvider{

    public RatingsProvider(Context context) {
        super(context);
    }

    public long save(Ratings ratings) {
        ContentValues values = new ContentValues();
        values.put(SCContract.SCRatings.COLUMN_NAME_RATINGS_TOTAL, ratings.getRatingsTotal());
        values.put(SCContract.SCRatings.COLUMN_NAME_RATINGS_STARS, ratings.getRatingsStars());
        values.put(SCContract.SCRatings.COLUMN_NAME_RATINGS_LOWERBOUND, ratings.getRatingsLowerbound());

        return database.insert(SCContract.SCRatings.TABLE_NAME, null, values);
    }
}
