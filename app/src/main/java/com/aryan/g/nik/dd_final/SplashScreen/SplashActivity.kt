package com.aryan.g.nik.dd_final.SplashScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aryan.g.nik.dd_final.R
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.aryan.g.nik.dd_final.MainMenu.MainActivity
import org.json.JSONObject
import java.lang.Exception

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //burning candle
        //3 characters
        //candle light effect the faces
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            Handler(Looper.getMainLooper()).postDelayed({
                this@SplashActivity.startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }, 1000)
        }
        catch (e: Exception)
        {
            Log.d("TAG" , "onCreate: "+e.message)
        }

    }
}