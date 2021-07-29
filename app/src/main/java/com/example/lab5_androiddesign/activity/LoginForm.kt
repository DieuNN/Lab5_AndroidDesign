package com.example.lab5_androiddesign.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab5_androiddesign.R
import kotlinx.android.synthetic.main.activity_bai1.*
import kotlinx.android.synthetic.main.activity_login_form.*
import java.util.*

class LoginForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        text_input_layout_text_form_date.setEndIconOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)

            // New date picker dialog
            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth -> let {
                text_input_edit_text_form_date.setText("$dayOfMonth/${month +1 }/$year")
            } }, year, month, day)
            datePickerDialog.show()
        }

        val genderList = mutableListOf<String>("Nam", "Nữ")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_form_gender.adapter = adapter

        // Validation
        button_form_signin.setOnClickListener {
            if(text_input_edit_text_form_username.text.toString().isEmpty()) {
                text_input_layout_form_username.error = "Không đuợc để trống username"
                return@setOnClickListener
            } else {
                text_input_layout_form_username.error = null
            }

            if(text_input_edit_text_form_password.text.toString().isEmpty()) {
                text_input_layout_form_password.error = "Không được để trống mật khẩu"
                return@setOnClickListener
            } else {
                text_input_layout_form_password.error = null
            }

            if (text_input_edit_text_form_email.text.toString().isEmpty()) {
                text_input_layout_form_email.error  = "Không được để trống email"
                return@setOnClickListener
            } else {
                text_input_layout_form_email.error = null
            }

            if (text_input_edit_text_form_date.text.toString().isEmpty()) {
                text_input_layout_text_form_date.error = "Không được để trống ngày sinh"
                return@setOnClickListener
            } else {
                text_input_layout_text_form_date.error = null
            }

            if (text_input_edit_text_form_address.text.toString().isEmpty()) {
                text_input_layout_form_address.error = "Không được để trống địa chỉ"
                return@setOnClickListener
            } else {
                text_input_layout_form_address.error = null
            }

            if (text_input_edit_text_form_phone.text.toString().isEmpty()) {
                text_input_layout_form_phone.error = "Không được để trống SDT"
                return@setOnClickListener
            } else {
                text_input_layout_form_phone.error = null
            }



            AlertDialog.Builder(this)
                .setTitle("Thông tin")
                .setMessage("Username: ${text_input_edit_text_form_username.text.toString()} \n" +
                        "Password: ${text_input_edit_text_form_password.text.toString()} \n" +
                        "Email: ${text_input_edit_text_form_email.text.toString()} \n" +
                        "Ngày sinh: ${text_input_edit_text_form_date.text.toString()} \n" +
                        "Giới tính: ${spinner_form_gender.selectedItem.toString()} \n" +
                        "Địa chỉ: ${text_input_edit_text_form_address.text.toString()} \n" +
                        "Điện thoại: ${text_input_edit_text_form_phone.text.toString()} \n" +
                        "Độc thân: ${toggle_button_marriage.text}")
                .create()
                .show()
        }

        button_form_cancel.setOnClickListener {
            Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                finish()
            }, 1500)
        }
    }
}