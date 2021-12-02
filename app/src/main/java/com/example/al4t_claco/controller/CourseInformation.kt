package com.example.al4t_claco.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.R
import com.example.al4t_claco.databinding.ActivityCourseInformationBinding
import com.example.al4t_claco.databinding.ActivityResourceBinding
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.File
import com.example.al4t_claco.view.DataCourse

class CourseInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_information)

        val course = intent.getSerializableExtra("course") as Course
        /*val code = intent.getStringExtra("coursecode")
        val year = intent.getStringExtra("year")
        val credits = intent.getStringExtra("credits")
        val teacher = intent.getStringExtra("teacher")*/

        val binding: ActivityCourseInformationBinding = DataBindingUtil.setContentView(this, R.layout.activity_course_information)
        binding.course = DataCourse(course)
        supportActionBar?.title = "Course"

        fun showCourseInformation(activities: List<Activity>) {
            val gridlayout = findViewById<GridLayout>(R.id.gridResources)


            for (activity in activities) {
                val newButton = Button(this, null, android.R.attr.borderlessButtonStyle)
                val buttonImage = R.drawable.folder_icon

                newButton.setCompoundDrawablesWithIntrinsicBounds(0, buttonImage, 0, 0)
                newButton.text = activity.name
                newButton.isAllCaps = false
                newButton.maxWidth = R.drawable.folder_icon.toDrawable().intrinsicWidth

                newButton.setOnClickListener(View.OnClickListener {
                    //TODO("Link other page")

                })
                gridlayout.addView(newButton)
            }
        }
        showCourseInformation(course.activities)

    }
}