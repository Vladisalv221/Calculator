package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
            val button1 = findViewById<Button>(R.id.button3)
            button1.setOnClickListener {
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
