package com.example.mindon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mindon.R
import com.example.mindon.fragment.Pergunta1Fragment

class NivelamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivelamento)

        //Coloca  o primeiro fragment Pets no FrameLayout
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.viewPage, Pergunta1Fragment())
        transaction.commit()
    }
}