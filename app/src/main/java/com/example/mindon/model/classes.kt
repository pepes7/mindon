package com.example.mindon.model

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mindon.R
import com.example.mindon.activity.CadastroActivity
import com.example.mindon.activity.HomeActivity
import com.example.mindon.fragment.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.FirebaseDatabase


open class Usuario(
    open var nome : String = "",
    open var email : String = "",
    open var foto : String = "",
    open var nivel : String = "",
    open var banana : String = ""
)

open class Pergunta(
    open var numero : String = "",
    open var acerto : String = ""
)

var perguntas = mutableListOf<Pergunta>()
var userNivelamento : Usuario  = Usuario()
var userSenha = ""

var idUser = ""

var nivelUser = ""

var bananaGlobbal = ""

fun trocaTela(fragmentTransaction : FragmentTransaction, atual: Int){
    var fragment : Fragment
    var trocou = false
    if(atual != 13){
        for (i in atual-1.. perguntas.size-1){
            if(perguntas.get(i+1).acerto.equals("")){
                fragment = trocaActivity(perguntas.get(i+1).numero)
                fragmentTransaction.replace(R.id.viewPage,
                    fragment
                ).commit()
                trocou = true
                break
            }
        }
    }
    if(!trocou){
        for (i in 0..12){
            if(perguntas.get(i).acerto.equals("")){
                fragment = trocaActivity(perguntas.get(i).numero)
                fragmentTransaction.replace(R.id.viewPage,
                    fragment
                ).commit()
                trocou = true
                break
            }
        }
    }
}

fun trocaActivity(tela : String):Fragment{
    when (tela){
        "1" -> return Pergunta1Fragment()
        "2" -> return Pergunta2Fragment()
        "3" -> return Pergunta3Fragment()
        "4" -> return Pergunta4Fragment()
        "5" -> return Pergunta5Fragment()
        "6" -> return Pergunta6Fragment()
        "7" -> return Pergunta7Fragment()
        "8" -> return Pergunta8Fragment()
        "9" -> return Pergunta9Fragment()
        "10" -> return Pergunta10Fragment()
        "11" -> return Pergunta11Fragment()
        "12" -> return Pergunta12Fragment()

    }
    return Pergunta13Fragment()
}

fun mostrarNivel(context: Context){
    var acertos = 0
    var nivel = ""
    for(i in 0..12){
        if(perguntas.get(i).acerto.equals("true")){
            acertos +=1
        }
    }
    val porcentagem = (acertos*100)/13
    if(porcentagem >= 84){
        nivel = "Avançado"
    }else if(porcentagem < 84 && porcentagem >=50 ){
        nivel = "Intermediário"
    }else{
        nivel = "Básico"
    }
    val builder = AlertDialog.Builder(context,R.style.Theme_AppCompat_Light_Dialog)
    builder.setTitle("Parabéns por Concluir o Nivelamento")
    builder.setMessage("Você acertou $acertos questões. Seu Nível : $nivel")
    builder.setCancelable(false)
    builder.setPositiveButton("Finalizar Cadastro" ){ dialogInterface, i ->
        cadastrar(nivel,context)
    }
    val dialog = builder.create()
    dialog.show()
}

fun cadastrar(string:String,context: Context){
    if(string.equals("Básico")){
        userNivelamento.nivel = "basico"
    }else if(string.equals("Intermediário")){
        userNivelamento.nivel = "inter"
    }else{
        userNivelamento.nivel = "avancado"
    }
    val pd = ProgressDialog(context)
    pd.setMessage("Cadastrando ...")
    pd.show()
    var auth = FirebaseAuth.getInstance()
    var database = FirebaseDatabase.getInstance().reference
    auth.createUserWithEmailAndPassword(userNivelamento.email, userSenha)
        .addOnCompleteListener {
            if(it.isSuccessful){
                val usuarios = database.child("usuarios")
                val ref = usuarios.child(auth!!.currentUser!!.uid)
                ref.setValue(userNivelamento).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context,"Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    }
                }


            }else{
                try {
                    throw it.exception!!
                } catch (e: FirebaseAuthWeakPasswordException) {
                    Toast.makeText(
                        context,
                        "Senha fraca!",
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(
                        context,
                        "Email inválido!",
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: FirebaseAuthUserCollisionException) {
                    Toast.makeText(
                        context,
                        "Usuário já cadastrado!",
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "" + e.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
                context.startActivity(Intent(context, CadastroActivity::class.java))
            }
        }

}
