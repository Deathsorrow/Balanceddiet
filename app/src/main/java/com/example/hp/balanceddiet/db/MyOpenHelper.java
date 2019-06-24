package com.example.hp.balanceddiet.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "lol.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists lol(_id integer primary key autoincrement,name varchar(20))");
        for (int x=0;x<20;x++){
            db.execSQL("insert into lol(name) values(?)",new String[]{"苦瓜醸肉馅","山药莲子炖乌鸡","板栗百合煲鸡脚"});
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
