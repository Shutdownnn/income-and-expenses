package com.example.incomeandexpenses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_showall.*

class Showall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showall)

        var row1money1 = Success.moneytt
        row1money.setText("$row1money1 บาท")

        var row2money1 = Success.moneytt2
        row2money.setText("$row2money1 บาท")

        var row1detai1 = Success.detailtt
        row1detail.setText("$row1detai1")

        var row2detai1 = Success.detailtt2
        row2detail.setText("$row2detai1")

        var ruball = Success.rubtotal
        calrub.setText("รวมรายรับ $ruball บาท")

        var jaiall = Success.jaitotal
        caljai.setText("รวมรายจ่าย $jaiall บาท")

        var totalall = Success.total
        caltotal.setText("ยอดคงเหลือ $totalall บาท")

        var numrubjaii = Success.numrubjai
        if (numrubjaii == 1)
            row1type.setText("รายรับ")
        else
            row1type.setText("รายจ่าย")

        var numrubjaii2 = Success.numrubjai2
        if (numrubjaii2 == 1)
            row2type.setText("รายรับ")
        else
            row2type.setText("รายจ่าย")

        buttonhome.setOnClickListener{
            val intent = Intent(this@Showall, Success::class.java)
            startActivity(intent)
            Success.rubtotal = 0
            Success.jaitotal = 0
            Success.total = 0
            Success.numrubjai = 0
            Success.numrubjai2 = 0
            Success.moneytt = 0
            Success.moneytt2 = 0
            Success.detailtt = ""
            Success.detailtt2 = ""
        }
    }
}