package com.example.administrator.demo1.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.administrator.demo1.util.DBUtil;

/**
 * Created by Administrator on 2017/12/21.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DatabaseHelper";

    private Context mcontext;

//    public static final String CREATE_NEWS = "create table News(" +
//            "id integer primary key autoincrement," +
//            "title text," +
//            "content text," +
//            "author text," +
//            "like integer," +
//            "comment integer," +
//            "date text)";

    public static final String CREATE_USER = "create table User(" +
            "id integer primary key autoincrement," +
            "username text," +
            "password text," +
            "email text," +
            "iconId integer)";

    public static final String CREATE_PHOTO = "create table Photo(" +
            "id integer primary key autoincrement," +
            "description text," +
            "photoId integer," +
            "isRead text)";

    public static final String CREATE_COMMENT = "create table Comment(" +
            "id integer primary key autoincrement," +
            "date text," +
            "newsId integer," +
            "content text," +
            "userId integer)";

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COMMENT);
//        db.execSQL(CREATE_NEWS);
        db.execSQL(CREATE_PHOTO);
        db.execSQL(CREATE_USER);
        //DBUtil.initData();
        Log.d(TAG, "onCreate: Database created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Photo");
        db.execSQL("drop table if exists News");
        db.execSQL("drop table if exists Comment");
        this.onCreate(db);
    }
}
