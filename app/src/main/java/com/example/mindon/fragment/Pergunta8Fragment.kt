package com.example.mindon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mindon.R
import com.example.mindon.model.mostrarNivel
import com.example.mindon.model.perguntas
import com.example.mindon.model.trocaTela
import kotlinx.android.synthetic.main.fragment_pergunta1.view.*
import kotlinx.android.synthetic.main.fragment_pergunta8.view.*
import kotlinx.android.synthetic.main.fragment_pergunta8.view.btn_nivel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pergunta8Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pergunta8Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  var selecao: String = ""
    private var pular = false

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
        val view: View =  inflater.inflate(R.layout.fragment_pergunta8, container, false)
        // Inflate the layout for this fragment
        for(i in 0..12){
            if(i != 7){
                if(perguntas.get(i).acerto.equals("")){
                    pular = true
                    break
                }
            }
        }
        if(!pular){
            view.btn_pular8.visibility = View.GONE
        }
        opcoes(view)
        view.btn_verificar8.setOnClickListener{
            conferir(view)
        }
        
        view.btn_pular8.setOnClickListener {
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            trocaTela(fragmentTransaction,8)
        }
        view.btn_nivel.setOnClickListener {
            mostrarNivel(context!!)
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
         * @return A new instance of fragment Pergunta8Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pergunta8Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun opcoes (view: View){
        if(view.btn_verificar8.text.toString().equals("Verificar")){
            view.txt_opcao_a_pergunta8.setOnClickListener {
                view.txt_opcao_a_pergunta8.setBackgroundColor(resources.getColor(R.color.colorGray))


                view.txt_opcao_b_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_c_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_d_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))


                selecao = "a"
            }
            view.txt_opcao_b_pergunta8.setOnClickListener {
                view.txt_opcao_b_pergunta8.setBackgroundColor(resources.getColor(R.color.colorGray))

                view.txt_opcao_a_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_c_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_d_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))


                selecao = "b"
            }
            view.txt_opcao_c_pergunta8.setOnClickListener {
                view.txt_opcao_c_pergunta8.setBackgroundColor(resources.getColor(R.color.colorGray))

                view.txt_opcao_b_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_a_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_d_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))

                selecao = "c"
            }
            view.txt_opcao_d_pergunta8.setOnClickListener {
                view.txt_opcao_d_pergunta8.setBackgroundColor(resources.getColor(R.color.colorGray))

                view.txt_opcao_b_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_c_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))
                view.txt_opcao_a_pergunta8.setBackgroundColor(resources.getColor(R.color.colorBackground))

                selecao = "d"
            }
        }else{
            view.txt_opcao_a_pergunta8.setOnClickListener {

            }
            view.txt_opcao_b_pergunta8.setOnClickListener {

            }
            view.txt_opcao_c_pergunta8.setOnClickListener {

            }
            view.txt_opcao_d_pergunta8.setOnClickListener {

            }
        }
    }

    private fun conferir(view:View){
        if(view.btn_verificar8.text.toString().equals("Verificar")){
            if(selecao.equals("c")){
                view.txt_opcao_c_pergunta8.setBackgroundColor(resources.getColor(R.color.btnPular))
            }else if(selecao.equals(("b"))){
                view.txt_opcao_b_pergunta8.setBackgroundColor(resources.getColor(R.color.btnPular))
            }else if(selecao.equals("d")){
                view.txt_opcao_d_pergunta8.setBackgroundColor(resources.getColor(R.color.btnPular))
            }

            if(selecao.equals("")){
                Toast.makeText(context,"Nenhuma opção selecionada", Toast.LENGTH_SHORT).show()
            }else{
                view.txt_opcao_a_pergunta8.setBackgroundColor(resources.getColor(R.color.greenEmerald))
                if(selecao.equals("a")){
                    perguntas.get(7).acerto = "true"
                }else{
                    perguntas.get(7).acerto = "false"
                }
                if(!pular){
                    view.btn_verificar8.text = "Próxima"
                    view.btn_verificar8.visibility = View.GONE
                    view.btn_nivel.visibility = View.VISIBLE
                    opcoes(view)
                }else{
                    view.btn_verificar8.text = "Próxima"
                    view.btn_pular8.visibility = View.GONE
                    opcoes(view)
                }
            }
        }else{
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            trocaTela(fragmentTransaction,8)
        }

    }
}