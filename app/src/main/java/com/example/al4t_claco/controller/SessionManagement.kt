package com.example.al4t_claco.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.Student
import com.google.gson.Gson


class SessionManagement {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con : Context
    var PRIVATE_MODE : Int = 0


    constructor(con: Context){
        this.con = con
        pref = con.getSharedPreferences(companion.PREF_NAME,PRIVATE_MODE)
        editor = pref.edit()
    }

     object companion{
        val PREF_NAME : String = "Demo"
        val IS_LOGIN : String = "IsLoggedIn"
        val KEY_EMAIL : String = "email"
        val KEY_PASSWORD : String = "password"
        val KEY_COURSES : String = "courses"
    }

    fun createLoginSession(email: String, password : String, course: String){
        editor.putBoolean(companion.IS_LOGIN,true)
        editor.putString(companion.KEY_EMAIL,email)
        editor.putString(companion.KEY_PASSWORD,password)
        editor.putString(companion.KEY_COURSES,course)
        editor.commit()
    }

    fun checkLogin(){
        if(!this.isLoggedIn()){
            var i: Intent = Intent(con,LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
    }

    fun getUserDetails() : HashMap<String,String>{
        var user : Map<String,String> = HashMap<String,String>()
        (user as HashMap).put(companion.KEY_EMAIL, pref.getString(companion.KEY_EMAIL,"").toString())
        (user as HashMap).put(companion.KEY_PASSWORD, pref.getString(companion.KEY_PASSWORD,"").toString())
        (user as HashMap).put(companion.KEY_COURSES,pref.getString(companion.KEY_COURSES,"").toString())
        return user
    }

    fun LogoutUser(){
        editor.clear()
        editor.commit()

        var i: Intent = Intent(con,LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        con.startActivity(i)
    }

    fun isLoggedIn() : Boolean{
        return pref.getBoolean(companion.IS_LOGIN,false)
    }


}