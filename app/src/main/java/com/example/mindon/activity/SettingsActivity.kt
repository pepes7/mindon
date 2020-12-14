package com.example.mindon.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mindon.R
import com.example.mindon.model.music
import com.example.mindon.model.reproduzirMusica
import kotlinx.android.synthetic.main.activity_settings.*
import java.io.File

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        buttonCredits.setOnClickListener {
            startActivity(Intent(this, CreditosActivity::class.java))
        }

        buttonHelp.setOnClickListener {
            startActivity(Intent(this, ManualActivity::class.java))
        }

        if (music){
            checkMusica.isChecked = true
        }else{
            checkMusica.isChecked = false
        }

        checkMusica.setOnClickListener {
            if (checkMusica.isChecked){
                music = true
            }else{
                music = false
            }
            reproduzirMusica(baseContext)
        }

    }
}