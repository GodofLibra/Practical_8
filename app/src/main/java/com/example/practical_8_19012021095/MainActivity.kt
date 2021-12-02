package com.example.practical_8_19012021095

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private val YouTubeId = "BZP1rYjoBgI"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView = findViewById<VideoView>(R.id.video_view)

        val webView = findViewById<WebView>(R.id.web_view)
        val webSettings: WebSettings = webView.settings
        //webView.webViewClient(new WebViewClient() )
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webView.loadUrl("https://www.youtube.com/embed/$YouTubeId")
        //webView.loadUrl("https://www.youtube.com/embed/")
        val mediaController = android.widget.MediaController(this)
        mediaController.setAnchorView(videoView)

        val uri:Uri = Uri.parse("android.resource://"+ packageName+"/" + R.raw.ringtone)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}
