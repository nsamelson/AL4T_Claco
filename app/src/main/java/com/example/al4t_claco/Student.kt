package com.example.al4t_claco

class Student(name: String, login: String, password: String, workspace: List<Course>) :
    User(name, login, password,workspace) {

    val TotalCredits: Int = workspace.sumOf { it.Credits }

}