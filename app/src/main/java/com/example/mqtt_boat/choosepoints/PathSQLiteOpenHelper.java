package com.example.mqtt_boat.choosepoints;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PathSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "pathSQLite.db";
    private static final String TABLE_NAME_MSG = "path_item";

    private static final String CREATE_TABLE_SQL = "create table " + TABLE_NAME_MSG + " (id integer primary key autoincrement, lon text, lat text)";

    //构造函数,创建数据仓
    public PathSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    //以下为两个实现方法
    //创建数据表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(OnePoint mPoint) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put("id", mPoint.getP_ID());
        values.put("lon", mPoint.getP_lon());
        values.put("lat", mPoint.getP_lat());

        return db.insert(TABLE_NAME_MSG, null, values);
    }

    public void deleteFromDbByTopic() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM path_item");
    }

    public int updateData(OnePoint mPoint) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", mPoint.getP_ID());
        values.put("lon", mPoint.getP_lon());
        values.put("lat", mPoint.getP_lat());

        return db.update(TABLE_NAME_MSG, values, "id like ?", new String[]{mPoint.getP_ID()});
    }

    public List<OnePoint> queryFromDbByName(String ID) {

        SQLiteDatabase db = getWritableDatabase();
        List<OnePoint> mPointList = new ArrayList<>();


        Cursor cursor = db.query(TABLE_NAME_MSG, null, "id like ?", new String[]{ID}, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                String P_ID = cursor.getString(cursor.getColumnIndex("id"));
                String LON = cursor.getString(cursor.getColumnIndex("lon"));
                String LAT = cursor.getString(cursor.getColumnIndex("lat"));

                OnePoint mPoint = new OnePoint();
                mPoint.setP_ID(P_ID);
                mPoint.setP_lon(LON);
                mPoint.setP_lat(LAT);

                mPointList.add(mPoint);

            }

            cursor.close();

        }

        return mPointList;

    }

    public List<OnePoint> queryAllFromDb() {

        SQLiteDatabase db = getWritableDatabase();
        List<OnePoint> mPointList = new ArrayList<>();


        Cursor cursor = db.query(TABLE_NAME_MSG, null, null, null, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
//                String ID = cursor.getString(cursor.getColumnIndex("id"));
                String LON = cursor.getString(cursor.getColumnIndex("lon"));
                String LAT = cursor.getString(cursor.getColumnIndex("lat"));

                OnePoint mPoint = new OnePoint();
//                mPoint.setP_ID(ID);
                mPoint.setP_lon(LON);
                mPoint.setP_lat(LAT);

                mPointList.add(mPoint);

            }

            cursor.close();

        }

        return mPointList;

    }
}
