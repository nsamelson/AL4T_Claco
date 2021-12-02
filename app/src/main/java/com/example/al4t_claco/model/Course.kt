package com.example.al4t_claco.model

import java.io.Serializable

class Course (name: String, code: String, year : Int, credits: Int, courseLeader: String, activities: List<Activity>) :Serializable {
    val name = name
    val code = code
    val year = year
    val credits = credits
    val courseLeader = courseLeader //TODO: change maybe to Teacher class
    var activities = activities

}