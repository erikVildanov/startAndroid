package com.example.p0281_intentextras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("fmane", etFName.text.toString())
        intent.putExtra("lname", etLName.text.toString())
        startActivity(intent)
    }
}
