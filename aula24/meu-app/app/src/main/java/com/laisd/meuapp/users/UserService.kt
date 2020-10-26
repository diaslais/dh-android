package com.laisd.meuapp.users

import java.lang.Exception

class UserService {
    companion object {

        private val users = arrayListOf<UserModel>()

        /**
         * Realiza login
         */
        fun logIn(email: String, password: String): UserModel? {
            return users.find {
                it.email == email.toLowerCase().trim() && it.password == password
            }
        }

        /**
         * Registra um usuário
         */
        fun register(name: String, email: String, password: String) {
            // Verifica se já existe usuário com email cadastrado
            val user = users.find {
                it.email == email.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("This e-mail already exists")
            }

            users.add(UserModel(name, email.toLowerCase().trim(), password))
        }
    }
}