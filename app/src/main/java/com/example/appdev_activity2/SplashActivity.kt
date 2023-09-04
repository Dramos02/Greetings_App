package com.example.appdev_activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed( {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
            , SPLASH_TIME)

    }
    //Copyrights © https://github.com/kurut0d
}