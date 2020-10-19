package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        check2PrivacyPolicy.setOnCheckedChangeListener { _, isChecked ->
            btn2SignUp.isEnabled = isChecked
        }

        btn2LogIn.setOnClickListener {
            finish()
        }

        btn2SignUp.setOnClickListener {
            val name = edt2Name.text.toString()
            val email = edt2Email.text.toString()
            val password = edt2Password.text.toString()
            

            try{
                UserService.register(name, email, password)
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            } catch (e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}