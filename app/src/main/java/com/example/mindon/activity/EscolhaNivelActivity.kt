package com.example.mindon.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_escolha_nivel.*

class EscolhaNivelActivity : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var dados: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolha_nivel)

        database = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        btn_nivelamento.setOnClickListener{
            startActivity(Intent(this,NivelamentoActivity::class.java))
        }

        btn_basico.setOnClickListener{
            cadastrar("basico")
        }

        btn_inter.setOnClickListener{
            cadastrar("inter")
        }

        btn_avancado.setOnClickListener {
            cadastrar("avancado")
        }
    }

    fun cadastrar(string:String){
        dados = intent.extras!!
        val email = dados.getString("email")
        val nome = dados.getString("nome")
        val senha = dados.getString("senha")


        val u = Usuario()
        u.email = email!!
        u.nome = nome!!
        u.nivel = string

        val pd = ProgressDialog(this)
        pd.setMessage("Cadastrando ...")
        pd.show()

        auth.createUserWithEmailAndPassword(u.email,senha!!)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val usuarios = database.child("usuarios")
                    val ref = usuarios.child(auth!!.currentUser!!.uid)
                    ref.setValue(u)

                    Toast.makeText(this,"Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,HomeActivity::class.java))
                }else{
                    try {
                        throw it.exception!!
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        Toast.makeText(
                            this,
                            "Senha fraca!",
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(
                            this,
                            "Email inválido!",
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: FirebaseAuthUserCollisionException) {
                        Toast.makeText(
                            this,
                            "Usuário já cadastrado!",
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "" + e.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    startActivity(Intent(this,CadastroActivity::class.java))
                }
            }

    }
}