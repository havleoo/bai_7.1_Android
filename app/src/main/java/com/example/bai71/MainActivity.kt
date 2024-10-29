package com.example.bai71

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var dobButton: Button
    private lateinit var submitButton: Button
    private lateinit var agreeCheckBox: CheckBox
    private lateinit var nameEditText: EditText
    private lateinit var mssvEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mssvEditText = findViewById(R.id.editText_mssv)
        nameEditText = findViewById(R.id.editText_fullname)
        emailEditText = findViewById(R.id.editText_email)
        phoneEditText = findViewById(R.id.editText_phone)
        genderRadioGroup = findViewById(R.id.radioGroup_gender)
        calendarView = findViewById(R.id.calendarView_dob)
        dobButton = findViewById(R.id.button_dob)
        agreeCheckBox = findViewById(R.id.checkbox_agree)
        submitButton = findViewById(R.id.button_submit)

        // Toggle CalendarView visibility
        dobButton.setOnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        // Submit button click
        submitButton.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        if (mssvEditText.text.isEmpty() || nameEditText.text.isEmpty() ||
            emailEditText.text.isEmpty() || phoneEditText.text.isEmpty() ||
            genderRadioGroup.checkedRadioButtonId == -1 ||
            !agreeCheckBox.isChecked) {

            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin và đồng ý điều khoản.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Thông tin đã được gửi thành công.", Toast.LENGTH_SHORT).show()
        }
    }
}
