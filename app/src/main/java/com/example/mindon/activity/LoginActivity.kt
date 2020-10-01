package com.example.mindon.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mindon.R
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener{
            logar()
        }
    }

    fun logar(){
        var email = edit_email_login.text.toString()
        var senha = edit_senha_login.text.toString()

        var valido = true

        if (email.isEmpty()){
            edit_email_login.error = "Campo obrigatório"
            valido = false

        }

        if (senha.isEmpty()){
            edit_senha_login.error = "Campo obrigatório"
            valido = false
        }

        if(valido){
            auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener {
                if(it.isSuccessful){
                    val pd = ProgressDialog(this)
                    pd.setMessage("Entrando...")
                    pd.show()
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    try {
                        throw it.exception!!
                    }catch (e:FirebaseAuthInvalidCredentialsException){
                        Toast.makeText(applicationContext,"Credenciais inválidas!",Toast.LENGTH_SHORT).show()
                    }catch (e:FirebaseAuthException){
                        Toast.makeText(applicationContext,"Email nao cadastrado!",Toast.LENGTH_SHORT).show()
                    }catch (e:Exception){
                        Toast.makeText(applicationContext,"Erro ao realizar login: " +e.message,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}