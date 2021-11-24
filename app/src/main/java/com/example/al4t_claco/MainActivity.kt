package com.example.al4t_claco

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.databinding.ResourcesBinding
import com.example.al4t_claco.view.DataActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.resources)

        //TODO: method when an activity is selected

        val teachers = listOf("Lorge","Lurkin","Dekimpe")
        val activity = Activity("Informatique","4inf",teachers)
        activity.resources = listOf(File("a","pdf"),File("b","pdf"))


        val binding: ResourcesBinding = DataBindingUtil.setContentView(this, R.layout.resources)
        binding.resource = DataActivity(activity, "info")
        supportActionBar?.title = "Resources"


        fun addButtons() {
            val gridlayout = findViewById<GridLayout>(R.id.gridResources)
            //val buttonParams = findViewById<Button>(R.id.button1)
            for(i in 1..5){
                val newButton = Button(this)
                newButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pdf_medium, 0, 0);

                /*newButton.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)*/

                newButton.setOnClickListener(View.OnClickListener {
                    newButton.text = "clicked"
                })
                newButton.text = "Button ${i}"
                newButton.id = i
                gridlayout.addView(newButton)
            }

        }
        addButtons()







    }

}