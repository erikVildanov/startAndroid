package com.example.p0341_simplesqlite

import Helper.BDHelper
import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    final val LOG_TAG = "myLogs"

    var dbHelper: BDHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = BDHelper(this)

        btnAdd.setOnClickListener(this)
        btnRead.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnUpd.setOnClickListener(this)
        btnDel.setOnClickListener(this)



    }

    override fun onClick(v: View?) {

        if (v == null) return

        val cv = ContentValues()

        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val id = etID.text.toString()

        val  db = dbHelper!!.writableDatabase

        when (v.id) {
            btnAdd.id -> {
                Log.d(LOG_TAG, "--- Insert in mytable: ---")

                cv.put("name", name)
                cv.put("email", email)

                val rowID = db.insert("mytable", null, cv)
                Log.d(LOG_TAG, "Row inserted, ID = $rowID")
            }

            btnRead.id -> {
                Log.d(LOG_TAG, "--- Rows in mytable: ---")

                val c = db.query("mytable", null, null, null, null, null, null)

                if (c.moveToFirst()) {
                    val idColIndex = c.getColumnIndex("id")
                    val nameColIndex = c.getColumnIndex("name")
                    val emailColIndex = c.getColumnIndex("email")

                    do {
                        Log.d(LOG_TAG, "ID = ${c.getInt(idColIndex)}, name = ${c.getString(nameColIndex)}, email = ${c.getString(emailColIndex)}")
                    } while (c.moveToNext())
                } else
                    Log.d(LOG_TAG, "0 rows")
                c.close()
            }
            btnClear.id -> {
                Log.d(LOG_TAG, "--- Clear mytable: ---")

                val clearCount = db.delete("mytable", null, null)
                Log.d(LOG_TAG, "delete rows count = $clearCount")
            }

            btnUpd.id -> {
                if (id.equals("", false)) return

                Log.d(LOG_TAG, "--- Update mytable: ---")

                cv.put("name", name)
                cv.put("email", email)

                val updCount = db.update("mytable", cv, "id = ?", Array<String>(1){id})
                Log.d(LOG_TAG, "updated rows count = $updCount")
            }
            btnDel.id -> {
                if (id.equals("", false)) return
                Log.d(LOG_TAG, "--- Delete from mytable: ---")
                val delCount = db.delete("mytable", "id = $id", null)
                Log.d(LOG_TAG, "deleted rows count = $delCount")
            }
        }
        dbHelper!!.close()
    }
}
