package com.example.al4t_claco.controller

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.File
import com.example.al4t_claco.R
import com.example.al4t_claco.databinding.ActivityResourceBinding
import com.example.al4t_claco.model.sessionManager
import com.example.al4t_claco.view.DataActivity
import java.io.FileOutputStream
import java.io.IOException

import com.google.android.material.navigation.NavigationView

class ResourceActivity() : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var session: sessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val course = intent.getStringExtra("course")
        val activity = intent.getSerializableExtra("activity") as Activity

        val binding: ActivityResourceBinding = DataBindingUtil.setContentView(this, R.layout.activity_resource)
        binding.activity = DataActivity(activity,course.toString())
        supportActionBar?.title = "Resources"
        //Add the side menu to the page
        val drawerLayout : DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView : NavigationView = findViewById<View>(R.id.navView) as NavigationView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> Toast.makeText(applicationContext,"Clicked Calendar", Toast.LENGTH_SHORT).show()
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> Toast.makeText(applicationContext,"Change password",Toast.LENGTH_SHORT).show()
                R.id.logout -> session.logoutdUser()
            }
            true
        }
        fun downloadFile(file: File){
            //TODO : find another method to get the download directory
            val outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val outFile = java.io.File(outDir, file.fullName)

            val myInput = this.assets.open(file.fullName)

            try{
                val myOutput = FileOutputStream(outFile.path)
                try {
                    myInput.copyTo(myOutput)
                }
                catch (e: IOException){
                    Toast.makeText(applicationContext,e.toString(),Toast.LENGTH_SHORT).show()
                }
                finally {
                    Toast.makeText(applicationContext,"downloaded File to ${outFile}",Toast.LENGTH_SHORT).show()
                    myInput.close()
                    myOutput.close()
                }
            } catch (e: IOException){
                Toast.makeText(applicationContext,e.toString(),Toast.LENGTH_LONG).show()
            }
        }

        //open pdf
        fun openFile(file: File) {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("file", file)
            startActivity(intent)
        }

        //popup listener
        fun onPopupListener(dialog: Int, whichFile: File){
            //Toast.makeText(applicationContext,dialog, Toast.LENGTH_SHORT).show()

            when(dialog){
                R.string.download -> downloadFile(whichFile)
                R.string.open -> openFile(whichFile)
            }
        }

        //POPUP
        fun createAndShowDialog(file: File) {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Do you want to download the following file?")
            dialogBuilder.setMessage("Name : ${file.name}\nType : ${file.type}")
            dialogBuilder.setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    onPopupListener(android.R.string.cancel,file)
                })
            dialogBuilder.setPositiveButton(R.string.download,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    onPopupListener(R.string.download,file)
                })
            dialogBuilder.setNeutralButton(R.string.open,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    onPopupListener(R.string.open,file)
                })

            val b = dialogBuilder.create()
            b.show()
        }

        fun showResources(files: List<File>) {
            val gridlayout = findViewById<GridLayout>(R.id.gridResources)


            //CREATE BUTTONS
            for (file in files) {
                val newButton = Button(this, null, android.R.attr.borderlessButtonStyle)
                val buttonImage: Int

                when (file.type) {
                    "pdf" -> buttonImage = R.drawable.pdf_medium
                    else -> buttonImage = R.drawable.not_found_medium
                }
                newButton.setCompoundDrawablesWithIntrinsicBounds(0, buttonImage, 0, 0)
                newButton.text = file.name
                newButton.isAllCaps = false
                newButton.maxWidth = R.drawable.pdf_medium.toDrawable().intrinsicWidth

                //On short click : popup to download file
                newButton.setOnClickListener(View.OnClickListener {
                    openFile(file)
                })
                //On long click :
                newButton.setOnLongClickListener(View.OnLongClickListener {
                    createAndShowDialog(file)
                    true
                })

                gridlayout.addView(newButton)
            }
        }
        showResources(activity.resources)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}