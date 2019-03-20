package com.example.p0181_dynamiclayout3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var lParams1: LinearLayout.LayoutParams? = null
    var lParams2: LinearLayout.LayoutParams? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sbWeight.setOnSeekBarChangeListener(this)

        lParams1 = btn1.layoutParams as LinearLayout.LayoutParams
        lParams2 = btn2.layoutParams as LinearLayout.LayoutParams

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (seekBar == null) return
        val rightValue = seekBar.max - progress

        if (lParams1 == null && lParams2 == null) return

        lParams1?.weight = progress.toFloat()
        lParams2?.weight= rightValue.toFloat()

            btn1.text = progress.toString()
            btn2.text = rightValue.toString()

        btn1.requestLayout()
        btn2.requestLayout()




    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}
