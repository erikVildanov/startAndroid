package com.example.p0191_simplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var oper = ""

    val MENU_RESET_ID = 1
    val MENU_QUIT_ID = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu == null) return false
        menu.add(0,MENU_RESET_ID,0,"Reset")
        menu.add(0,MENU_QUIT_ID,0,"Quit")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) return false
        when (item.itemId) {
            MENU_RESET_ID -> {
                etNum1.text.clear()
                etNum2.text.clear()
                tvResult.text = ""
            }
            MENU_QUIT_ID -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

        if (v == null) return

        var num1: Float = 0.0F
        var num2: Float = 0.0F
        var result: Float = 0.0F

        if (TextUtils.isEmpty(etNum1.text.toString()) || TextUtils.isEmpty(etNum2.text.toString())) {
            return
        }

        num1 = etNum1.text.toString().toFloat()
        num2 = etNum2.text.toString().toFloat()

        when (v.id) {
            btnAdd.id -> {
                oper = "+"
                result = num1 + num2
            }
            btnSub.id -> {
                oper = "-"
                result = num1 - num2
            }
            btnMult.id -> {
            oper = "*"
            result = num1 * num2
            }
            btnDiv.id -> {
                oper = "/"
                result = num1 / num2
            }
        }

        tvResult.text = "$num1 $oper $num2 = $result"

    }
}
