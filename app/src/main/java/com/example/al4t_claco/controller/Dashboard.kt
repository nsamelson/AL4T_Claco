 package com.example.al4t_claco.controller

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.google.android.material.navigation.NavigationView

 class Dashboard  : AppCompatActivity() {
    var adapter: CustomAdapter? =null
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val courseList: RecyclerView = findViewById<View>(R.id.courseList) as RecyclerView
        val drawerLayout : DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView : NavigationView = findViewById<View>(R.id.navView) as NavigationView


        val courseImages = ArrayList<Int>();


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> Toast.makeText(applicationContext,"Clicked Calendar", Toast.LENGTH_SHORT).show()
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> Toast.makeText(applicationContext,"Change password",Toast.LENGTH_SHORT).show()
                R.id.logout -> startActivity(Intent(this, LoginActivity::class.java))
            }
            false
        }
        val activity = Activity("Info","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity2 = Activity("Bidule","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activityList = listOf<Activity>(activity,activity2)

        val course = Course("Info","4inf",4,5,"Lur", activityList)
        val course1 = Course("Database","4DB",4,5,"Lor", activityList)
        val course2 = Course("APPS","4app",4,5,"LRK", activityList)
        val course3 = Course("Electronics","4el",4,5,"MCH", activityList)
        val course4 = Course("Electicity","4inf",4,5,"CMS", activityList)

        val courseNames = listOf<Course>(course,course1,course2,course3,course4);


        courseImages.add(R.drawable.ic_launcher_foreground);
        courseImages.add(R.drawable.ic_launcher_foreground);
        courseImages.add(R.drawable.ic_launcher_foreground);
        courseImages.add(R.drawable.ic_launcher_foreground);
        courseImages.add(R.drawable.ic_launcher_foreground);


        adapter = CustomAdapter(this,courseNames,courseImages)
        courseList.adapter = adapter
        courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        //courseList.adapter = Adapter(this,courseNames,courseImages);
        //courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        //val adapter = Adapter(this, CourseNames, CourseImages);
        //val gridLayoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        //courseList.layoutManager = gridLayoutManager;

    }

     fun OnCreateOptionsMenu(menu: ContextMenu?) : Boolean {
        menuInflater.inflate(R.menu.side_menu,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}