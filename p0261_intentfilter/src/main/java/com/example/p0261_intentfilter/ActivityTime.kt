package com.example.p0261_intentfilter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_time.*
import java.text.SimpleDateFormat
import java.util.*

class ActivityTime : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(Date(System.currentTimeMillis()))

        tvTime.text = time

    }
}
