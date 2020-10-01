package com.example.mindon.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //codigo para sublinhar o texto
        var text = findViewById<TextView>(R.id.tenho_conta)
        var content = SpannableString("Já tenho uma conta")
        content.setSpan(UnderlineSpan(),0,content.length,0)
        text.text = content

        database = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        if(auth.currentUser!= null){
            startActivity(Intent(this,HomeActivity::class.java))

        }


        btn_cadastrar.setOnClickListener{
            cadastrar()
        }

        tenho_conta.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    fun cadastrar(){
        var nome = edit_nome_cadastro.text.toString()
        var email = edit_email_cadastro.text.toString()
        var senha = edit_senha_cadastro.text.toString()

        var valido = true

        if (nome.isEmpty()){
            edit_nome_cadastro.error = "Campo obrigatório"
            valido = false
        }

        if (email.isEmpty()){
            edit_email_cadastro.error = "Campo obrigatório"
            valido = false

        }

        if (senha.isEmpty()){
            edit_senha_cadastro.error = "Campo obrigatório"
            valido = false
        }

        if(valido){
           val u = Usuario()
            u.nome = nome
            u.email = email

            val pd = ProgressDialog(this)
            pd.setMessage("Cadastrando ...")
            pd.show()

            auth.createUserWithEmailAndPassword(u.email,senha)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        val usuarios = database.child("usuarios")
                        val ref = usuarios.child(auth!!.currentUser!!.uid)
                        ref.setValue(u)

                        Toast.makeText(this,"Usuário cadastrado com sucesso!",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,HomeActivity::class.java))
                    }else{
                        try {
                            throw it.exception!!
                        } catch (e: FirebaseAuthWeakPasswordException) {
                            Toast.makeText(
                                this,
                                "Senha fraca!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } catch (e: FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(
                                this,
                                "Email inválido!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } catch (e: FirebaseAuthUserCollisionException) {
                            Toast.makeText(
                                this,
                                "Usuário já cadastrado!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } catch (e: Exception) {
                            Toast.makeText(
                                this,
                                "" + e.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

        }

    }
}