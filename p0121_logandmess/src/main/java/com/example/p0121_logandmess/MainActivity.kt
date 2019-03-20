package com.example.p0121_logandmess

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG: String = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "присваиваем обработчик кнопкам")
        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == null) { return }
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        when (v.id) {
            btnOk.id ->
                tappedOK()
            btnCancel.id ->
                tappedCancel()
        }
    }

    private fun tappedOK() {
        Log.d(TAG, "кнопка ОК");
        tvOut.text = "Нажата кнопка ОК"
        Toast.makeText(this,"Нажата кнопка ОК", Toast.LENGTH_LONG).show()
    }

    private fun tappedCancel(){
        Log.d(TAG, "кнопка Cancel")
        tvOut.text = "Нaжата кнопка Cancel"
        Toast.makeText(this,"Нажата кнопка Cancel", Toast.LENGTH_LONG).show()
    }
}
