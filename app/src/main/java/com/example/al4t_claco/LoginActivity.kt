package com.example.al4t_claco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val teachers = listOf("Teacher1","Teacher2")
        val activ =  Activity("AL4T","4MIN-AL4T",teachers)
        val cours =  Course ("Mobile","14", 5, "Teacher1",listOf(activ))
        val teach = Teacher("Test", "tst", "123", listOf(cours))
        val stude = Student("Amine","17236","123",listOf(cours))

        val email = findViewById<TextInputEditText>(R.id.EmailId)
        val pass = findViewById<TextInputEditText>(R.id.PassId)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            if ((email.text.toString() == stude.Login) and (pass.text.toString() == stude.Password)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}