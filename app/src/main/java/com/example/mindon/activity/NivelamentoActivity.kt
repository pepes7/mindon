package com.example.mindon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mindon.R
import com.example.mindon.fragment.Pergunta1Fragment
import com.example.mindon.model.Pergunta
import com.example.mindon.model.perguntas

class NivelamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivelamento)

        perguntas.clear()
        for (i in 1 ..13){
            var a = Pergunta()
            a.acerto = ""
            a.numero = i.toString()

            perguntas.add(a)
        }
        //Coloca  o primeiro fragment Pets no FrameLayout
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.viewPage, Pergunta1Fragment())
        transaction.commit()
    }
}