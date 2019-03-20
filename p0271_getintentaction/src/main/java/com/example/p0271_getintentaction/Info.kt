package com.example.p0271_getintentaction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.info.*
import java.text.SimpleDateFormat

class Info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)

        val intent = intent
        val action = intent.action
        var format = ""
        var textInfo = ""

        if (action.equals("ru.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss"
            textInfo = "Time: "
        } else if (action.equals("ru.startandroid.intent.action.showdate")){
            format = "dd.MM.yyyy"
            textInfo = "Date: "
        }


        val sdf = SimpleDateFormat(format)
        val dateTime = sdf.format(System.currentTimeMillis())

        tvInfo.text = textInfo + dateTime

    }
}
