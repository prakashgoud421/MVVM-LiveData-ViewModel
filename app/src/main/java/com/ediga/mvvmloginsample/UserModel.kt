package com.ediga.mvvmloginsample

class UserModel(userName: String?, password: String?) {
    private var username: String? = userName
    private var password: String? = password

    fun getUsername(): String? {
        return username
    }

    fun getPassword(): String? {
        return password
    }

    fun checkUserValidity(username: String, password: String): Int {
        return if (username.trim { it <= ' ' } == "" || password.trim { it <= ' ' } == "") {
            -1
        } else {
            0
        }
    }
}
