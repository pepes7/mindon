package com.example.mindon.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mindon.R

class ChooseLevel : AppCompatActivity() {
    private var buttonBeginner: Button? = null
    private var buttonIntermediary: Button? = null
    private var buttonAdvanced: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_choose_activity)
        buttonBeginner = findViewById<View>(R.id.beginnerLevel) as Button
        buttonIntermediary = findViewById<View>(R.id.intermediaryLevel) as Button
        buttonAdvanced = findViewById<View>(R.id.advancedLevel) as Button
        val setLevel = intArrayOf(0, 1, 2)
        buttonBeginner!!.setOnClickListener {
            val intent = Intent(this@ChooseLevel, HangmanGame::class.java)
            intent.putExtra("content", setLevel[0])
            startActivity(intent)
        }
        buttonIntermediary!!.setOnClickListener {
            val intent = Intent(this@ChooseLevel, HangmanGame::class.java)
            intent.putExtra("content", setLevel[1])
            startActivity(intent)
        }
        buttonAdvanced!!.setOnClickListener {
            val intent = Intent(this@ChooseLevel, HangmanGame::class.java)
            intent.putExtra("content", setLevel[2])
            startActivity(intent)
        }
    }
}