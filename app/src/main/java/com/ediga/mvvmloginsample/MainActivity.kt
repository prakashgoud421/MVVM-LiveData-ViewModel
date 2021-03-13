package com.ediga.mvvmloginsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private var editUserName: EditText? = null
    private var editPassword: EditText? = null
    private var btnLogin: Button? = null
    var progressBar: ProgressBar? = null

    var loginViewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        btnLogin!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
              loginResult()
            }
        })

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel!!.loginStatus.observe(this, Observer<String?> {

            progressBar?.setVisibility(View.INVISIBLE);
            System.out.println("onChanged: "+it);
        })

    }
    private fun loginResult() {
        progressBar!!.visibility = View.VISIBLE
        val userName = editUserName!!.text.toString()
        val password = editPassword!!.text.toString()
        loginViewModel!!.doLogin(userName, password)
    }
    private fun initUI() {
        editUserName = findViewById(R.id.et_name);
        editPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.bt_submit);
        progressBar = findViewById(R.id.progress_login);
        progressBar!!.visibility = View.INVISIBLE
    }
}