package com.sabkayar.praveen.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sabkayar.praveen.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    // Instance of MyName data class.
    private val myName: MyName = MyName("Praveen Kumar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.myName = myName

        mBinding.doneButton.setOnClickListener() {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

        mBinding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll() //Mandatory for fresh update in databinding
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        hideKeyboard(view)

    }

    private fun hideKeyboard(view: View) {
        // Hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}