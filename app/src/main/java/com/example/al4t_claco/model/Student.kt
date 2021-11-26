package com.example.al4t_claco.model

class Student(name: String, login: String, password: String, workspace: List<Course>) :
    User(name, login, password,workspace) {

    val totalCredits: Int = workspace.sumOf { it.credits }

}