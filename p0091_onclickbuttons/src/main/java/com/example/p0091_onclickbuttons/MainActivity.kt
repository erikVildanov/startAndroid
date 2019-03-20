package com.example.p0091_onclickbuttons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {
            tvOut.text = "Нажата кнопка ОК"
        }

        btnCancel.setOnClickListener {
            tvOut.text = "Нажата кнопка Cancel"
        }
    }
}
