package com.example.mindon.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_ligar.*


class LigarActivity : AppCompatActivity() {
    private var cont = 1
    private var correto1 = false
    private var correto2 = false
    private var correto3 = false
    private var correto4 = false
    private var correto5 = false
    private var selecao = ""

    private var banana = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ligar)

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
    fun opcoes (){
        if(cont == 1){
            txt_1.setOnClickListener {
                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "1"
                }
                if (!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "1"
                }

                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "1"
                }

                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "1"
                }
                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "1"
                }

                opcoes ()
            }

            txt_2.setOnClickListener {
                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "2"
                }


                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "2"
                }

                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "2"
                }

                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "2"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "2"
                }
                opcoes ()
            }

            txt_3.setOnClickListener {
                if (!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "3"
                }


                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "3"
                }

                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "3"
                }

                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "3"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "3"
                }
                opcoes ()
            }

            txt_4.setOnClickListener {

                if (!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "4"
                }


                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "4"
                }
                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "4"
                }
                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "4"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "4"
                }

                opcoes ()
            }

            txt_5.setOnClickListener {
                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "5"
                }

                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "5"
                }
                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "5"
                }
                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "5"
                }
                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "5"
                }
                opcoes ()
            }

            txt_a.setOnClickListener {
                if(!correto2){
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "a"
                }

                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "a"
                }

                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "a"
                }

                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "a"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "a"
                }
                opcoes ()
            }

            txt_b.setOnClickListener {

                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "b"
                }
                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "b"
                }
                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "b"
                }

                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorGray))
                    selecao = "b"
                }


                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "b"
                }
                opcoes ()
            }

            txt_c.setOnClickListener {

                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "c"
                }
                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "c"
                }
                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorGray))
                    selecao = "c"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "c"
                }


                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "c"
                }
                opcoes ()
            }

            txt_d.setOnClickListener {

                if(!correto5){
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorGray))
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "d"
                }


                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "d"
                }

                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "d"
                }
                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "d"
                }

                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "d"
                }
                opcoes ()
            }

            txt_e.setOnClickListener {
                if(!correto2){
                    txt_2.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_a.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "e"
                }
                if(!correto3){
                    txt_3.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_e.setBackgroundColor(resources.getColor(R.color.colorGray))
                    selecao = "e"
                }
                if(!correto4){
                    txt_4.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_c.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "e"
                }

                if(!correto5){
                    txt_5.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_d.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "e"
                }

                if(!correto1){
                    txt_1.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    txt_b.setBackgroundColor(resources.getColor(R.color.colorBackground))
                    selecao = "e"
                }
                opcoes ()
            }

            cont += 1
        }else if (cont == 2){

            txt_1.setOnClickListener {
                if(selecao.equals("b")){
                    txt_b.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_1.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto1 = true
                }else{
                    txt_1.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_2.setOnClickListener {
                if(selecao.equals("a")){
                    txt_a.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_2.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto2 = true
                }else{
                    txt_2.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_3.setOnClickListener {
                if(selecao.equals("e")){
                    txt_e.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_3.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto3 = true
                }else{
                    txt_3.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_4.setOnClickListener {
                if(selecao.equals("c")){
                    txt_c.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_4.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto4 = true
                }else{
                    txt_4.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_5.setOnClickListener {
                if(selecao.equals("d")){
                    txt_d.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_5.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto5 = true
                }else{
                    txt_5.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_a.setOnClickListener {
                if(selecao.equals("2")){
                    txt_a.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_2.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto2 = true
                }else{
                    txt_a.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_b.setOnClickListener {
                if(selecao.equals("1")){
                    txt_b.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_1.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto1 = true
                }else{
                    txt_b.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_c.setOnClickListener {
                if(selecao.equals("4")){
                    txt_c.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_4.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto4 = true
                }else{
                    txt_c.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()

            }

            txt_d.setOnClickListener {
                if(selecao.equals("5")){
                    txt_d.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_5.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto5 = true
                }else{
                    txt_d.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }

            txt_e.setOnClickListener {
                if(selecao.equals("3")){
                    txt_e.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    txt_3.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                    correto3 = true
                }else{
                    txt_e.setBackgroundColor(resources.getColor(R.color.btnPular))
                    errado()
                }
                opcoes ()
            }
            cont = 1
        }

        if (correto1 && correto2 && correto3 && correto4 && correto5){
            parabens()
        }
    }

    fun errado(){
        when(selecao){
            "1" ->txt_1.setBackgroundColor(resources.getColor(R.color.btnPular))
            "2" ->txt_2.setBackgroundColor(resources.getColor(R.color.btnPular))
            "3" ->txt_3.setBackgroundColor(resources.getColor(R.color.btnPular))
            "4" ->txt_4.setBackgroundColor(resources.getColor(R.color.btnPular))
            "5" ->txt_5.setBackgroundColor(resources.getColor(R.color.btnPular))

            "a" ->txt_a.setBackgroundColor(resources.getColor(R.color.btnPular))
            "b" ->txt_b.setBackgroundColor(resources.getColor(R.color.btnPular))
            "c" ->txt_c.setBackgroundColor(resources.getColor(R.color.btnPular))
            "d" ->txt_d.setBackgroundColor(resources.getColor(R.color.btnPular))
            "e" ->txt_e.setBackgroundColor(resources.getColor(R.color.btnPular))
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