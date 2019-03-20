package com.example.p0211_twoactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActTwo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            btnActTwo.id -> {
                val intent: Intent = Intent(this, ActivityTwo::class.java)
                startActivity(intent)
            }
        }
    }
}
