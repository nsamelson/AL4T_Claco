package com.example.al4t_claco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.al4t_claco.controller.Dashboard
import com.example.al4t_claco.model.*
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {

    lateinit var session: sessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        session = sessionManager(applicationContext)
        if(session.isLoggedIn()){
            var intent = Intent (applicationContext,Dashboard::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        val teachers = listOf("Teacher1","Teacher2")
        val activity =  Activity("Architecture","4MIN-AL4T",teachers)
        var course =  Course ("Electronics","14", 5, 5,"Teacher1",listOf(activity))
        var course2 =  Course ("Computer Science","14", 5, 5,"Teacher1",listOf(activity))
        val teach = Teacher("Test", "tst", "123", listOf(course))
        val student = Student("Amine","1","123",listOf(course, course2))

        val listVal: List<String> = student.workspace.map { it.name }
        var cou: String = listVal.joinToString(" - ")



        val email = findViewById<EditText>(R.id.edt_email)
        val pass = findViewById<EditText>(R.id.edt_password)
        val button = findViewById<Button>(R.id.btnLogIn)
        val txtViewPassword = findViewById<TextView>(R.id.btnForgetPass)

        txtViewPassword.text = Toast.makeText(applicationContext,cou, Toast.LENGTH_SHORT).show().toString()

        button.setOnClickListener {
            if ((email.text.toString() == student.login) and (pass.text.toString() == student.password)){
                session.createLoginSession(student.login,student.name, cou)
                val intent = Intent(this, Dashboard::class.java).apply {
                    putExtra("name","Amine")
                    putExtra("matricule","17")
                }
                startActivity(intent)
                }
            }
        /*txtViewPassword.setOnClickListener{
            val intent = Intent(this, ChangePassword::class.java).apply{
                putExtra("name","Amine")
                putExtra("matricule","17")
            }
            startActivity(intent)
        }*/
    }
}

