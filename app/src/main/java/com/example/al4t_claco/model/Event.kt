package com.example.al4t_claco.model

import java.sql.Date
import java.sql.Time

class Event (name: String, location: Classroom, dateTime: Date, description: String){
    val name = name
    val location = location //TODO: do we put this as aggregation or composition?
    val dateTime = dateTime //TODO: find a way to have datetime module "dd-mm-yyyy-HH-MM"
    val descrition = description
}