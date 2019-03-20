package Helper

import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class BDHelper: SQLiteOpenHelper {

    constructor(context: Context) : super(context, "myBD", null, 1)

    override fun onCreate(db: SQLiteDatabase?) {
        if (db == null) return

        Log.d("myLogs", "--- onCreate database ---")

        db.execSQL("create table mytable (id integer primary key autoincrement, name text, email text ); ")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}