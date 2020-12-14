package com.example.homemindon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mindon.R
import com.example.mindon.model.Usuario
import com.example.mindon.model.nivelUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_skins.*
import kotlinx.android.synthetic.main.fragment_skins.view.*

class SkinsFragment : Fragment() {
    private val referencia = FirebaseDatabase.getInstance().reference
    private lateinit var auth: FirebaseAuth
    private lateinit var imageMacaco : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_skins, container, false)

        auth = FirebaseAuth.getInstance()
        imageMacaco = view.findViewById(R.id.macaco)


        carregar(view)

        view.btn_farda.setOnClickListener {
            val bananas = view.textBanana.text.toString().toInt()

            if (bananas>=200){
                macaco.setImageDrawable(resources.getDrawable(R.drawable.farda_formandos))
                salvarSkin("farda",bananas,200)
            }else{
                Toast.makeText(context,"Você precisa de 200 bananas para usar essa skin",Toast.LENGTH_SHORT).show()
            }

        }

        view.btn_ifam.setOnClickListener {
            val bananas = view.textBanana.text.toString().toInt()
            if (bananas>=300){
                macaco.setImageDrawable(resources.getDrawable(R.drawable.farda_ifam))
                salvarSkin("ifam",bananas,300)
            }else{
                Toast.makeText(context,"Você precisa de 300 bananas para usar essa skin",Toast.LENGTH_SHORT).show()
            }

        }

        view.btn_sc.setOnClickListener {
            val bananas = view.textBanana.text.toString().toInt()
            if (bananas>=400){
                macaco.setImageDrawable(resources.getDrawable(R.drawable.sc_2018))
                salvarSkin("sc",bananas,400)
            }else{
                Toast.makeText(context,"Você precisa de 400 bananas para usar essa skin",Toast.LENGTH_SHORT).show()
            }

        }

        view.btn_bsg.setOnClickListener {
            val bananas = view.textBanana.text.toString().toInt()
            if (bananas>=500){
                macaco.setImageDrawable(resources.getDrawable(R.drawable.bsg))
                salvarSkin("bsg",bananas,500)
            }else{
                Toast.makeText(context,"Você precisa de 500 bananas para usar essa skin",Toast.LENGTH_SHORT).show()
            }
        }

        view.btn_blackout.setOnClickListener {
            val bananas = view.textBanana.text.toString().toInt()
            if (bananas>=1000){
                macaco.setImageDrawable(resources.getDrawable(R.drawable.blackout))
                salvarSkin("blackout",bananas,1000)
            }else{
                Toast.makeText(context,"Você precisa de 1000 bananas para usar essa skin",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

    fun salvarSkin(nome : String, bananas: Int,diminuir: Int){
        val totalBananas = bananas - diminuir
        referencia.child("usuarios").child(auth.uid!!).child("skin").setValue(nome)
        referencia.child("usuarios").child(auth.uid!!).child("banana").setValue(totalBananas.toString())
    }
    fun carregar(view: View){
        val usuario = referencia.child("usuarios").child(auth.uid!!)
        //cria um listener para o nó
        usuario.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //recupera as informações do firebase e coloca dentro do objeto Usuario
                val user = dataSnapshot.getValue(Usuario::class.java)!!
                //referencia da view do nav header

                if (user.banana.isEmpty()){
                    view.textBanana.text = "0"
                }else{
                    view.textBanana.text = user.banana
                }

                if (!user.skin.isEmpty()){
                   if (user.skin.equals("farda")){
                       imageMacaco.setImageDrawable(resources.getDrawable(R.drawable.farda_ifam))
                   }
                    if (user.skin.equals("ifam")){
                        imageMacaco.setImageDrawable(resources.getDrawable(R.drawable.farda_ifam))
                    }
                    if (user.skin.equals("sc")){
                        imageMacaco.setImageDrawable(resources.getDrawable(R.drawable.sc_2018))
                    }
                    if (user.skin.equals("bsg")){
                        imageMacaco.setImageDrawable(resources.getDrawable(R.drawable.bsg))
                    }
                    if (user.skin.equals("blackout")){
                        imageMacaco.setImageDrawable(resources.getDrawable(R.drawable.blackout))
                    }
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}