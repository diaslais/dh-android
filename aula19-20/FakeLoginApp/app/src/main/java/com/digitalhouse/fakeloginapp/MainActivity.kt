package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (email.isEmpty()){
                edtEmail.error = "O e-mail deve ser preenchido."
            } else if(password.isEmpty()){
                edtPassword.error = "O password deve ser preenchido."
            } else {
                val usuario = UserService.logIn(email, password)
                if (usuario == null){
                    Toast.makeText(this, "E-mail ou password inválidos.", Toast.LENGTH_LONG).show()
                } else {
                    val intent = Intent(this, Welcome::class.java)
                    intent.putExtra("NAME", usuario.name)
                    startActivity(intent)
                }
            }
        }
    }
}