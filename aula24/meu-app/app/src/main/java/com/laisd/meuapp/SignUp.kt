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
    lateinit var signUpView: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iSignUp = context as ISignUp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        signUpView = inflater.inflate(R.layout.fragment_sign_up, container, false)
        signUpClick(signUpView)

        // Esvaziar label de erro no TextInputLayout ao digitar algo
        signUpView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSIgnUp).addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signUpView.findViewById<TextInputLayout>(R.id.txtLayoutUsernameSIgnUp).error = ""
            }
        })
        // Esvaziar label de erro no TextInputLayout ao digitar algo
        signUpView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignUp).addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signUpView.findViewById<TextInputLayout>(R.id.txtLayoutPasswordSignUp).error = ""
            }
        })
        // Esvaziar label de erro no TextInputLayout ao digitar algo
        signUpView.findViewById<TextInputEditText>(R.id.txtEdtConfirmPasswordSignUp).addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signUpView.findViewById<TextInputLayout>(R.id.txtLayoutConfirmPasswordSignUp).error = ""
            }
        })

        return signUpView
    }

    fun signUpClick(signUpView: View){
        val btnSignUp = signUpView.findViewById<Button>(R.id.btnSignUpSignUp)
        val checkBox = signUpView.findViewById<CheckBox>(R.id.checkAgreeSignUp)
        val user = signUpView.findViewById<TextInputEditText>(R.id.txtEdtUsernameSIgnUp)
        val userLayout = signUpView.findViewById<TextInputLayout>(R.id.txtLayoutUsernameSIgnUp)
        val password = signUpView.findViewById<TextInputEditText>(R.id.txtEdtPasswordSignUp)
        val passwordLayout = signUpView.findViewById<TextInputLayout>(R.id.txtLayoutPasswordSignUp)
        val confirmation = signUpView.findViewById<TextInputEditText>(R.id.txtEdtConfirmPasswordSignUp)
        val confirmationLayout = signUpView.findViewById<TextInputLayout>(R.id.txtLayoutConfirmPasswordSignUp)

        checkBox.setOnCheckedChangeListener{ _, isChecked ->
            btnSignUp.isEnabled = isChecked
        }

        btnSignUp.setOnClickListener {
            var taSemErro = true
            if (user.text.toString().isEmpty()){
                userLayout.error = "Username is required"
                taSemErro = false
            }
            if (password.text.toString().isEmpty()){
                passwordLayout.error = "Password is required"
                taSemErro = false
            }
            if (confirmation.text.toString().isEmpty()){
                confirmationLayout.error = "Password confirmation is required"
                taSemErro = false
            }
            if (!confirmation.text.toString().equals(password.text.toString())){
                confirmationLayout.error = "Password mismatch"
                taSemErro = false
            }
            if (taSemErro){
                iSignUp.signUp(user.text.toString(), password.text.toString(), confirmation.text.toString(), signUpView)
            }
        }
    }
}