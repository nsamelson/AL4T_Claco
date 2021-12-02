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

class CustomAdapter(ctx: Context?, var CourseNames: List<String>, var CourseImages: List<Int>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.custom_grid_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder : ViewHolder, position: Int) {
        if(position < CourseNames.size) {              //defining int position = 4, that makes the bug. Need to change that, managing to keep index in bounds
            holder.CourseName.setText(CourseNames[position])
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
                    val intent = Intent(v.context, ResourceActivity::class.java)
                    v.context.startActivity(intent)
                    Toast.makeText(
                        v.context,
                        "${CourseNames[adapterPosition]}",
                        Toast.LENGTH_SHORT
                    ).show()

            }


        }
    }
    init {
        inflater = LayoutInflater.from(ctx)
    }
}