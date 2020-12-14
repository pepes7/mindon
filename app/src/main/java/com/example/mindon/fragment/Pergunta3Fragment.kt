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
import kotlinx.android.synthetic.main.fragment_pergunta3.view.*
import kotlinx.android.synthetic.main.fragment_pergunta3.view.btn_nivel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pergunta3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pergunta3Fragment : Fragment() {
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
        val view: View =  inflater.inflate(R.layout.fragment_pergunta3, container, false)
        // Inflate the layout for this fragment
        for(i in 0..12){
            if(i != 2){
                if(perguntas.get(i).acerto.equals("")){
                    pular = true
                    break
                }
            }
        }
        if(!pular){
            view.btn_pular3.visibility = View.GONE
        }

        opcoes(view)
        view.btn_verificar3.setOnClickListener{
            conferir(view)
        }
        view.btn_pular3.setOnClickListener {
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            trocaTela(fragmentTransaction,3)
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
         * @return A new instance of fragment Pergunta3Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pergunta3Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun opcoes (view: View){
        if(view.btn_verificar3.text.toString().equals("Verificar")){
            view.btn_opcao1_pergunta3.setOnClickListener {
                view.btn_opcao1_pergunta3.backgroundTintList = resources.getColorStateList(R.color.colorGray)


                view.btn_opcao2_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao3_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao4_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)


                selecao = "1"
            }
            view.btn_opcao2_pergunta3.setOnClickListener {
                view.btn_opcao2_pergunta3.backgroundTintList = resources.getColorStateList(R.color.colorGray)

                view.btn_opcao1_pergunta3.backgroundTintList=  resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao3_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao4_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)


                selecao = "2"
            }
            view.btn_opcao3_pergunta3.setOnClickListener {
                view.btn_opcao3_pergunta3.backgroundTintList = resources.getColorStateList(R.color.colorGray)

                view.btn_opcao2_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao1_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao4_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)

                selecao = "3"
            }
            view.btn_opcao4_pergunta3.setOnClickListener {
                view.btn_opcao4_pergunta3.backgroundTintList = resources.getColorStateList(R.color.colorGray)

                view.btn_opcao2_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao3_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)
                view.btn_opcao1_pergunta3.backgroundTintList = resources.getColorStateList(R.color.almostWhite)


                selecao = "4"
            }
        }else{
            view.btn_opcao1_pergunta3.setOnClickListener {

            }
            view.btn_opcao2_pergunta3.setOnClickListener {

            }
            view.btn_opcao3_pergunta3.setOnClickListener {

            }
            view.btn_opcao4_pergunta3.setOnClickListener {

            }
        }
    }

    private fun conferir(view:View){
        if(view.btn_verificar3.text.toString().equals("Verificar")){
            if(selecao.equals("1")){
                view.btn_opcao1_pergunta3.backgroundTintList = resources.getColorStateList(R.color.btnPular)
            }else if(selecao.equals(("2"))){
                view.btn_opcao2_pergunta3.backgroundTintList = resources.getColorStateList(R.color.btnPular)
            }else if(selecao.equals("3")){
                view.btn_opcao3_pergunta3.backgroundTintList = resources.getColorStateList(R.color.btnPular)
            }
            if(selecao.equals("")){
                Toast.makeText(context,"Nenhuma opção selecionada", Toast.LENGTH_SHORT).show()
            }else{
                view.btn_opcao4_pergunta3.backgroundTintList = resources.getColorStateList(R.color.greenEmerald)
                if(selecao.equals("4")){
                    perguntas.get(2).acerto = "true"
                }else{
                    perguntas.get(2).acerto = "false"
                }
                if(!pular){
                    view.btn_verificar3.text = "Próxima"
                    view.btn_verificar3.visibility = View.GONE
                    view.btn_nivel.visibility = View.VISIBLE
                    opcoes(view)
                }else{
                    view.btn_verificar3.text = "Próxima"
                    view.btn_pular3.visibility = View.GONE
                    val lp = view.btn_verificar3.layoutParams
                    if (lp is ViewGroup.MarginLayoutParams){
                        lp.leftMargin = 0
                    }
                    opcoes(view)
                }
            }
        }else{
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            trocaTela(fragmentTransaction,3)
        }
    }
}