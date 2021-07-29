package com.example.lab5_androiddesign.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5_androiddesign.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_bai1.setOnClickListener {
            startActivity(Intent(this, Bai1::class.java))
        }


        button_bai2.setOnClickListener {
            startActivity(Intent(this, Bai2::class.java))
        }

        button_bai3.setOnClickListener {
            startActivity(Intent(this, Bai3::class.java))
        }

        button_bai4.setOnClickListener {
            startActivity(Intent(this,Bai4::class.java))
        }

        button_bai5.setOnClickListener {
            startActivity(Intent(this, Bai5::class.java))
        }

        button_bai_login.setOnClickListener {
            startActivity(Intent(this, LoginForm::class.java))
        }


    }
}