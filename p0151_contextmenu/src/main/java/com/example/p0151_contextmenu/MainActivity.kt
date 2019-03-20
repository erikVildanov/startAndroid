package com.example.p0151_contextmenu

import android.app.Activity
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MENU_COLOR_RED = 1
    val MENU_COLOR_GREEN = 2
    val MENU_COLOR_BLUE = 3
    val MENU_SIZE_22 = 4
    val MENU_SIZE_26 = 5
    val MENU_SIZE_30 = 6

    private val TAG: String = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "регестрируем меню")

        registerForContextMenu(tvColor)
        registerForContextMenu(tvSize)
//        tvColor.setOnCreateContextMenuListener(this)
//        tvSize.setOnCreateContextMenuListener(this)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        Log.d(TAG, "вошли в onCreateContextMenu")
        if (menu == null) {return}
        if (v == null) {return}
//        if (menuInfo == null) {return}

        when (v.id) {
            tvColor.id -> {
                menu.add(0, MENU_COLOR_RED, 0, "Red")
                menu.add(0, MENU_COLOR_GREEN, 0, "Green")
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue")
            }//addMenuColor(menu)
            tvSize.id -> {
                menu.add(0, MENU_SIZE_22, 0, "22")
                menu.add(0, MENU_SIZE_26, 0, "26")
                menu.add(0, MENU_SIZE_30, 0, "30")
            }//addMenuSize(menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        Log.d(TAG, "вошли в onContextItemSelected")
        if (item == null) {return false}

        when (item.itemId) {
            MENU_COLOR_RED -> {
                tvColor.setTextColor(Color.RED)
                tvColor.text = "Text color = red"
            }
            MENU_COLOR_GREEN -> {
                tvColor.setTextColor(Color.GREEN)
                tvColor.text = "Text color = green"
            }
            MENU_COLOR_BLUE -> {
                tvColor.setTextColor(Color.BLUE)
                tvColor.text = "Text color = blue"
            }
            // пункты меню для tvSize
            MENU_SIZE_22 -> {
                tvSize.textSize = 22f
                tvSize.text = "Text size = 22"
            }
            MENU_SIZE_26 -> {
                tvSize.textSize = 26f
                tvSize.text = "Text size = 26"
            }
            MENU_SIZE_30 -> {
                tvSize.textSize = 30f
                tvSize.text = "Text size = 30"
            }
        }

        return super.onContextItemSelected(item)
    }

    private fun addMenuColor(menu: Menu) {
        Log.d(TAG, "вошли в addMenuColor")
        menu.add(0, MENU_COLOR_RED, 0, "Red")
        menu.add(0, MENU_COLOR_GREEN, 0, "Green")
        menu.add(0, MENU_COLOR_BLUE, 0, "Blue")
    }

    private fun addMenuSize(menu: Menu) {
        Log.d(TAG, "вошли в addMenuSize")
        menu.add(0, MENU_SIZE_22, 0, "22")
        menu.add(0, MENU_SIZE_26, 0, "26")
        menu.add(0, MENU_SIZE_30, 0, "30")
    }
}
