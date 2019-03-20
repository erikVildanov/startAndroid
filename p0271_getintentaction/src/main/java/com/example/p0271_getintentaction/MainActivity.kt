package com.example.p0271_getintentaction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTime.setOnClickListener(this)
        btnDate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        lateinit var intent: Intent
        if (v == null) {
            return
        }

        when (v.id) {
            btnTime.id -> {
                intent = Intent("ru.startandroid.intent.action.showtime")
                startActivity(intent)
            }
            btnDate.id -> {
                intent = Intent("ru.startandroid.intent.action.showdate")
                startActivity(intent)
            }
        }
    }
}
