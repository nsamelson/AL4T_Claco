package com.example.al4t_claco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.al4t_claco.controller.Dashboard
import com.example.al4t_claco.controller.SessionManagement
import com.example.al4t_claco.model.*


class LoginActivity : AppCompatActivity() {
    lateinit var session : SessionManagement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val teachers = listOf("Teacher1","Teacher2")
        val activity =  Activity("Architecture","4MIN-AL4T",teachers)
        val course =  Course ("Mobile","14", 5, 5,"Teacher1",listOf(activity))
        val course2 = Course ("Mobile","14", 5, 5,"Teacher1",listOf(activity))
        val teach = Teacher("Test", "tst", "123", listOf(course))
        val student = Student("Amine","1","123",listOf(course))

        val courses = listOf(course,course2)



        val email = findViewById<EditText>(R.id.edt_email)
        val pass = findViewById<EditText>(R.id.edt_password)
        val button = findViewById<Button>(R.id.btnLogIn)
        val txtViewPassword = findViewById<TextView>(R.id.btnForgetPass)

        session = SessionManagement(applicationContext)

        if(session.isLoggedIn()){
            var i : Intent = Intent(applicationContext,Dashboard::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }


        button.setOnClickListener {
            if ((email.text.toString() == student.login) and (pass.text.toString() == student.password)){
                session.createLoginSession(email.text.toString(), pass.text.toString(),courses.toString())
                val intent = Intent(applicationContext, Dashboard::class.java).apply {
                    //putExtra("name","Amine")
                    //putExtra("matricule","17")

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

