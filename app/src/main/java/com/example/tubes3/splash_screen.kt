package com.example.tubes3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_screen : AppCompatActivity() {

   // private val splashTime : Long =2500


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var handler: Handler

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        handler= Handler()
        handler.postDelayed({

            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)

    }
}