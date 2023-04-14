package com.example.colorquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        window.statusBarColor = ContextCompat.getColor(this, R.color.color_full)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },4300)
    }
}