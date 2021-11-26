package com.example.al4t_claco

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.al4t_claco.controller.CourseInformation
import com.example.al4t_claco.controller.ResourceActivity
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun openCourseInformation(view: View):Intent{
        val activity = Activity("Info","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity2 = Activity("Bidule","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity3 = Activity("Truc","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity4 = Activity("Nom très très long parce que les cours sont chiants","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity5 = Activity("Informatique","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity6 = Activity("Informatique","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activityList = listOf<Activity>(activity,activity2,activity3,activity4,activity5,activity6,activity4,activity4,activity4)
        val course = Course("GPU_Computing","35foezkg",2021,6,"Lurkin", activityList)

        val intent = Intent(this, CourseInformation::class.java).apply {
            putExtra("course",course)
        }
        startActivity(intent)
        return intent
    }


    fun openResourceActivity(view: View):Intent{
        val activity = Activity("Informatique","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        activity.resources = listOf(File("a","pdf"), File("b","pdf"), File("c","PDF"), File("d","text"))

        val intent = Intent(this, ResourceActivity::class.java).apply {
            putExtra("course", "inf4")
            putExtra("activity",activity)
        }
        startActivity(intent)
        return intent
    }

}