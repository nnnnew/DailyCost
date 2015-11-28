package com.example.nnnnew.dailycost.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nnnnew on 11/26/2015 AD.
 */
public class DailyCostDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dailyCost.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "transection";
    public static final String COL_ID = "_id";
    public static final String COL_TYPE = "type";
    public static final String COL_DAY = "day";
    public static final String COL_MONTH = "month";
    public static final String COL_YEAR = "year";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_CATALOGUE = "catalogue";
    public static final String COL_NOTE = "note";
    public static final String COL_IC_ID = "iconid";




    public DailyCostDB(Context contexxt) {
        super(contexxt, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE %s (" +
                                "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT," +
                                "%s TEXT)";
        sqlCreateTable = String.format(sqlCreateTable, TABLE_NAME, COL_ID, COL_TYPE, COL_DAY, COL_MONTH, COL_YEAR, COL_AMOUNT, COL_CATALOGUE, COL_NOTE, COL_IC_ID);

        db.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
