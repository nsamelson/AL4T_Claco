 package com.example.al4t_claco.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.R
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

        val courseNames = ArrayList<String>();
        val courseImages = ArrayList<Int>();


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_calendar -> Toast.makeText(applicationContext,"Clicked Calendar", Toast.LENGTH_SHORT).show()
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
            }
            true
        }

        courseNames.add("Course 1");
        courseNames.add("Course 2");
        courseNames.add("Course 3");
        courseNames.add("Course 4");
        courseNames.add("Course 5");


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