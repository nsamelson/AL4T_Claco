package com.example.al4t_claco

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.databinding.ResourcesBinding
import com.example.al4t_claco.view.DataActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //TODO: method when an activity is selected

        val teachers = listOf("Lorge","Lurkin","Dekimpe")
        val activity = Activity("Informatique","4inf",teachers)
        activity.resources = listOf(File("a","pdf"),File("b","pdf"), File("c","PDF"),File("d","text"))


        val binding: ResourcesBinding = DataBindingUtil.setContentView(this, R.layout.resources)
        binding.activity = DataActivity(activity, "info")
        supportActionBar?.title = "Resources"


        fun showResources(files: List<File>) {
            val gridlayout = findViewById<GridLayout>(R.id.gridResources)
            fun createAndShowDialog(file: File){

                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Do you want to open the following file?")
                dialogBuilder.setMessage("Name : ${file.name}\nType : ${file.type}")
                dialogBuilder.setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, whichButton -> })
                dialogBuilder.setNeutralButton("Download",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        Toast.makeText(applicationContext,
                            "Downloading", Toast.LENGTH_SHORT).show()
                    })
                dialogBuilder.setPositiveButton("Open",
                    DialogInterface.OnClickListener { dialog, whichButton -> })

                val b = dialogBuilder.create()
                b.show()

            }
            for(file in files){
                val newButton = Button(this,null, android.R.attr.borderlessButtonStyle)

                val buttonImage : Int
                when (file.type){
                    "pdf" -> buttonImage = R.drawable.pdf_medium
                    else  -> buttonImage = R.drawable.not_found_medium
                }
                newButton.setCompoundDrawablesWithIntrinsicBounds(0, buttonImage, 0, 0)
                newButton.text = file.name

                //On short click : show file
                newButton.setOnClickListener(View.OnClickListener {
                    //TODO("Show file")
                    newButton.text = "show file"
                })
                //On long click : popup to download file
                newButton.setOnLongClickListener(View.OnLongClickListener {
                    newButton.text = file.name
                    createAndShowDialog(file)
                    true
                })

                gridlayout.addView(newButton)
            }


        }
        showResources(activity.resources)







    }

}