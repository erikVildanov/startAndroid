package com.example.p0141_menuadv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu == null) { return false }
        menuInflater.inflate(R.menu.mymenu, menu)
//        menu.add(0, 1, 0, "add")
//        menu.add(0, 2, 0, "edit")
//        menu.add(0, 3, 3, "delete")
//        menu.add(1, 4, 1, "copy")
//        menu.add(1, 5, 2, "paste")
//        menu.add(1, 6, 4, "exit")
//        menu.add(2,7,2,"munu1")
//        menu.add(2,8,9,"munu2")
//        menu.add(2,9,10,"munu3")
//        menu.add(2,10,0,"munu4")
//        menu.add(2,11,7,"munu5")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (menu == null) { return false }
        menu.setGroupVisible(R.id.group1, chbExtMenu.isChecked)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) { return false }
        val stringBuilder = StringBuilder()

        stringBuilder.append("Item Menu")
        stringBuilder.append("\r\n groupId: ${item.groupId}")
        stringBuilder.append("\r\n itemId: ${item.itemId}")
        stringBuilder.append("\r\n order: ${item.order}")
        stringBuilder.append("\r\n title: ${item.title}")
        textView.text = stringBuilder.toString()

        return super.onOptionsItemSelected(item)
    }
}
