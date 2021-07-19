package com.example.lab5_androiddesign.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.os.HandlerCompat
import com.example.lab5_androiddesign.R

class Bai2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai2)

        val progressDialog = ProgressDialog.show(this, "Doi 15s", "Tu tu")

        val timer =object: CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressDialog.setTitle("Doi ${millisUntilFinished/1000}s")
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Bye bye", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        timer.start()

//        Handler(Looper.getMainLooper()).postDelayed(Runnable {
//            progressDialog.dismiss()
////            finish()
//        }, 15000)
    }
}