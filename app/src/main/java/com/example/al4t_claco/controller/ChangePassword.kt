package com.example.al4t_claco.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.al4t_claco.R

/* This is the class that shows the page Change Password, where the user is can change his password.
*/
class ChangePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val newPassword = findViewById<EditText>(R.id.edt_newPassword)
        val confirmNewPassword = findViewById<EditText>(R.id.edt_ConfirmPassword)
        val btnConfirm = findViewById<Button>(R.id.btn_Confirm)

        // check if the user has put the same password in the two Edit Text
        btnConfirm.setOnClickListener{
            if (newPassword.text.toString() != confirmNewPassword.text.toString()){
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
    }
}