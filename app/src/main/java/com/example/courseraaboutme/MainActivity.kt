package com.example.courseraaboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.courseraaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Szymon Nedzi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = GONE
            nicknameText.visibility = VISIBLE
            doneButton.visibility = GONE
        }

        //Hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
