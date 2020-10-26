package com.laisd.meuapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import java.lang.Exception
import kotlin.math.sign

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
        signUpClick(signUpView)
        return signUpView
    }

    fun signUpClick(signUpView: View){
        val btnSignUp = signUpView.findViewById<Button>(R.id.btnSignUpSignUp)
        val checkBox = signUpView.findViewById<CheckBox>(R.id.checkAgreeSignUp)
        checkBox.setOnCheckedChangeListener{ _, isChecked ->
            btnSignUp.isEnabled = isChecked
        }

        btnSignUp.setOnClickListener {
            val user = signUpView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSIgnUp)
            val password = signUpView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignUp)
            val confirmation = signUpView.findViewById<TextInputEditText>(R.id.txtEdtConfirmPasswordSignUp)

            if (user.text.toString().isEmpty()){
                user.error = "Username is required"
            } else if (password.text.toString().isEmpty()){
                password.error = "Password is required"
            } else if (confirmation.text.toString().isEmpty()){
                confirmation.error = "Password confirmation is required"
            } else if (!confirmation.text.toString().equals(password.text.toString())){
                confirmation.error = "Password mismatch"
            } else {
                iSignUp.signUp(user.text.toString(), password.text.toString(), confirmation.text.toString(), signUpView)
            }
        }
    }
}