package com.divyanshu.instalite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var webView: WebView
    lateinit var progressBar: ProgressBar
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefreshLayout = findViewById(R.id.swipe)
        webView = findViewById(R.id.webview)
        progressBar = findViewById(R.id.progressBar)
        webView.loadUrl("https://www.instagram.com/")
        webView.settings.javaScriptEnabled = true

        swipeRefreshLayout.setOnRefreshListener{
            swipeRefreshLayout.isRefreshing=false
            webView.loadUrl("https://www.instagram.com/")
        }
        webView.setWebViewClient(object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url:String): Boolean {
                view.loadUrl(url)
                Log.e("TAG","in should override")
                System.out.println("in should override")
                return true
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        })

    }
}