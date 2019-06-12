package me.about.khan.zian.hasan.aboutme

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_done).setOnClickListener {
            addNickName(it)
        }


    }

    fun addNickName(view: View) {
        val editText = findViewById<EditText>(R.id.nick_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nick_name)

        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE

        nickNameTextView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}