package com.example.homemindon.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mindon.R
import com.example.mindon.activity.MemoryActivity
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_main, container, false)
        view.buttonMemory.setOnClickListener {
            startActivity(Intent(context,MemoryActivity::class.java))
        }

        return view
    }

}