package com.example.funkymonkey1981.spottocampandroid.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by funkymonkey1981 on 25/01/16.
 */
public class DatabaseProvider {

    protected SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private Context mContext;

    public DatabaseProvider(Context context) {
        this.mContext = context;
        dbHelper = DatabaseHelper.getHelper(mContext);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void open() throws SQLException {
        if(dbHelper == null)
            dbHelper = DatabaseHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }
}
