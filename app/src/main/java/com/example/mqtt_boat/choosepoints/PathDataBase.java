package com.example.mqtt_boat.choosepoints;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PathDataBase extends SQLiteOpenHelper {
    private static String name="pathdata.db";
    private static final String TABLE_NAME_MSG = "po_item";
    private static int version = 1;
    public PathDataBase(@Nullable Context context) {
        super(context, name, null, version);  //内容，数据库名称，null
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStr = "create table user(ID varchar(20),经度 varchar(20),纬度 varchar(20))";
        db.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<OnePoint> queryAllFromDb() {

        SQLiteDatabase db = getWritableDatabase();
        List<OnePoint> poitemList = new ArrayList<>();


        Cursor cursor = db.query(TABLE_NAME_MSG, null, null, null, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                String ID = cursor.getString(cursor.getColumnIndex("ID"));
                String LON = cursor.getString(cursor.getColumnIndex("lon"));
                String LAT = cursor.getString(cursor.getColumnIndex("lat"));

                OnePoint PoItem = new OnePoint();
                PoItem.setP_ID(ID);
                PoItem.setP_lon(LON);
                PoItem.setP_lat(LAT);

                poitemList.add(PoItem);
            }
            cursor.close();
        }

        return poitemList;

    }
}
