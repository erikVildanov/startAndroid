package com.example.p0102activitylistener

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) { return }
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
