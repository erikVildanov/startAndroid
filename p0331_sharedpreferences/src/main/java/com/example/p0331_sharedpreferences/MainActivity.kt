package com.example.p0331_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var sPref: SharedPreferences? = null

    final val SAVED_TEXT = "saved_text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener(this)
        btnLoad.setOnClickListener(this)

        loadText()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v.id) {
            btnSave.id -> {
                saveText()
            }
            btnLoad.id -> {
                loadText()
            }
        }
    }

    private fun saveText(){
        sPref = getPreferences(Context.MODE_PRIVATE)


        var ed = sPref!!.edit()

        ed.putString(SAVED_TEXT, etText.text.toString())
        ed.commit()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadText(){
        sPref = getPreferences(Context.MODE_PRIVATE)
        val savedText = sPref!!.getString(SAVED_TEXT, "")
        etText.setText(savedText)
        Toast.makeText(this, "Text load", Toast.LENGTH_SHORT).show()

    }
}
