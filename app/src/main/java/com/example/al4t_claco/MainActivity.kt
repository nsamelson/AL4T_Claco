package com.example.al4t_claco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.al4t_claco.controller.ResourceActivity
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.dashboard)
        
    }

    fun openResourceActivity(view: View): Intent {
        val activity = Activity("Informatique","4inf",listOf("Lorge","Lurkin","Dekimpe"))
        activity.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))

        val intent = Intent(this, ResourceActivity::class.java).apply {
            putExtra("course", "inf4")
            putExtra("activity",activity)
        }
        startActivity(intent)
        return intent
    }
}