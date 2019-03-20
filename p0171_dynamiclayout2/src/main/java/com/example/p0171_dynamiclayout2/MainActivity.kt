package com.example.p0171_dynamiclayout2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    var llMain: LinearLayout? = null
//    var rgGravity: RadioGroup? = null
    val wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreate.setOnClickListener(this)
        btnClear.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        when (v.id) {
            btnCreate.id -> {
                val lParams = LinearLayout.LayoutParams(wrapContent,wrapContent)
                var btnGravity = Gravity.LEFT

                when (rgGravity.checkedRadioButtonId) {
                    rbLeft.id -> btnGravity = Gravity.LEFT
                    rbCenter.id -> btnGravity = Gravity.CENTER_HORIZONTAL
                    rbRight.id -> btnGravity = Gravity.RIGHT
                }

                lParams.gravity = btnGravity

                val btnNew = Button(this)
                btnNew.text = etName.text.toString()
                llMain.addView(btnNew, lParams)

            }
            btnClear.id -> {
                llMain.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
