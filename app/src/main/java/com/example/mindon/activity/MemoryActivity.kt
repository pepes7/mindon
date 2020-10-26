package com.example.mindon.activity

import android.app.AlertDialog
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.mindon.R
import com.example.mindon.model.cadastrar
import kotlinx.android.synthetic.main.activity_memory.*

class MemoryActivity : AppCompatActivity() {
    private var cont = 0

    private var car = false
    private var house = false
    private var apple = false
    private var blue = false
    private var pink = false

    private var carro = false
    private var casa = false
    private var maca = false
    private var azul = false
    private var rosa = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        val toolbar: Toolbar = findViewById(R.id.toolbar_memory)
        setSupportActionBar(toolbar)

        supportActionBar!!.title = "Memory"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        opcoes()
    }
    fun opcoes(){
        if(cont != 2){
            btn_banana1.setOnClickListener {
                btn_banana1.setBackgroundResource(R.drawable.button_shape)
                btn_banana1.text = "Car"
                cont+=1
                car = true
                opcoes()
            }

            btn_banana2.setOnClickListener {
                btn_banana2.setBackgroundResource(R.drawable.button_shape)
                btn_banana2.text = "Casa"
                casa = true
                cont+=1
                opcoes()
            }

            btn_banana3.setOnClickListener {
                btn_banana3.setBackgroundResource(R.drawable.button_shape)
                btn_banana3.text = "House"
                cont+=1
                house = true
                opcoes()
            }

            btn_banana4.setOnClickListener {
                btn_banana4.setBackgroundResource(R.drawable.button_shape)
                btn_banana4.text = "Azul"
                cont+=1
                azul = true
                opcoes()
            }

            btn_banana5.setOnClickListener {
                btn_banana5.setBackgroundResource(R.drawable.button_shape)
                btn_banana5.text = "Rosa"
                cont+=1
                rosa = true
                opcoes()
            }

            btn_banana6.setOnClickListener {
                btn_banana6.setBackgroundResource(R.drawable.button_shape)
                btn_banana6.text = "Apple"
                cont+=1
                apple = true
                opcoes()
            }

            btn_banana7.setOnClickListener {
                btn_banana7.setBackgroundResource(R.drawable.button_shape)
                btn_banana7.text = "Blue"
                cont+=1
                blue = true
                opcoes()
            }

            btn_banana8.setOnClickListener {
                btn_banana8.setBackgroundResource(R.drawable.button_shape)
                btn_banana8.text = "Maça"
                cont+=1
                maca = true
                opcoes()
            }

            btn_banana9.setOnClickListener {
                btn_banana9.setBackgroundResource(R.drawable.button_shape)
                btn_banana9.text = "Carro"
                cont+=1
                carro =true
                opcoes()
            }
            btn_banana10.setOnClickListener {
                btn_banana10.setBackgroundResource(R.drawable.button_shape)
                btn_banana10.text = "Pink"
                cont+=1
                pink = true
                opcoes()
            }
        }else{
            cont = 0
            btn_banana1.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana2.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana3.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana4.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana5.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana6.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana7.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana8.setOnClickListener {
                todosBananas()
                opcoes()
            }

            btn_banana9.setOnClickListener {
                todosBananas()
                opcoes()
            }
            btn_banana10.setOnClickListener {
                todosBananas()
                opcoes()
            }
        }
        if(carro && azul && rosa && casa && maca && car && blue && pink && house && apple){
            parabens()
        }
    }
    fun todosBananas(){
        if (!(car && carro)){
            btn_banana1.setBackgroundResource(R.drawable.banana_1)
            btn_banana1.text = ""
            car = false
        }else{
            cont = 0
        }

        if (!(casa && house)){
            btn_banana2.setBackgroundResource(R.drawable.banana_1)
            btn_banana2.text = ""
            casa = false
        }else{
            cont = 0
        }

        if (!(casa && house)){
            btn_banana3.setBackgroundResource(R.drawable.banana_1)
            btn_banana3.text = ""
            casa = false
        }else{
            cont = 0
        }

        if (!(azul && blue)){
            btn_banana4.setBackgroundResource(R.drawable.banana_1)
            btn_banana4.text = ""
            azul = false
        }else{
            cont = 0
        }

        if (!(rosa && pink)){
            btn_banana5.setBackgroundResource(R.drawable.banana_1)
            btn_banana5.text = ""
            rosa = false
        }else{
            cont = 0
        }

        if (!(apple && maca)){
            btn_banana6.setBackgroundResource(R.drawable.banana_1)
            btn_banana6.text = ""
            apple = false
        }else{
            cont = 0
        }


        if (!(azul && blue)){
            btn_banana7.setBackgroundResource(R.drawable.banana_1)
            btn_banana7.text = ""
            blue = false
        }else{
            cont = 0
        }


        if (!(maca && apple)){
            btn_banana8.setBackgroundResource(R.drawable.banana_1)
            btn_banana8.text = ""
            maca = false
        }else{
            cont = 0
        }

        if (!(car && carro)){
            btn_banana9.setBackgroundResource(R.drawable.banana_1)
            btn_banana9.text = ""
            carro = false
        }else{
            cont = 0
        }

        if (!(rosa && pink)){
            btn_banana10.setBackgroundResource(R.drawable.banana_1)
            btn_banana10.text = ""
            pink = false
        }else{
            cont = 0
        }
    }

    fun parabens(){
        val builder = AlertDialog.Builder(this,R.style.Theme_AppCompat_Light_Dialog)
        builder.setTitle("Parabéns")
        builder.setMessage("Você concluiu o jogo da Memória")
        builder.setCancelable(false)
        builder.setPositiveButton("Voltar" ){ dialogInterface, i ->
            finish()
        }
        val dialog = builder.create()
        dialog.show()
    }
}