package com.example.al4t_claco.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.R
import com.example.al4t_claco.databinding.ActivityCourseInformationBinding
import com.example.al4t_claco.databinding.ActivityResourceBinding
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.File
import com.example.al4t_claco.view.DataCourse
import com.google.android.material.navigation.NavigationView

class CourseInformation : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_information)

        val course = intent.getSerializableExtra("course") as Course
        //test

        val binding: ActivityCourseInformationBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_course_information)
        binding.course = DataCourse(course)
        supportActionBar?.title = "Course"

        val drawerLayout: DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView: NavigationView = findViewById<View>(R.id.navView) as NavigationView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> Toast.makeText(applicationContext, "Clicked Calendar", Toast.LENGTH_SHORT).show()
                R.id.nav_forum -> Toast.makeText(applicationContext, "Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> Toast.makeText(applicationContext, "Change password", Toast.LENGTH_SHORT).show()
                R.id.logout -> startActivity(Intent(this, LoginActivity::class.java))
            }
            true
        }

        fun openResourceActivity(activity: Activity, courseName: String): Intent {
            val intent = Intent(this, ResourceActivity::class.java).apply {
                putExtra("course", "inf4")
                putExtra("activity", activity)
            }
            startActivity(intent)
            return intent
        }

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
                    openResourceActivity(activity, course.name)

                })
                gridlayout.addView(newButton)
            }
        }
        showCourseInformation(course.activities)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        when (item.itemId)
        {
            R.id.modify_description -> {


                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.course_modify_menu, menu)
        return true
    }
}