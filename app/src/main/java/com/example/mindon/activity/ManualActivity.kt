package com.example.mindon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mindon.R
import kotlinx.android.synthetic.main.activity_manual.*

class ManualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual)

        pdfView.fromAsset("manual.pdf").load()
    }
}