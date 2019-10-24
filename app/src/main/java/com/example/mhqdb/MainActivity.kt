package com.example.mhqdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Gravity
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class MainActivity : AppCompatActivity(), TextWatcher {

    private var EditName:EditText? = null
    private var EditAge:EditText? = null
    private var Name:String? = null
    private var Age:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EditName = findViewById(R.id.editText_Name) as EditText
            //EditAge = findViewById(R.id.editText_Age) as EditText

        //EditName?.addTextChangedListener(this)
        //EditAge?.addTextChangedListener(this)

    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val toast = Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER,Gravity.CENTER_HORIZONTAL,Gravity.CENTER_VERTICAL)
        val toastview = toast.view
        toastview.setBackgroundResource(R.drawable.toast_drawable)
        toast.show()

    }
}
