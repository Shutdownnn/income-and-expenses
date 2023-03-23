package com.example.incomeandexpenses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_success.*

class Success : AppCompatActivity() {
    companion object{
        var rubtotal = 0
        var jaitotal = 0
        var total = 0
        var numrubjai = 0
        var numrubjai2 = 0
        var moneytt = 0
        var moneytt2 = 0
        var detailtt = ""
        var detailtt2 = ""

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val items = listOf("รายรับ", "รายจ่าย")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        spinner.adapter = adapter
        spinner2.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(this@Success, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
                if ("$selectedItem"=="รายรับ"){
                    numrubjai = 1
                }
                else{
                    numrubjai = 0
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem2 = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(this@Success, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
                if ("$selectedItem2"=="รายรับ"){
                    numrubjai2 = 1
                }
                else{
                    numrubjai2 = 0
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        cal.setOnClickListener(){
            var moneyt = money.text.toString()
            var moneyt2 = money2.text.toString()
            var detail = detail.text.toString()
            var detail2 = detail2.text.toString()

            if (TextUtils.isEmpty(moneyt) || TextUtils.isEmpty(moneyt2) || TextUtils.isEmpty(detail) || TextUtils.isEmpty(detail2)){
                Toast.makeText(this, "กรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show()
            }
            else{
                if (numrubjai == 1){
                    rubtotal += moneyt.toInt()
                }
                else{
                    jaitotal += moneyt.toInt()
                }
                if (numrubjai2 == 1){
                    rubtotal += moneyt2.toInt()
                }
                else{
                    jaitotal += moneyt2.toInt()
                }

                moneytt = moneyt.toInt()
                moneytt2 = moneyt2.toInt()
                detailtt = detail
                detailtt2 = detail2
                total = rubtotal - jaitotal
                val intent = Intent(this@Success, Showall::class.java)
                startActivity(intent)
            }
        }
    }
}