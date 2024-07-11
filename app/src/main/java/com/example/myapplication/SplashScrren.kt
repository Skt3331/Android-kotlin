package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScrren : AppCompatActivity() {
    private val SPLASH_SCREEN_DELAY: Long = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_scrren)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Start the main activity after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScrren, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: close the splash screen activity
        }, SPLASH_SCREEN_DELAY)
    }
}
