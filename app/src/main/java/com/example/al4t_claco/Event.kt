package com.example.al4t_claco

import java.sql.Time

class Event (name: String, location: Classroom, dateTime: Time, description: String){
    val Name = name
    val Location = location //TODO: do we put this as aggregation or composition?
    val DateTime = dateTime //TODO: find a way to have datetime module "dd-mm-yyyy-HH-MM"
    val Descrition = description
}