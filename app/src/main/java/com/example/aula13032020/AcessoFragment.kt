package com.example.aula13032020

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.aula13032020.ViewModel.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_acesso.*

/**
 * A simple [Fragment] subclass.
 */
class AcessoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acesso, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuarioViewModel :UsuarioViewModel? = null //ViewModelProviders.of()
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                .get(UsuarioViewModel::class.java) //verificar se tem um ou nao.
        }

        var usuario = usuarioViewModel!!.usuario
        if(
            usuario != null &&
            !usuario!!.email.isNullOrBlank()){
            editTextAcessoSenha.setText(usuario!!.email.toString())
        }

        btnAcessar.setOnClickListener {
            if (
                editTextAcessoEmail.text.equals(usuario!!.email) &&
                editTextAcessoSenha.text.equals(usuario!!.senha)
                    ) {
                startActivity(Intent(activity, AppActivity::class.java))
            }
        }

        btnCadastro.setOnClickListener {
            findNavController()
                .navigate(R.id.cadastroFragment)
        }
    }
}
