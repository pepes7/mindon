package com.example.homemindon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mindon.R
import com.example.mindon.model.bananaGlobbal
import kotlinx.android.synthetic.main.fragment_skins.view.*

class SkinsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_skins, container, false)

        if (bananaGlobbal.isEmpty()){
            view.textBanana.text = "0"
        }else{
            view.textBanana.text = bananaGlobbal
        }

        return view
    }
}