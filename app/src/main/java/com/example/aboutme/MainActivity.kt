package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonDone).setOnClickListener {
            addNickname(it)

        }

        findViewById<TextView>(R.id.textNickName).setOnClickListener {
            updateNickname(it)

        }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editNickName)
        val nicknameTextView = findViewById<TextView>(R.id.textNickName)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.editNickName)
        val doneButton = findViewById<Button>(R.id.buttonDone)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        //Set the focus to the edit text.
        editText.requestFocus()

        //Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
}
