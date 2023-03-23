package com.example.incomeandexpenses

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Register : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var signupbtn: Button
    private lateinit var signinbtn: Button
    private lateinit var db: DBLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        uname = findViewById(R.id.RegisUsername)
        firstname = findViewById(R.id.RegisFirstname)
        lastname = findViewById(R.id.RegisLastname)
        pword = findViewById(R.id.RegisPassword)
        signupbtn = findViewById(R.id.ButtonSignup)
        signinbtn = findViewById(R.id.ButtonSign)
        db = DBLogin(this)

        signupbtn.setOnClickListener {
            val unametext = uname.text.toString()
            val fistnametext = firstname.text.toString()
            val lastnametext = lastname.text.toString()
            val pwordtext = pword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(fistnametext) || TextUtils.isEmpty(lastnametext) || TextUtils.isEmpty(pwordtext)){
                Toast.makeText(this, "กรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        signinbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}