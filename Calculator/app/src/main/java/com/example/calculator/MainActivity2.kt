package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        supportActionBar!!.title = "Обычный калькулятор"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<TextView>(R.id.btn_0).setOnClickListener { setText("0") }
        findViewById<TextView>(R.id.btn_1).setOnClickListener { setText("1") }
        findViewById<TextView>(R.id.btn_2).setOnClickListener { setText("2") }
        findViewById<TextView>(R.id.btn_3).setOnClickListener { setText("3") }
        findViewById<TextView>(R.id.btn_4).setOnClickListener { setText("4") }
        findViewById<TextView>(R.id.btn_5).setOnClickListener { setText("5") }
        findViewById<TextView>(R.id.btn_6).setOnClickListener { setText("6") }
        findViewById<TextView>(R.id.btn_7).setOnClickListener { setText("7") }
        findViewById<TextView>(R.id.btn_8).setOnClickListener { setText("8") }
        findViewById<TextView>(R.id.btn_9).setOnClickListener { setText("9") }
        findViewById<TextView>(R.id.btn_min).setOnClickListener { setText("-") }
        findViewById<TextView>(R.id.btn_slag).setOnClickListener { setText("+") }
        findViewById<TextView>(R.id.btn_mull).setOnClickListener { setText("*") }
        findViewById<TextView>(R.id.btn_delchet).setOnClickListener { setText("/") }
        findViewById<TextView>(R.id.btn_skob).setOnClickListener { setText("(") }
        findViewById<TextView>(R.id.btn_skob1).setOnClickListener { setText(")") }
        findViewById<TextView>(R.id.btn_zap).setOnClickListener { setText(".") }

        findViewById<TextView>(R.id.btn_C).setOnClickListener {
            findViewById<TextView>(R.id.operation).text = ""
            findViewById<TextView>(R.id.res).text = ""
        }
        findViewById<TextView>(R.id.btn_del).setOnClickListener {
            val str = findViewById<TextView>(R.id.operation).text.toString()
            if (str.isNotEmpty())
                findViewById<TextView>(R.id.operation).text = str.substring(0, str.length - 1)
            findViewById<TextView>(R.id.res).text = ""
        }


        findViewById<TextView>(R.id.btn_ruv).setOnClickListener {
            try {
                val obj =
                    ExpressionBuilder(findViewById<TextView>(R.id.operation).text.toString()).build()
                val res = obj.evaluate()
                val dlinres = res.toLong()
                if (res == dlinres.toDouble())
                    findViewById<TextView>(R.id.res).text = dlinres.toString()
                else
                    findViewById<TextView>(R.id.res).text = res.toString()
            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
                Toast.makeText(applicationContext, "Ошибка вычисления: ${e.message}",
                    Toast.LENGTH_SHORT).show()
                null
            }
        }
    }

        fun setText(str: String) {
            if (findViewById<TextView>(R.id.res).text != "")
                findViewById<TextView>(R.id.operation).text = findViewById<TextView>(R.id.res).text
            findViewById<TextView>(R.id.res).text = ""
            findViewById<TextView>(R.id.operation).append(str)
        }
    override fun onBackPressed() {
        super.onBackPressed()
        try {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } catch (e: Exception) {
        }
    }
}
