package me.about.khan.zian.hasan.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import me.about.khan.zian.hasan.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.buttonDone.setOnClickListener {
            addNickName(it)
        }


    }

    fun addNickName(view: View) {
        binding.apply {
            myName?.nickname = nickEdit.text.toString()
            invalidateAll()
            nickEdit.visibility = View.GONE
            view.visibility = View.GONE
            nickName.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
