package com.sabkayar.praveen.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener() {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        val nickNameEditText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        nickNameTextView.text=nickNameEditText.text
        nickNameEditText.visibility=View.GONE
        view.visibility =View.GONE
        nickNameTextView.visibility=View.VISIBLE

        hideKeyboard(view)

    }

    private fun hideKeyboard(view: View) {
        // Hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}