package com.ediga.mvvmloginsample

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    var loginStatus = MutableLiveData<String>()


    fun doLogin(userName: String?, password: String?) {
        val userModel = UserModel(userName, password)
        val code: Int? = userName?.let { password?.let { it1 ->
            userModel.checkUserValidity(it,
                it1
            )
        } }
        println("@Code $code")
        Handler().postDelayed(Runnable {
            val msg: String
            msg = if (code == 0) {
                "Login Successful"
            } else {
                "Login Fail"
            }
            println("@LOGIN: $msg")
            loginStatus.postValue(msg)
        }, 2000)
    }
}