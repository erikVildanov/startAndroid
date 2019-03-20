package com.example.p0281_intentextras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val intent = intent

        val fName = intent.getStringExtra("fmane")
        val lName = intent.getStringExtra("lname")

        tvView.text = "Your name is: $fName $lName"
    }
}
