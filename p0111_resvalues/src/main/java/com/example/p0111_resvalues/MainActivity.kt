package com.example.p0111_resvalues

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBottom.setBackgroundResource(R.color.llBottomColor)
        tvBottom.setText(R.string.tvBottomText)
        btnBottom.setText(R.string.btnBottomText)


    }
}
