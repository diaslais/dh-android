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
import com.laisd.meuapp.users.UserService
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.w3c.dom.Text
import java.lang.Exception

class MainActivity : AppCompatActivity(), ILogIn, ISignUp {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun signUp(username: String, password: String, confirm: String, view: View) {
        try{
            UserService.register(username, password)
            Snackbar.make(view, "Username successfully created", Snackbar.LENGTH_LONG).show()
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun logIn(username: String, password: String) {
        val login = UserService.logIn(username, password)
        if (login != null) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show()
        }
    }
}