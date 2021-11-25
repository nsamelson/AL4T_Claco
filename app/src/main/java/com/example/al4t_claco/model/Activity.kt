package com.example.al4t_claco.model

import java.io.Serializable

class Activity (name: String, code: String, teachers: List<String> ): Serializable{
    val name = name
    val code = code
    val teachers = teachers
    lateinit var resources: List<File>
    //var Events: List<Event> = TODO()

    //TODO: maybe put only one teacher per activity
    //TODO: add Resources and Events as parameter
    //TODO: change maybe later the teacher with Teacher class



}