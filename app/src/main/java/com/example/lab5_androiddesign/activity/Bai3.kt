package com.example.lab5_androiddesign.activity

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab5_androiddesign.R
import kotlinx.android.synthetic.main.activity_bai3.*

class Bai3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai3)

        // Normal Dialog
        button_open_dialog1.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Xin chào, đây là tiêu đề").setMessage("Xin chào, đây là nội dung")
                .setPositiveButton(
                    "OK",
                    DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                    }).create().show()
        }

        //List Dialog
        button_open_dialog2.setOnClickListener {
            val items = this.resources.getStringArray(R.array.color)
            AlertDialog.Builder(this)
                .setTitle("Chọn màu")
                .setItems(items, DialogInterface.OnClickListener { dialog, which ->
                    when(which) {
                        0-> Toast.makeText(this, "Red",  Toast.LENGTH_SHORT).show()
                        1-> Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show()
                        2-> Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
                    }
                }).create().show()
        }

        //Radio button Dialog
        button_open_dialog3.setOnClickListener {
            val items = this.resources.getStringArray(R.array.color)
            AlertDialog.Builder(this)
                .setTitle("Chọn màu")
                .setSingleChoiceItems(items, 1000, DialogInterface.OnClickListener { dialog, which ->
                    when(which) {
                        0-> Toast.makeText(this, "Red",  Toast.LENGTH_SHORT).show()
                        1-> Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show()
                        2-> Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
                    }
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
                .create().show()
        }

        //Checkbox dialog
        button_open_dialog4.setOnClickListener {
            val items = this.resources.getStringArray(R.array.color)
            val checked = mutableListOf<Boolean>(false, false, false)
            AlertDialog.Builder(this)
                .setTitle("Chọn màu")
                .setMultiChoiceItems(items, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    when(which) {
                        0-> Toast.makeText(this, "Red",  Toast.LENGTH_SHORT).show()
                        1-> Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show()
                        2-> Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
                    }
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
                .create().show()
        }

    }
}