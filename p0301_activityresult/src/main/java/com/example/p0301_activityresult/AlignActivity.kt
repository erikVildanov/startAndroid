package com.example.p0301_activityresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_align.*

class AlignActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)

        btnLeft.setOnClickListener(this)
        btnCenter.setOnClickListener(this)
        btnRight.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        val intent = Intent()

        when (v.id) {
            btnLeft.id -> intent.putExtra("alignment", Gravity.LEFT)
            btnCenter.id -> intent.putExtra("alignment", Gravity.CENTER)
            btnRight.id -> intent.putExtra("alignment", Gravity.RIGHT)
        }

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
