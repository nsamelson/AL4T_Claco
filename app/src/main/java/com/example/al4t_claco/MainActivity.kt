package com.example.al4t_claco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.resources)

        getSupportActionBar()?.setTitle("Resources")

        var teachers = listOf("Prof")
        /*var activity = Activity("francais","fr",teachers)
        var courses = List<Course>((Course("test","test",3,"wpi",))
        var nico = Student("Nicolas","nicolas","nicolas",)*/

        /*val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.user = User("Test", "User")*/





        //--------------TEST ZONE
        /*
        println(" \n \n_______________\n TEST ZONE \n________________\n")
        Log.d("TAG", "TEST 1")
        var Nico = Teacher("Nicolas","17288@ecam.be","coucou")
        val isChanged = Nico.ModifyPassword("coucou","Hello")
        val findCourse = Nico.GetCourse("wou")
        println(findCourse)
        println(" \n \n_______________\n TEST ZONE \n________________\n")
        */

    }
}