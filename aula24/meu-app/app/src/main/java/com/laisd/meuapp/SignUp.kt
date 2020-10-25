package com.laisd.meuapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SignUp : Fragment() {
    lateinit var iSignUp: ISignUp

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iSignUp = context as ISignUp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val signUpView = inflater.inflate(R.layout.fragment_sign_up, container, false)

        signUpView.btnSignUpSignUp.setOnClickListener {
            val user = signUpView.txtInputUsernameSIgnUp.editText?.text.toString()
            val password = signUpView.txtInputPasswordSignUp.editText?.text.toString()
            val confirmation = signUpView.txtInputConfirmPasswordSignUp.editText?.text.toString()
            iSignUp.signUp(user, password, confirmation, signUpView)
        }
        return signUpView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}