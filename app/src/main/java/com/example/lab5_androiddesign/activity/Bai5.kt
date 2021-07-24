package com.example.lab5_androiddesign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.DatePicker
import android.widget.Toast
import com.example.lab5_androiddesign.R
import kotlinx.android.synthetic.main.activity_bai5.*
import java.text.SimpleDateFormat
import java.util.*

class Bai5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai5)

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()

        date_picker_bai5_1.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), DatePicker.OnDateChangedListener { datePicker, year, monthOfYear, dayOfMonth ->
            textview_bai5_1.text = "$year-${monthOfYear + 1}-$dayOfMonth"
        })

        button_bai5_1.setOnClickListener {
            textview_bai5_2.text = SimpleDateFormat("dd/MM/yyyy").format(convertDate(textview_bai5_1.text.toString()))
        }
    }

    private fun convertDate(inputDate: String) :Date {
        return SimpleDateFormat("yyyy-MM-dd").parse(inputDate)
    }
}