package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivityStart : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_start)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.textauthstr)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == "")
                Toast.makeText(this, "Есть пустые поля", Toast.LENGTH_LONG).show()
            else {

                val buttonreg = findViewById<Button>(R.id.button_reg)
                buttonreg.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                    val user = User(login, email, pass)
                val db = DbHelp(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    userEmail.text.clear()
                    userPass.text.clear()
                }
            }

        }
    }
}