package com.example.al4t_claco.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.al4t_claco.R
import com.example.al4t_claco.model.File
import com.github.barteksc.pdfviewer.PDFView
/*
* This is the activity used to display a pdf
*/
class PdfViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        //get the file object from ResourceActivity
        val file = intent.getSerializableExtra("file") as File

        //TODO: Files are currently only in the assets, use an API to get from a database or implement to get from the web
        showPdfFromAssets(file.fullName)

        supportActionBar?.title = file.name

    }

    // To get back to the activity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //get the file frop assets and displays it
    private fun showPdfFromAssets(pdfName: String){
        val pdfView = findViewById<PDFView>(R.id.pdfView)
        pdfView.fromAsset(pdfName)
            .password(null) // if password protected, then write password
            .defaultPage(0) // set the default page to open
            .onPageError { page, _ ->
                Toast.makeText(
                    this@PdfViewActivity,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .onError{
                Toast.makeText(
                    this,
                    "Error loading the pdf : $pdfName", Toast.LENGTH_LONG
                )
            }
            .load()
    }
}