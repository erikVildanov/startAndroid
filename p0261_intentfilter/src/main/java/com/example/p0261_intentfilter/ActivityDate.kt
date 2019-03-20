package com.example.p0261_intentfilter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat

class ActivityDate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val date = sdf.format(System.currentTimeMillis())

        tvDate.text = date
    }
}
