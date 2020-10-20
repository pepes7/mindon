package com.example.mindon.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mindon.R
import kotlinx.android.synthetic.main.fragment_pergunta1.*
import kotlinx.android.synthetic.main.fragment_pergunta1.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pergunta1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pergunta1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =  inflater.inflate(R.layout.fragment_pergunta1, container, false)
        // Inflate the layout for this fragment

        opcoes(view)
        view.btn_verificar.setOnClickListener{
            /*
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.viewPage, Pergunta2Fragment()).commit()*/
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pergunta1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pergunta1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun opcoes (view: View){
        view.txt_opcao_a_pergunta1.setOnClickListener {
            view.txt_opcao_a_pergunta1.setBackgroundColor(resources.getColor(R.color.colorGray))

            view.txt_opcao_b_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_c_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_d_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_e_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))

        }
        view.txt_opcao_b_pergunta1.setOnClickListener {
            view.txt_opcao_b_pergunta1.setBackgroundColor(resources.getColor(R.color.colorGray))

            view.txt_opcao_a_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_c_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_d_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_e_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))

        }
        view.txt_opcao_c_pergunta1.setOnClickListener {
            view.txt_opcao_c_pergunta1.setBackgroundColor(resources.getColor(R.color.colorGray))

            view.txt_opcao_b_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_a_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_d_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_e_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))

        }
        view.txt_opcao_d_pergunta1.setOnClickListener {
            view.txt_opcao_d_pergunta1.setBackgroundColor(resources.getColor(R.color.colorGray))

            view.txt_opcao_b_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_c_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_a_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_e_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))

        }
        view.txt_opcao_e_pergunta1.setOnClickListener {
            view.txt_opcao_e_pergunta1.setBackgroundColor(resources.getColor(R.color.colorGray))

            view.txt_opcao_b_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_c_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_d_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))
            view.txt_opcao_a_pergunta1.setBackgroundColor(resources.getColor(R.color.colorBackground))

        }
    }
}