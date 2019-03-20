package com.example.p0301_activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_color.*

class ColorActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        btnRed.setOnClickListener(this)
        btnGreen.setOnClickListener(this)
        btnBlue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        val intent = Intent()

        when (v.id) {
            btnRed.id -> intent.putExtra("color", Color.RED)
            btnGreen.id -> intent.putExtra("color", Color.GREEN)
            btnBlue.id -> intent.putExtra("color", Color.BLUE)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
