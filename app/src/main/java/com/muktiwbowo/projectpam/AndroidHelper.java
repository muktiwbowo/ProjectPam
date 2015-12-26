package com.muktiwbowo.projectpam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muktiwbowo on 26/12/15.
 */
public class AndroidHelper extends SQLiteAssetHelper{
    private static final String  DB_NAME  = "search_db";
    private static final int  DB_VER  = 2;

    private static final String  TB_DATA  = "android";
    public static final String  _ID  = "_id";
    public static final String  KATA_KUNCI = "katakunci";
    public static final String  ARTI_KATA = "artikata";

    private static AndroidHelper dbInstance;
    private static SQLiteDatabase db;

    private AndroidHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    public static AndroidHelper getInstance(Context context)
    {
        if (dbInstance == null)
        {
            dbInstance = new AndroidHelper(context);
            db = dbInstance.getWritableDatabase();
        }
        return dbInstance;
    }

    @Override
    public synchronized void close()
    {
        super.close();
        if (dbInstance != null)
        {
            dbInstance.close();
        }
    }

    public List<Android> getAllKata()
    {
        List<Android> lisAndroid = new ArrayList<Android>();

        Cursor cursor = db.query(TB_DATA, new String[] { _ID, _ID,
                ARTI_KATA, KATA_KUNCI }, null, null, null, null, KATA_KUNCI);
        if (cursor.getCount() >= 1)
        {
            cursor.moveToFirst();

            do
            {
                Android android = new Android();
                android.setaResult(cursor.getString(cursor
                        .getColumnIndexOrThrow(ARTI_KATA)));
                android.setaKeyword(cursor.getString(cursor
                        .getColumnIndexOrThrow(KATA_KUNCI)));
                lisAndroid.add(android);

            } while (cursor.moveToNext());
        }
        return lisAndroid;

    }
}
