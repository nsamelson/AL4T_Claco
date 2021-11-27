package com.example.al4t_claco.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.al4t_claco.R
import com.example.al4t_claco.model.File
import com.github.barteksc.pdfviewer.PDFView

class PdfViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        val file = intent.getSerializableExtra("file") as File
        showPdfFromAssets(file.fullName)

        supportActionBar?.title = file.name

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

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