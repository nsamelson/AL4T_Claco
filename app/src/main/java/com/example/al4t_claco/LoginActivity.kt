package com.example.al4t_claco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import com.example.al4t_claco.controller.Dashboard
import com.example.al4t_claco.model.*
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val teachers = listOf("Teacher1","Teacher2")
        val activity =  Activity("Architecture","4MIN-AL4T",teachers,"desc")
        val course =  Course ("Mobile","14", 5, 5,"Teacher1",listOf(activity))
        val teach = Teacher("Test", "tst", "123", listOf(course))
        val student = Student("Amine","1","123",listOf(course))

        val email = findViewById<EditText>(R.id.edt_email)
        val pass = findViewById<EditText>(R.id.edt_password)
        val button = findViewById<Button>(R.id.btnLogIn)
        val txtViewPassword = findViewById<TextView>(R.id.btnForgetPass)

        button.setOnClickListener {
            if ((email.text.toString() == student.login) and (pass.text.toString() == student.password)){
                val intent = Intent(this, Dashboard::class.java).apply {
                    putExtra("name","Amine")
                    putExtra("matricule","17")
                }
                startActivity(intent)
                }
            }
        txtViewPassword.setOnClickListener{
            val intent = Intent(this, ChangePassword::class.java).apply{
                putExtra("name","Amine")
                putExtra("matricule","17")
            }
            startActivity(intent)
        }
    }
}

