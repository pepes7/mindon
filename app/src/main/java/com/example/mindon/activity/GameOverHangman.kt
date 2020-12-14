package com.example.mindon.activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class GameOverHangman : AppCompatActivity() {
    private var buttonReturnToMenu: Button? = null
    private var buttonTryAgain: Button? = null
    var viewActualScore: TextView? = null
    val messageWithActualScore = "Score: "
    var score = 0
    var level = 0

    private var banana = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over_hangman)
        val getScore = intent.extras

        if (getScore != null) {
            score = getScore.getInt("score")
        }
        val getLevel = intent.extras
        if (getLevel != null) {
            level = getLevel.getInt("level")
        }
        carregar()
        buttonReturnToMenu = findViewById<View>(R.id.buttonReturnToMenu) as Button
        buttonTryAgain = findViewById<View>(R.id.buttonTryAgain) as Button
        viewActualScore = findViewById<View>(R.id.actualScore) as TextView
        val messageWithTheCompleteScore = messageWithActualScore + score
        viewActualScore!!.text = messageWithTheCompleteScore
        buttonTryAgain!!.setOnClickListener {
            FirebaseDatabase.getInstance().reference.child("usuarios").child(FirebaseAuth.getInstance().uid!!).child("banana").setValue(banana.toString())
            val intent = Intent(this@GameOverHangman, HangmanGame::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("content", level)
            startActivity(intent)
        }
        buttonReturnToMenu!!.setOnClickListener {
            FirebaseDatabase.getInstance().reference.child("usuarios").child(FirebaseAuth.getInstance().uid!!).child("banana").setValue(banana.toString())
            val intent = Intent(this@GameOverHangman, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
        }
    }

    fun carregar(){
        FirebaseDatabase.getInstance().reference.child("usuarios").child(FirebaseAuth.getInstance().uid!!).addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val u = dataSnapshot.getValue(Usuario::class.java)!!
                if (u.banana.isEmpty()){
                    banana =  score
                }else{
                    banana = u.banana.toInt() +score

                }


            }

        })
    }
    
}