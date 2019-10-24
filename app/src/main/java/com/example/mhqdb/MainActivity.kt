package com.example.mhqdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import android.view.Gravity
import android.view.View
import android.widget.ImageButton


class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    private var EditName:EditText? = null
    private var EditAge:EditText? = null
    private var Name:String? = null
    private var Age:Int = 0

    private var MHG:ImageButton? = null
    private var MH3RD:ImageButton? = null
    private var MHFU:ImageButton? = null
    private var MH3G:ImageButton? = null
    private var MH4U:ImageButton? = null
    private var MHXX:ImageButton? = null
    private var MHW:ImageButton? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EditName = findViewById(R.id.editText_Name) as EditText
            //EditAge = findViewById(R.id.editText_Age) as EditText
        MHG = findViewById(R.id.MHG) as ImageButton
        MHFU = findViewById(R.id.MHFU) as ImageButton
        MH3RD = findViewById(R.id.MH3RD) as ImageButton
        MH3G = findViewById(R.id.MH3G) as ImageButton
        MH4U = findViewById(R.id.MH4U) as ImageButton
        MHXX = findViewById(R.id.MHXX) as ImageButton
        MHW = findViewById(R.id.MHW) as ImageButton

        MHG!!.setOnClickListener(this)
        MHFU!!.setOnClickListener(this)
        MH3RD!!.setOnClickListener(this)
        MH3G!!.setOnClickListener(this)
        MH4U!!.setOnClickListener(this)
        MHXX!!.setOnClickListener(this)
        MHW!!.setOnClickListener(this)

        //EditName?.addTextChangedListener(this)
        //EditAge?.addTextChangedListener(this)

    }

    override fun onClick(v: View?) {
        var ID: String? = null
        if (v != null) {
             ID = v.resources.getResourceEntryName(v.id)
        }

        openMHG(ID)
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
    public fun openMHG (ID:String?) {

        when (ID) {
            "MHG" ->  intent = Intent(this, com.example.mhqdb.MHG::class.java)
            "MH3G" -> intent = Intent(this, com.example.mhqdb.MH3G::class.java)
            "MH3RD" -> intent = Intent(this, com.example.mhqdb.MH3RD::class.java)
            "MH4U" -> intent = Intent(this, com.example.mhqdb.MH4U::class.java)
            "MHFU" -> intent = Intent(this, com.example.mhqdb.MHFU::class.java)
            "MHXX" -> intent = Intent(this, com.example.mhqdb.MHXX::class.java)
            "MHW" -> intent = Intent(this, com.example.mhqdb.MHG::class.java)
            else -> intent = Intent(this, com.example.mhqdb.MainActivity::class.java)
        }

        // To pass any data to next activity
        startActivity(intent)
    }
}
