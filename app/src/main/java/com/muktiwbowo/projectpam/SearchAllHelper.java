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
public class SearchAllHelper extends SQLiteAssetHelper {
    private static final String  DB_NAME  = "search_db";
    private static final int  DB_VER  = 2;

    private static final String  TB_DATA  = "search_tb";
    public static final String  COL_ID  = "id";
    public static final String  COL_ISTILAH = "keyword";
    public static final String  COL_ARTI = "result";

    private static SearchAllHelper dbInstance;
    private static SQLiteDatabase db;

    private SearchAllHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    public static SearchAllHelper getInstance(Context context)
    {
        if (dbInstance == null)
        {
            dbInstance = new SearchAllHelper(context);
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

    public List<Search> getAllKamus()
    {
        List<Search> lisKamus = new ArrayList<Search>();

        Cursor cursor = db.query(TB_DATA, new String[] { COL_ID, COL_ID,
                COL_ARTI, COL_ISTILAH }, null, null, null, null, COL_ISTILAH);
        if (cursor.getCount() >= 1)
        {
            cursor.moveToFirst();

            do
            {
                Search search = new Search();
                search.setResults(cursor.getString(cursor
                        .getColumnIndexOrThrow(COL_ARTI)));
                search.setKeyword(cursor.getString(cursor
                        .getColumnIndexOrThrow(COL_ISTILAH)));
                lisKamus.add(search);

            } while (cursor.moveToNext());
        }
        return lisKamus;

    }
}
