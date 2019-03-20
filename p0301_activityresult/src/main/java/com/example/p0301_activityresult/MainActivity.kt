package com.example.p0301_activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    final val REQUEST_CODE_COLOR = 1
    final val REQUEST_CODE_ALIGN = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnColor.setOnClickListener(this)
        btnAlign.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == null) return
        var intent: Intent? = null

        when (v.id) {
            btnColor.id -> {
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }
            btnAlign.id -> {
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("myLogs", "requestCode = $requestCode resultCode = $resultCode")

        if (resultCode == Activity.RESULT_OK) when (requestCode) {
            REQUEST_CODE_COLOR -> {
                if (data == null) return
                val color = data.getIntExtra("color", Color.WHITE)
                tvText.setTextColor(color)
            }
            REQUEST_CODE_ALIGN -> {
                if (data == null) return
                val align = data.getIntExtra("alignment", Gravity.LEFT)
                tvText.gravity = align
            }
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }


    }
}
