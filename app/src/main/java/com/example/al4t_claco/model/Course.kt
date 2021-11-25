package com.example.al4t_claco.model

class Course (name: String, code: String, credits: Int, courseLeader: String, activities: List<Activity>) {
    val name = name
    val code = code
    val credits = credits
    val courseLeader = courseLeader //TODO: change maybe to Teacher class
    var activities = activities

}