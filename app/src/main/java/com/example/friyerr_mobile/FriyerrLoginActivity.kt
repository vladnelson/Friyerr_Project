package com.example.friyerr_mobile

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class FriyerrLoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtInLoginForVRegister.setOnClickListener {
            startActivity(Intent(this,FriyerrRegisterActivity::class.java))
        }

        txtVInLoginForForgotPassword.setOnClickListener {
            startActivity(Intent(this,FriyerrForgotPasswordActivity::class.java))
        }

        BtnInLoginForLogin.setOnClickListener{
            //  Snackbar.make(view, "Lunch Maps", Snackbar.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}