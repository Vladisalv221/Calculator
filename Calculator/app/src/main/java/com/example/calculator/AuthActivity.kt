package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.InternalTextApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder


class AuthActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.textreg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivityStart::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Есть пустые поля", Toast.LENGTH_LONG).show()
            else {
                    val db = DbHelp(this, null)
                    val isAuth = db.getUser(login, pass)

                    if(isAuth) {
                        Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()

                        val buttonauth1 = findViewById<Button>(R.id.button_auth)
                        buttonauth1.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        userLogin.text.clear()
                        userPass.text.clear()
                    }
                    else
                        Toast.makeText(this, "Пользователь $login НЕ авторизован", Toast.LENGTH_LONG).show()

                }
            }

        }
    }