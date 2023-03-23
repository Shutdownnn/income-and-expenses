package com.example.incomeandexpenses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnsignup: Button
    private lateinit var loginbtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbl: DBLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsignup = findViewById(R.id.ButtonRegister)
        loginbtn = findViewById(R.id.ButtonLogin)
        edituser = findViewById(R.id.LoginUsername)
        editpword = findViewById(R.id.LoginPassword)
        dbl = DBLogin(this)

        btnsignup.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        loginbtn.setOnClickListener{
            val username = edituser.text.toString()
            val password = editpword.text.toString()

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                Toast.makeText(this, "กรุณากรอก Username และ Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbl.checkuserpass(username, password)
                if(checkuser == true){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong Username & Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}