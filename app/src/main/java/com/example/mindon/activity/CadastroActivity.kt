package com.example.mindon.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import android.widget.Toast
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.example.mindon.model.idUser
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 100

    private lateinit var database : DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient


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


        // Configura o Token do Google
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()

//        googleSignInClient = GoogleSignIn.getClient(this, gso)

//        btn_cadastro_google.setOnClickListener{
//            val signInIntent = googleSignInClient.signInIntent
//            startActivityForResult(signInIntent, RC_SIGN_IN)
//        }

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

            intent = Intent(applicationContext, EscolhaNivelActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("nome", nome)
            intent.putExtra("senha", senha)
            startActivity(intent)
        }
    }

//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                val account = task.getResult(ApiException::class.java)
//                firebaseAuthWithGoogle(account!!)
//            } catch (e: ApiException) {
//                e.printStackTrace()
//                Toast.makeText(applicationContext,e.message,Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    val signInAccount = GoogleSignIn.getLastSignedInAccount(this)
//                    var database = FirebaseDatabase.getInstance().reference
//                    val usuarios = database.child("usuarios")
//                    val ref = usuarios.child(signInAccount!!.id.toString())
//                    val u = Usuario()
//                    u.nivel = "basico"
//                    u.nome = signInAccount!!.displayName.toString()
//                    u.email = signInAccount!!.email.toString()
//                    u.foto = signInAccount!!.photoUrl.toString()
//
//                  idUser = signInAccount!!.id.toString()
//                    ref.setValue(u).addOnCompleteListener {
//                        if (it.isSuccessful){
//                            val intent = Intent(this@CadastroActivity, HomeActivity::class.java)
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                            Toast.makeText(applicationContext,"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show()
//                            startActivity(intent)
//                        }
//                    }
//                } else {
//                    Toast.makeText(applicationContext,"Falha ao tentar autenticar com o google",Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
}