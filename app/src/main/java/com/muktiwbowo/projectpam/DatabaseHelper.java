package com.muktiwbowo.projectpam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muktiwbowo on 19/12/15.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String  DB_NAME  = "search_db";
    private static final int  DB_VER  = 1;

    private static final String  TB_DATA  = "search_tb";
    public static final String  COL_ID  = "id";
    public static final String  COL_ISTILAH = "keyword";
    public static final String  COL_ARTI = "result";

    private static DatabaseHelper dbInstance;
    private static SQLiteDatabase db;

    private DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    public static DatabaseHelper getInstance(Context context)
    {
        if (dbInstance == null)
        {
            dbInstance = new DatabaseHelper(context);
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

    public List<Kamus> getAllKamus()
    {
        List<Kamus> lisKamus = new ArrayList<Kamus>();

        Cursor cursor = db.query(TB_DATA, new String[] { COL_ID, COL_ID,
                COL_ARTI, COL_ISTILAH }, null, null, null, null, COL_ISTILAH);
        if (cursor.getCount() >= 1)
        {
            cursor.moveToFirst();

            do
            {
                Kamus kamus = new Kamus();
                kamus.setResults(cursor.getString(cursor
                        .getColumnIndexOrThrow(COL_ARTI)));
                kamus.setKeyword(cursor.getString(cursor
                        .getColumnIndexOrThrow(COL_ISTILAH)));
                lisKamus.add(kamus);

            } while (cursor.moveToNext());
        }
        return lisKamus;

    }
}
