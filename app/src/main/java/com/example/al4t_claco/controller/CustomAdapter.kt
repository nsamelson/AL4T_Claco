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

class CustomAdapter(ctx: Context?, var CourseNames: List<Course>, var CourseImages: List<Int>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    var inflater: LayoutInflater

    val activity = Activity("Info","4inf", listOf("Lorge","Lurkin","Dekimpe"))
    val activity2 = Activity("Bidule","4inf", listOf("Lorge","Lurkin","Dekimpe"))
    val activity3 = Activity("Truc","4inf", listOf("Lorge","Lurkin","Dekimpe"))
    val activityList = listOf<Activity>(activity,activity2,activity3)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.custom_grid_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder : ViewHolder, position: Int) {
        if(position < CourseNames.size) {              //defining int position = 4, that makes the bug. Need to change that, managing to keep index in bounds
            holder.CourseName.setText(CourseNames[position].name)
            holder.gridIcon.setImageResource(CourseImages[position])
        }
    }

    override fun getItemCount(): Int {
        return CourseNames.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var CourseName: TextView
        var gridIcon: ImageView

        init {
            CourseName = itemView.findViewById(R.id.courseName)
            gridIcon = itemView.findViewById(R.id.courseImage)



                itemView.setOnClickListener { v ->
                    val intent = Intent(v.context, CourseInformation::class.java).apply {
                        putExtra("course",CourseNames[adapterPosition])
                    }
                    v.context.startActivity(intent)
                    Toast.makeText(
                        v.context,
                        "${CourseNames[adapterPosition].name}",
                        Toast.LENGTH_SHORT
                    ).show()

            }


        }
    }
    init {
        inflater = LayoutInflater.from(ctx)
    }
}