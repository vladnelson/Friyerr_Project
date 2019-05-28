package com.example.friyerr_mobile.view.ui.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.activity_forgot_password.*


class FriyerrForgotPasswordActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        BtnInForgotPasswordForCancel.setOnClickListener{
            finish()
        }
    }
}