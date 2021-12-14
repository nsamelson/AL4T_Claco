package com.example.al4t_claco.controller

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.ChangePassword
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.File
import com.example.al4t_claco.model.sessionManager
import com.example.al4t_claco.view.DashboardData
import com.example.al4t_claco.view.DataCourse
import com.google.android.material.navigation.NavigationView
import com.lokiy.kit.utils.get

 class Dashboard  : AppCompatActivity() {
    var adapter: CustomAdapter? =null
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var session: sessionManager
    lateinit var utilisateur : HashMap<String,String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        session = sessionManager(applicationContext)
        session.checkLogin()

        supportActionBar?.title = "Workspace"

        //SIDE MENU

        val drawerLayout : DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView : NavigationView = findViewById<View>(R.id.navView) as NavigationView
        val headerView = navView.getHeaderView(0)
        val user = headerView.findViewById<TextView>(R.id.user)

        utilisateur = session.getUserDetails()
        var name :String = utilisateur.get(sessionManager.companion.KEY_NAME)!!
        var cou : String = utilisateur.get(sessionManager.companion.KEY_COURSE)!!

        user.text = name

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> startActivity(Intent(applicationContext, CalendarActivity::class.java))
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> startActivity(Intent(applicationContext, ChangePassword::class.java))
                R.id.logout -> session.logoutdUser()
            }
            false
        }

        //CREATE ACTIVITIES AND COURSES


        //TODO : Get this from the API instead of creating them here
        val activity = Activity("Activity 1","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 1")
        val activity2 = Activity("Activity 2","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 2")
        val activity3 = Activity("Activity 3","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 3")
        val activity4 = Activity("Parallel programming, OpenGL","4inf", listOf("Lurkin"),"Notions present in this course : memory management in C++, 3D render with OpenGL ...")
        val activity5 = Activity("Algorithmic","4inf", listOf("Hasselmann"),"This course is about algorithms, it will cover the basics on algorithmic complexity, data structures and their applications. The course will feature exercices along the way and a small presentation and the end of the session")
        val activity6 = Activity("Image processing lab","4inf", listOf("Lurkin","Madmad"),"Notions present in this course : filtering, morphological operations, projective geometry ...")

        activity.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity2.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity3.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity4.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity5.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity6.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))

        val activityList = listOf<Activity>(activity,activity2,activity3)
        val activityList2 = listOf<Activity>(activity4,activity5,activity6)

        val course = Course("GPU Computing","4inf",4,5,"Lur","This course deals with GPU Computing", activityList2)
        val course1 = Course("Database","4DB",4,5,"Lor","This course deals with database", activityList)
        val course2 = Course("APPS","4app",4,5,"LRK","This course deals with APPS", activityList)
        val course3 = Course("Electronics","4el",4,5,"MCH","This course deals with electronics", activityList)
        val course4 = Course("Electricity","4inf",4,5,"CMS","This course deals with electricity", activityList)

        val course_logo = DashboardData(course,R.drawable.ic_launcher_foreground)
        val course_logo1 = DashboardData(course1,R.drawable.ic_launcher_foreground)
        val course_logo2 = DashboardData(course2,R.drawable.ic_launcher_foreground)
        val course_logo3 = DashboardData(course3,R.drawable.ic_launcher_foreground)
        val course_logo4 = DashboardData(course4,R.drawable.electric_circuit)

        val courseNames = listOf<DashboardData>(course_logo,course_logo1,course_logo2,course_logo3,course_logo4)

        //CALL ADAPTER TO DISPLAY COURSES

        val courseList: RecyclerView = findViewById<View>(R.id.courseList) as RecyclerView
        adapter = CustomAdapter(this,courseNames)
        courseList.adapter = adapter
        courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

    }

    //Open the side menu when button pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}