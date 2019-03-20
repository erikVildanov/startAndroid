package com.example.p0101_listener

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создание обработчика
        val oclBtn = object : View.OnClickListener {
            override fun onClick(v: View) {
                when (v.id) {
                    btnOk.id ->
                        // кнопка ОК
                        tvOut.text = "Нажата кнопка ОК"
                    btnCancel.id ->
                        // кнопка Cancel
                        tvOut.text = "Нажата кнопка Cancel"
                }

            }
        }

        btnOk.setOnClickListener(oclBtn)
        btnCancel.setOnClickListener(oclBtn)

    }

}

