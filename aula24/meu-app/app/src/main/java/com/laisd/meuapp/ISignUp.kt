package com.laisd.meuapp

import android.view.View

interface ISignUp {
    fun signUp(username: String, password: String, confirm: String, view: View)
}