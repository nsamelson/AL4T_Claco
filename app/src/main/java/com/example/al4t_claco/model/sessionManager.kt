package com.example.al4t_claco.model

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.al4t_claco.LoginActivity

public class sessionManager {
    lateinit var pref : SharedPreferences
    lateinit var  editor: SharedPreferences.Editor
    lateinit var con : Context
    var PRIVATE_MODE: Int = 0

    constructor(con: Context) {
        this.pref = con.getSharedPreferences(companion.PREF_NAME, PRIVATE_MODE)
        this.editor = pref.edit()
        this.con = con
    }

    object companion {
        val PREF_NAME: String = "Claco"
        val IS_LOGIN: String = "isLoggedIn"
        val KEY_NAME: String = "name"
        val KEY_EMAIL: String = "email"
        val KEY_COURSE: String = "course"
   }
    fun createLoginSession(name: String, email: String, course: String){
        editor.putBoolean(companion.IS_LOGIN, true)
        editor.putString(companion.KEY_NAME, name)
        editor.putString(companion.KEY_EMAIL, email)
        editor.putString(companion.KEY_COURSE, course)
        editor.commit()
    }

    fun checkLogin(){
        if(!this.isLoggedIn()){
            var intent = Intent (con, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(intent)
        }
    }

    fun getUserDetails (): HashMap <String, String>{
        var user : Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(companion.KEY_NAME, pref.getString(companion.KEY_NAME ,null).toString())
        (user as HashMap).put(companion.KEY_EMAIL, pref.getString(companion.KEY_EMAIL ,null).toString())
        (user as HashMap).put(companion.KEY_COURSE, pref.getString(companion.KEY_COURSE ,null).toString())

        return user
    }

    fun logoutdUser() {
        editor.clear()
        editor.commit()

        var intent = Intent (con, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        con.startActivity(intent)

    }

    fun isLoggedIn():Boolean{

        return pref.getBoolean(companion.IS_LOGIN, false)
    }

}