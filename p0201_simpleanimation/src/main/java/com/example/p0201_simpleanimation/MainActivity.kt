package com.example.p0201_simpleanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val MENU_ALPHA_ID = 1
    val MENU_SKALE_ID = 2
    val MENU_TRANSLATE_ID = 3
    val MENU_ROTATE_ID = 4
    val MENU_COMBO_ID = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(tv)
    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        if (v == null) return
        if (menu == null) return

        when (v.id) {
            tv.id -> {
                menu.add(0,MENU_ALPHA_ID,0,"Alpha")
                menu.add(0,MENU_SKALE_ID,0,"Scale")
                menu.add(0,MENU_TRANSLATE_ID,0,"Translate")
                menu.add(0,MENU_ROTATE_ID,0,"Rotate")
                menu.add(0,MENU_COMBO_ID,0,"Combo")
            }
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        var anim: Animation? = null
        if (item == null) return false
        when (item.itemId) {
            MENU_ALPHA_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha)
            }
            MENU_SKALE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale)
            }
            MENU_TRANSLATE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans)
            }
            MENU_ROTATE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate)
            }
            MENU_COMBO_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo)
            }
        }

        tv.startAnimation(anim)

        return super.onContextItemSelected(item)
    }
}
