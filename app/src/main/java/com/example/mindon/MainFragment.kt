package com.example.homemindon.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mindon.R
import com.example.mindon.activity.JogoActivity
import com.example.mindon.activity.MemoryActivity
import com.example.mindon.activity.MemoryAvancadoActivity
import com.example.mindon.activity.MemoryInterActivity
import com.example.mindon.model.nivelUser
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_main, container, false)
        view.buttonMemory.setOnClickListener {
            if(nivelUser.equals("basico")){
                startActivity(Intent(context,MemoryActivity::class.java))
            }else if(nivelUser.equals("inter")){
                startActivity(Intent(context, MemoryAvancadoActivity::class.java))
            }else if(nivelUser.equals("avancado")){
                startActivity(Intent(context, MemoryInterActivity::class.java))
            }
        }


        view.buttonJogo.setOnClickListener {
            startActivity(Intent(context,JogoActivity::class.java))
        }

        return view
    }

}