package com.example.p0161_dynamiclayout

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.widget.LinearLayout
//import android.widget.LinearLayout.LayoutParams
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val linLayout = LinearLayout(this)

        linLayout.orientation = LinearLayout.VERTICAL

        val linLayoutParam = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        setContentView(linLayout, linLayoutParam)

        val lpView = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        val textView = TextView(this)
        textView.text = "TextView"
        textView.layoutParams = lpView
        linLayout.addView(textView)

        val btn = Button(this)
        btn.text = "Button"
        linLayout.addView(btn)

        val leftMarginLayout = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        leftMarginLayout.leftMargin = 50

        val btn1 = Button(this)
        btn1.text = "Button 1"
        linLayout.addView(btn1, leftMarginLayout)


        val rightGravityParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        rightGravityParams.gravity = Gravity.RIGHT

        val btn2 = Button(this)
        btn2.text = "Button 2"
        linLayout.addView(btn2, rightGravityParams)

    }
}
