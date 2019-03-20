package com.example.p0321_simplebrowser

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeb.setOnClickListener(View.OnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ya.ru")))
        })

    }
}
