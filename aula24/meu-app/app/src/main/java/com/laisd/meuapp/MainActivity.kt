package com.laisd.meuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), ILogIn, ISignUp {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //elementos xml do fragment sign in
        val usernameSignIn = findViewById<TextInputLayout>(R.id.txtInputUsernameSIgnIn)
        val passwordSignIn = findViewById<TextInputLayout>(R.id.txtInputPasswordSignIn)
        val btnLogIn = findViewById<Button>(R.id.btnLogInSignIn)

        //elementos xml do fragment sign up
        val usernameSignUp = findViewById<TextInputLayout>(R.id.txtInputUsernameSIgnUp)
        val passwordSignUp = findViewById<TextInputLayout>(R.id.txtInputPasswordSignUp)
        val confirmPasswordSignUp = findViewById<TextInputLayout>(R.id.txtInputConfirmPasswordSignUp)
        val btnSignUp = findViewById<Button>(R.id.btnSignUpSignUp)

        //view pager
        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
            SignIn(), SignUp()
        )
        val titulos = listOf(
            getString(R.string.sign_in), getString(R.string.sign_up)
        )
        pager.adapter = Adapter(fragments, titulos, supportFragmentManager)
    }

    override fun logIn(username: String, password: String) {
        if (username.isEmpty()){
            txtInputUsernameSIgnIn.error = "Username is required"
        } else if (password.isEmpty()){
            txtInputPasswordSignIn.error = "Password is required"
        } else {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun signUp(username: String, password: String, confirm: String, view: View) {
        if (username.isEmpty()){
            txtInputUsernameSIgnUp.error = "Username is required"
        } else if (password.isEmpty()){
            txtInputPasswordSignUp.error = "Password is required"
        } else if (confirm.isEmpty()){
            txtInputConfirmPasswordSignUp.error = "Password confirmation is required"
        } else if (!confirm.equals(password)){
            txtInputConfirmPasswordSignUp.error = "Password mismatch"
        } else {
            Snackbar.make(view, "Username successfully created", Snackbar.LENGTH_LONG).show()
        }
    }

}