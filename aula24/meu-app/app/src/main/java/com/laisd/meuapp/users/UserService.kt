package com.laisd.meuapp.users

import java.lang.Exception

class UserService {
    companion object {

        val users = arrayListOf<UserModel>()

        /**
         * Realiza login
         */
        fun logIn(username: String, password: String): UserModel? {
            return users.find {
                it.username == username.toLowerCase().trim() && it.password == password
            }
        }

        /**
         * Registra um usuário
         */
        fun register(username: String, password: String) {
            // Verifica se já existe usuário com email cadastrado
            val user = users.find {
                it.username == username.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("This username already exists")
            }

            users.add(UserModel(username.toLowerCase(), password))
        }
    }
}