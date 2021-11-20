package com.example.al4t_claco

class Course (name: String, code: String, credits: Int, courseLeader: String, activities: List<Activity>) {
    val Name = name
    val Code = code
    val Credits = credits
    val CourseLeader = courseLeader //TODO: change maybe to Teacher class
    var Activities = activities

}