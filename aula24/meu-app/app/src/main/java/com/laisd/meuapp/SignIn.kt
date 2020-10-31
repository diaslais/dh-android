package com.laisd.meuapp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SignIn : Fragment() {
    lateinit var iLogIn: ILogIn
    lateinit var signInView: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iLogIn = context as ILogIn
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        signInView = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInClick(signInView)

        // Esvaziar label de erro no TextInputLayout ao digitar algo
        signInView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSignIn).addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signInView.findViewById<TextInputLayout>(R.id.txtLayoutUsernameSIgnIn).error = ""
            }
        })

        // Esvaziar label de erro no TextInputLayout ao digitar algo
        signInView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignIn).addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signInView.findViewById<TextInputLayout>(R.id.txtLayouttPasswordSignIn).error = ""
            }
        })

        return signInView
    }

    fun signInClick(signInView: View){
        val user = signInView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSignIn)
        val userLayout = signInView.findViewById<TextInputLayout>(R.id.txtLayoutUsernameSIgnIn)
        val password = signInView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignIn)
        val passwordLayout = signInView.findViewById<TextInputLayout>(R.id.txtLayouttPasswordSignIn)
        val btnLogIn = signInView.findViewById<Button>(R.id.btnLogInSignIn)

        btnLogIn.setOnClickListener {
        var taSemErro = true
            if (user.text.toString().isEmpty()){
                userLayout.error = "Username is required"
                taSemErro = false
            }
            if (password.text.toString().isEmpty()){
                passwordLayout.error = "Password is required"
                taSemErro =  false
            }
            if (taSemErro) {
                iLogIn.logIn(user.text.toString(), password.text.toString())
            }
        }
    }

    fun apagaErro(edt: String, layout: TextInputLayout){
        layout.isErrorEnabled = edt.isEmpty()
    }
}