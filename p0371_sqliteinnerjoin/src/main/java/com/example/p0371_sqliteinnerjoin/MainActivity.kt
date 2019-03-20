package com.example.p0371_sqliteinnerjoin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Model {

    companion object Factory {
        val positionId = arrayOf(1,2,3,4)
        val positionName = arrayOf("Директор", "Программер", "Бухгалтер", "Охранник")
        val positionSalary = arrayOf(15000, 13000, 10000, 8000)

        val peopleName = arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь")
        val peoplePosid = arrayOf(2, 3, 2, 2, 3, 1, 2, 4)
    }
}

class MainActivity : AppCompatActivity() {

    val LOG_TAG = "myLogs"

    var dbHelper: DBHelper? = null
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)
        db = dbHelper!!.writableDatabase

//        val c: Cursor? = null

        Log.d(LOG_TAG, "--- Table position ---")

        var c = db!!.query("position",null,null,null,null,null,null)

        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")

        Log.d(LOG_TAG, "--- INNER JOIN with rawQuery---")

        var sqlQuery = "select PL.name as Name, PS.name as Position, salary as Salary" +
                " from people as PL" +
                " inner join position as PS" +
                " on PL.posid = PS.id" +
                " where salary > ?"
        c = db!!.rawQuery(sqlQuery, arrayOf("12000"))
        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")

        Log.d(LOG_TAG, "--- INNER JOIN with query---")

        val table = "people as PL inner join position as PS on PL.posid = PS.id"
        val columns = arrayOf("PL.name as Name", "PS.name as Position", "salary as Salary")
        val selection = "salary < ?"
        val selectionArgs = arrayOf("12000")
        c = db.query(table, columns, selection, selectionArgs, null, null, null)

        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")

        dbh.close()

    }


    private fun logCursor(c: Cursor?) {
        if (c != null) {
            if (c.moveToFirst()) {
                var str: String? = null

                do {
                    str = ""
                    for (cn in c.columnNames) {
                        str = str.plus(cn).plus(" = ".plus(c.getString(c.getColumnIndex(cn)))).plus("; ")
                    }
                    Log.d(LOG_TAG, str)
                } while (c.moveToNext())
            }
        } else {
            Log.d(LOG_TAG, "Cursor is null")
        }
    }
}


class DBHelper: SQLiteOpenHelper {

    constructor(context: Context): super(context, "myBD", null, 1)

    override fun onCreate(db: SQLiteDatabase?) {
        if (db == null) return
        Log.d("myLogs", "--- onCreate database ---")

        val cv = ContentValues()

        db.execSQL("create table position (id integer primary key, name text, salary integer );")

        for (i in 0..Model.positionId.count()) {
            cv.clear();
            cv.put("id", Model.positionId[i])
            cv.put("name", Model.positionName[i])
            cv.put("salary", Model.positionSalary[i])
            db.insert("position", null, cv)
        }

        db.execSQL("create table people (id integer primary key autoincrement, name text, posid integer);");

        for (i in 0..Model.peopleName.count()) {
            cv.clear();
            cv.put("name", Model.peopleName[i])
            cv.put("posid", Model.peoplePosid[i])
            db.insert("people", null, cv)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
