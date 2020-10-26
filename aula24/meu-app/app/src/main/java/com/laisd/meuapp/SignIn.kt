package com.laisd.meuapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SignIn : Fragment() {
    lateinit var iLogIn: ILogIn

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iLogIn = context as ILogIn
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val signInView = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInClick(signInView)

        return signInView
    }

    fun signInClick(signInView: View){
        val user = signInView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSignIn)
        val password = signInView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignIn)
        val btnLogIn = signInView.findViewById<Button>(R.id.btnLogInSignIn)

        btnLogIn.setOnClickListener {
            if (user.text.toString().isEmpty()){
                user.error = "Username is required"
            } else if (password.text.toString().isEmpty()){
                password.error = "Password is required"
            } else {
                iLogIn.logIn(user.text.toString(), password.text.toString())
            }
        }
    }
}