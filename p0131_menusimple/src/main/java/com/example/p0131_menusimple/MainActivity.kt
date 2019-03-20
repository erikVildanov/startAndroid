package com.example.p0131_menusimple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu == null) { return  false}
        menu.add("menu1")
        menu.add("menu2")
        menu.add("menu3")
        menu.add("menu4")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) { return  false }
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }
}
