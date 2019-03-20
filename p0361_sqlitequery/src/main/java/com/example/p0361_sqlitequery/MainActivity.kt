package com.example.p0361_sqlitequery

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    final val LOG_TAG = "myLogs"

    val name = arrayOf("Китай", "США", "Бразилия", "Россия", "Япония", "Германия", "Египет", "Италия", "Франция", "Канада")
    val people = arrayOf(1400, 311, 195, 142, 128, 82, 80, 60, 66, 35)
    val region = arrayOf("Азия", "Америка", "Америка", "Европа", "Азия", "Европа", "Африка", "Европа", "Европа", "Америка")

    var dbHelper: DBHelper? = null
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAll.setOnClickListener(this)
        btnFunc.setOnClickListener(this)
        btnPeople.setOnClickListener(this)
        btnSort.setOnClickListener(this)
        btnGroup.setOnClickListener(this)
        btnHaving.setOnClickListener(this)

        dbHelper = DBHelper(this)
        db = dbHelper!!.writableDatabase


        val c = db!!.query("mytable", null, null, null, null, null, null)
        if (c.count == 0) {
            val cv = ContentValues()

            for (i in 0..10) {
                cv.put("name", name[i])
                cv.put("people", people[i])
                cv.put("region", region[i])
                Log.d(LOG_TAG, "id = ${db!!.insert("mytable", null, cv)}")
            }
        }
        c.close()
        dbHelper!!.close()
        onClick(btnAll)
    }

    override fun onClick(v: View?) {

        if (v == null) return

        db = dbHelper!!.writableDatabase


        val sFunc = etFunc.text.toString()
        val sPeople = etPeople.text.toString()
        val sRegionPeople = etRegionPeople.text.toString()

        var columns: Array<String>? = null
        var selection: String? = null
        var selectionArgs: Array<String>? = null
        var groupBy: String? = null
        var having: String? = null
        var orderBy: String? = null

        var c: Cursor? = null

        when (v.id){
            btnAll.id -> {
                Log.d(LOG_TAG, "--- Все записи ---")
                c = db!!.query("mytable", null, null, null, null, null, null)
            }

            btnFunc.id -> {
                Log.d(LOG_TAG, "--- Функция $sFunc ---")
                columns = arrayOf(sFunc)
                c = db!!.query("mytable", columns, null, null, null, null, null)
            }

            btnPeople.id -> {
                Log.d(LOG_TAG, "--- Население больше $sPeople ---")
                selection = "people > ?"
                selectionArgs = arrayOf(sPeople)
                c = db!!.query("mytable", null, selection, selectionArgs, null, null, null)
            }

            btnGroup.id -> {
                Log.d(LOG_TAG, "--- Население по региону ---")
                columns = arrayOf("region", "sum(people) as people")
                groupBy = "region"
                c = db!!.query("mytable", columns, null, null, groupBy, null, null)
            }

            btnHaving.id -> {
                Log.d(LOG_TAG, "--- Регионы с населением больше $sRegionPeople ---")
                columns = arrayOf( "region", "sum(people) as people")
                groupBy = "region"
                having = "sum(people) > $sRegionPeople"
                c = db!!.query("mytable", columns, null, null, groupBy, having, null)
            }

            btnSort.id -> {
                when (rgSort.checkedRadioButtonId) {
                    rName.id -> {
                        Log.d(LOG_TAG, "--- Сортировка по наименованию ---")
                        orderBy = "name"
                    }

                    rPeople.id -> {
                        Log.d(LOG_TAG, "--- Сортировка по населению ---")
                        orderBy = "people"
                    }

                    rRegion.id -> {
                        Log.d(LOG_TAG, "--- Сортировка по региону ---")
                        orderBy = "region"
                    }
                }
                c = db!!.query("mytable", null, null, null, null, null, orderBy)
            }
        }

        if (c != null) {
            if (c.moveToFirst()) {
                var str :String? = null

                do {
                    str = ""
                    for (cn in c.columnNames) {
                        str = str.plus(cn).plus(" = ").plus(c.getString(c.getColumnIndex(cn))).plus(": ")
                    }
                    Log.d(LOG_TAG, str)
                } while (c.moveToNext())
            }
            c.close()
        } else {
            Log.d(LOG_TAG, "Cursor is null")
        }

        dbHelper!!.close()
    }
}


class DBHelper: SQLiteOpenHelper {

    constructor(context: Context): super(context, "myBD", null, 1)


    override fun onCreate(db: SQLiteDatabase?) {
        if (db == null) return
        Log.d("myLogs", "--- onCreate database ---")

        db.execSQL("create table mytable (id integer primary key autoincrement, name text, people integer, region text)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}