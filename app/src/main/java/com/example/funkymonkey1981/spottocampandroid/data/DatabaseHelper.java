package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;

/**
 * Created by funkymonkey1981 on 23/01/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SpottoCampData.db";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SCContract.SCData.TABLE_NAME;

    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCContract.SCData.SQL_CREATE_DATA);
        db.execSQL(SCContract.SCPrices.SQL_CREATE_PRICES);

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}