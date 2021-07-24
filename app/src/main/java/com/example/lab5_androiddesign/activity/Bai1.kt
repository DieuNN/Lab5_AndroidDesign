package com.example.lab5_androiddesign.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.lab5_androiddesign.R
import kotlinx.android.synthetic.main.activity_bai1.*
import java.util.*

class Bai1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai1)

        // Set end icon on click listener for text input layout

        text_input_layout_date_picker.setEndIconOnClickListener {
            // Calendar.getInstance(), get day, month, year
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)

            // New date picker dialog
            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth -> let {
                edittext_date_picker.setText("$dayOfMonth/${month +1 }/$year")
            } }, year, month, day)
            datePickerDialog.show()
        }

        text_input_layout_time_picker.setEndIconOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
//            val second = calendar.get(Calendar.SECOND)

            val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> let {
                edittext_time_picker.setText("$hourOfDay:$minute")
            } }, hour, minute, true).show()

        }
    }
}