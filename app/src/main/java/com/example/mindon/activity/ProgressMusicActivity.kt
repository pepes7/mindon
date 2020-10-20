package com.example.mindon.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mindon.R
import kotlinx.android.synthetic.main.activity_progress_music.*

class ProgressMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_music)

        imageButton5.setOnClickListener {
            openActivityMemory()
        }
        imageButton6.setOnClickListener {
            openActivityLabrinth()
        }
        imageButton7.setOnClickListener {
            openActivityMusic()
        }
        imageButton8.setOnClickListener {
            openActivityUndef()
        }
    }

    private fun openActivityMemory(){
        val intent = Intent(this, ProgressMemoryActivity::class.java)
        startActivity(intent)
    }
    private fun openActivityLabrinth(){
        val intent = Intent(this, ProgressLabrinthActivity::class.java)
        startActivity(intent)
    }
    private fun openActivityMusic(){
        val intent = Intent(this, this::class.java)
        startActivity(intent)
    }
    private fun openActivityUndef(){
        val intent = Intent(this, ProgressUndefActivity::class.java)
        startActivity(intent)
    }
}