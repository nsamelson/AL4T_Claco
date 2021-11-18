 package com.example.al4t_claco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.View
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard  : AppCompatActivity() {
    var adapter: CustomAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        val courseList: RecyclerView = findViewById<View>(R.id.courseList) as RecyclerView;

        val courseNames = ArrayList<String>();
        val courseImages = ArrayList<Int>();

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


}