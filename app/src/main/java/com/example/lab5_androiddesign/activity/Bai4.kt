package com.example.lab5_androiddesign.activity

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5_androiddesign.R

class Bai4 : AppCompatActivity() {
    companion object {
        const val USER_NAME = "abc"
        const val PASSWORD = "123"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai4)

        //Mapping
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
        val username: EditText = view.findViewById(R.id.edittext_username)
        val password: EditText = view.findViewById(R.id.edittext_password)

        // New alert dialog
        AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("Đăng nhập", DialogInterface.OnClickListener { dialog, which -> let {
                if (username.text.toString() == USER_NAME && password.text.toString() == PASSWORD) {
                    Toast.makeText(this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    finish()
                }
                else {
                    Toast.makeText(this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
                    finish()
                }
                Log.e("tag", "${username.text}, ${password.text}")
            }

            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialog.cancel()
                finish()
            })
            .create().show()
    }
}