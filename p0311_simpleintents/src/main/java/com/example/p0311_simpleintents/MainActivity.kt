package com.example.p0311_simpleintents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeb.setOnClickListener(this)
        btnCall.setOnClickListener(this)
        btnMap.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        var intent: Intent? = null

        when (v.id) {
            btnWeb.id -> {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"))
                startActivity(intent)
            }
            btnMap.id -> {
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("geo:55.754283,37.62002")
                startActivity(intent)
            }
            btnCall.id -> {
                intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:12345")
                startActivity(intent)
            }
        }
    }
}
