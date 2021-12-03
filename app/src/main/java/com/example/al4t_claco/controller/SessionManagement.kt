package com.example.al4t_claco.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.model.Student

class SessionManagement {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con : Context
    var PRIVATE_MODE : Int = 0

    constructor(con: Context){
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object{
        val PREF_NAME : String = "Demo"
        val IS_LOGIN : String = "IsLoggedIn"
        val KEY_NAME : String = "name"
        val KEY_EMAIL : String = "email"
    }

    fun createLoginSession(name:String,email: String){
        editor.putBoolean(IS_LOGIN,true)
        editor.putString(KEY_NAME,name)
        editor.putString(KEY_EMAIL,email)
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
        (user as HashMap).put(KEY_NAME, pref.getString(toString(KEY_NAME),"").toString())
        (user as HashMap).put(KEY_EMAIL, pref.getString(toString(KEY_EMAIL),"").toString())
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
        return pref.getBoolean(IS_LOGIN,false)
    }

    private fun toString(keyName: String): String {
        return KEY_NAME
    }

}