package com.example.p0321_simplebrowser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_browser.*

class BrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        webView.webViewClient = WebViewClient()
        val data = intent.data
        webView.loadUrl(data.toString())
    }
}
