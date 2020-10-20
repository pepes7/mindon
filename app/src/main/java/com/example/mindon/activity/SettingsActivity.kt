package com.example.mindon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.mindon.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        buttonReturnToHome.setOnClickListener {
            openHomeActivity()
        }
    }

    private fun openHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}