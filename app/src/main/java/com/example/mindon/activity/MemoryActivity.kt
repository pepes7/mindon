package com.example.mindon.activity

import android.app.AlertDialog
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.example.mindon.model.cadastrar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
    private var banana = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        val toolbar: Toolbar = findViewById(R.id.toolbar_memory)
        setSupportActionBar(toolbar)

        supportActionBar!!.title = "Memory"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        opcoes()

        carregar()
    }

    fun carregar(){
        FirebaseDatabase.getInstance().reference.child("usuarios").child(FirebaseAuth.getInstance().uid!!).addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val u = dataSnapshot.getValue(Usuario::class.java)!!
                if (u.banana.isEmpty()){
                    banana = 20
                }else{
                    banana = u.banana.toInt() +20

                }

            }

        })
    }
    fun opcoes(){
        if(cont != 2){
            btn_banana1.setOnClickListener {
                btn_banana1.setBackgroundResource(R.color.orangeForButton)
                btn_banana1.text = "I think the movie is going to be good"
                cont+=1
                car = true
                opcoes()
            }

            btn_banana2.setOnClickListener {
                btn_banana2.setBackgroundResource(R.color.orangeForButton)
                btn_banana2.text = "He is very happy"
                casa = true
                cont+=1
                opcoes()
            }

            btn_banana3.setOnClickListener {
                btn_banana3.setBackgroundResource(R.color.orangeForButton)
                btn_banana3.text = "Ele está muito feliz"
                cont+=1
                house = true
                opcoes()
            }

            btn_banana4.setOnClickListener {
                btn_banana4.setBackgroundResource(R.color.orangeForButton)
                btn_banana4.text = "Ela comprou alguns livros"
                cont+=1
                azul = true
                opcoes()
            }

            btn_banana5.setOnClickListener {
                btn_banana5.setBackgroundResource(R.color.orangeForButton)
                btn_banana5.text = "Que surpresa boa!"
                cont+=1
                rosa = true
                opcoes()
            }

            btn_banana6.setOnClickListener {
                btn_banana6.setBackgroundResource(R.color.orangeForButton)
                btn_banana6.text = "When will you be back?"
                cont+=1
                apple = true
                opcoes()
            }

            btn_banana7.setOnClickListener {
                btn_banana7.setBackgroundResource(R.color.orangeForButton)
                btn_banana7.text = "She bought some books"
                cont+=1
                blue = true
                opcoes()
            }

            btn_banana8.setOnClickListener {
                btn_banana8.setBackgroundResource(R.color.orangeForButton)
                btn_banana8.text = "Quando você estará de volta"
                cont+=1
                maca = true
                opcoes()
            }

            btn_banana9.setOnClickListener {
                btn_banana9.setBackgroundResource(R.color.orangeForButton)
                btn_banana9.text = "Acho que o filme vai ser bom"
                cont+=1
                carro =true
                opcoes()
            }
            btn_banana10.setOnClickListener {
                btn_banana10.setBackgroundResource(R.color.orangeForButton)
                btn_banana10.text = "What a nice surprise!"
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
            btn_banana1.setBackgroundResource(R.drawable.carta)
            btn_banana1.text = ""
            car = false
        }else{
            cont = 0
        }

        if (!(casa && house)){
            btn_banana2.setBackgroundResource(R.drawable.carta)
            btn_banana2.text = ""
            casa = false
        }else{
            cont = 0
        }

        if (!(casa && house)){
            btn_banana3.setBackgroundResource(R.drawable.carta)
            btn_banana3.text = ""
            casa = false
        }else{
            cont = 0
        }

        if (!(azul && blue)){
            btn_banana4.setBackgroundResource(R.drawable.carta)
            btn_banana4.text = ""
            azul = false
        }else{
            cont = 0
        }

        if (!(rosa && pink)){
            btn_banana5.setBackgroundResource(R.drawable.carta)
            btn_banana5.text = ""
            rosa = false
        }else{
            cont = 0
        }

        if (!(apple && maca)){
            btn_banana6.setBackgroundResource(R.drawable.carta)
            btn_banana6.text = ""
            apple = false
        }else{
            cont = 0
        }


        if (!(azul && blue)){
            btn_banana7.setBackgroundResource(R.drawable.carta)
            btn_banana7.text = ""
            blue = false
        }else{
            cont = 0
        }


        if (!(maca && apple)){
            btn_banana8.setBackgroundResource(R.drawable.carta)
            btn_banana8.text = ""
            maca = false
        }else{
            cont = 0
        }

        if (!(car && carro)){
            btn_banana9.setBackgroundResource(R.drawable.carta)
            btn_banana9.text = ""
            carro = false
        }else{
            cont = 0
        }

        if (!(rosa && pink)){
            btn_banana10.setBackgroundResource(R.drawable.carta)
            btn_banana10.text = ""
            pink = false
        }else{
            cont = 0
        }
    }

    fun parabens(){
        FirebaseDatabase.getInstance().reference.child("usuarios").child(FirebaseAuth.getInstance().uid!!).child("banana").setValue(banana.toString())
        val builder = AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog)
        builder.setTitle("Parabéns")
        builder.setMessage("Você concluiu o jogo da Memória. Recebeu 20 bananas")
        builder.setCancelable(false)
        builder.setPositiveButton("Voltar" ){ dialogInterface, i ->
            finish()
        }
        val dialog = builder.create()
        dialog.show()
    }
}