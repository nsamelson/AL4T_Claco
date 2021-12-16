package com.example.al4t_claco.controller

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.view.DashboardData

/*
 * This class is used to render the custom gridlayout with the recycler view of the workspace.
*/
class CustomAdapter(ctx: Context?, var CourseNames: List<DashboardData>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    var inflater: LayoutInflater

    //Create and display the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.custom_grid_layout, parent, false)
        return ViewHolder(view)
    }

    //Add the Courses from the list to the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position < CourseNames.size) {
            holder.CourseName.setText(CourseNames[position].course.name)
            holder.gridIcon.setImageResource(CourseNames[position].logo)
        }
    }

    //Get the number of courses of the user
    override fun getItemCount(): Int {
        return CourseNames.size
    }

    //Set action when element from gridview pressed
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var CourseName: TextView
        var gridIcon: ImageView

        init {
            CourseName = itemView.findViewById(R.id.courseName)
            gridIcon = itemView.findViewById(R.id.courseImage)
            itemView.setOnClickListener { v ->
                val intent = Intent(v.context, CourseInformation::class.java).apply {
                    putExtra("course", CourseNames[adapterPosition].course)
                }
                v.context.startActivity(intent)
            }
        }
    }

    init {
        inflater = LayoutInflater.from(ctx)
    }
}