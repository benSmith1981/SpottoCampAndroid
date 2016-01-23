package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SpottoCampData.db";

    //test
    private static final String TABLE_DATA = "data";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";

    private static final String[] TABLES = {"data", "prices","query","ratings","spots"};
    private static final String[] COLUMNS_DATA = {"identifier",
                                                    "name",
                                                    "shortname",
                                                    "thumbnail",
                                                    "address",
                                                    "zipcode",
                                                    "city",
                                                    "country",
                                                    "lng",
                                                    "lat",
                                                    "distance",
                                                    "countryTranslated",
                                                    "hasThumbnail",
                                                    "distanceKM",
                                                    "distanceMiles",
                                                    "ratings",
                                            };

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_DATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_NAME + " TEXT " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(String currentTable:TABLES) {
            db.execSQL("DROP TABLE IF EXISTS " + currentTable);
        }
    }

    public void addData(Data data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DATA, null, values);
    }

    public void deleteData(String dataName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DATA + "WHERE " + COLUMN_NAME + "=\"" + dataName + "\";");
    }

    public String dataBaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DATA + " WHERE 1";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while (c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_NAME)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_NAME)) + "\n";
            }
        }

        return dbString;
    }
}
