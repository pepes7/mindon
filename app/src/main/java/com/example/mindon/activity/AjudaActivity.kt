package com.example.mindon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mindon.R
import kotlinx.android.synthetic.main.activity_ajuda.*


class AjudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajuda)
        val toolbar: Toolbar = findViewById(R.id.toolbar_ajuda)
        setSupportActionBar(toolbar)

        supportActionBar!!.title = "Fale Conosco"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn_enviar_problema.setOnClickListener {
            enviar()
        }
    }

    fun enviar(){
        if(edit_problema.text.toString().isEmpty()){
            Toast.makeText(this,"Nenhum Texto para enviar",Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf("projeto.mindon@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Problemas no App")
            intent.putExtra(Intent.EXTRA_TEXT, edit_problema.text.toString())

            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Escolha um App para enviar o e-mail"))
        }
    }
}