package com.example.friyerr_mobile.view.ui.Activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.transition.Visibility
import android.transition.VisibilityPropagation
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.service.RequestApi.PostRequestRegister
import com.example.friyerr_mobile.viewmodel.Account.Register
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets


class FriyerrRegisterActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "Register"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        BtnInRegisterForCancel.setOnClickListener {
            finish()
        }

        BtnInRegisterForRegister.setOnClickListener { view ->
            BtnInRegisterForRegister.isClickable = false

            if (!isConnected()) {
                Snackbar.make(view, "CONNECTION LOST!", Snackbar.LENGTH_LONG).show()
                BtnInRegisterForRegister.isClickable = true
                return@setOnClickListener
            }


            var EmailString = EitInRegisterForEmail.text.toString()
            var PseudoString = EitInRegisterForPseudo.text.toString()
            var PasswordString = EitInRegisterForPassword.text.toString()
            var PasswordAgainString = EitInRegisterForConfirmPassword.text.toString()



            if (EmailString.trim() == "" || PseudoString.trim() == "" || PasswordString.trim() == "" || PasswordAgainString.trim() == "") {
                if (EmailString.trim() == "") {

                }

                if (PseudoString.trim() == "") {

                }

                if (PasswordString.trim() == "") {

                }

                if (PasswordAgainString.trim() == "") {

                }
                BtnInRegisterForRegister.isClickable = true
                Toast.makeText(applicationContext, "VERIFIER VOS CHAMPS , SVP", Snackbar.LENGTH_LONG).show()
            } else {
                var RegisterInformation = Register(PseudoString, EmailString, PasswordString, PasswordAgainString)
                //---------------------------------------------------
                // Entrer les valeurs en JSON
                //---------------------------------------------------
                val RegisterInformationJson = JSONObject()
                RegisterInformationJson.put("Name", "Inconnu")
                RegisterInformationJson.put("Firstname", "Inconnu")
                RegisterInformationJson.put("Pseudo", RegisterInformation.pseudoRegister)
                RegisterInformationJson.put("Email", RegisterInformation.emailRegister)
                RegisterInformationJson.put("Password", RegisterInformation.passwordRegister)
                RegisterInformationJson.put("ConfirmPassword", RegisterInformation.passwordAgainRegister)


                var LoginnformationXwwwFormUnlencoded: StringBuilder = StringBuilder()

                LoginnformationXwwwFormUnlencoded.append("username")
                LoginnformationXwwwFormUnlencoded.append("=")
                LoginnformationXwwwFormUnlencoded.append(RegisterInformation.emailRegister)
                LoginnformationXwwwFormUnlencoded.append("&")
                LoginnformationXwwwFormUnlencoded.append("password")
                LoginnformationXwwwFormUnlencoded.append("=")
                LoginnformationXwwwFormUnlencoded.append(RegisterInformation.passwordRegister)
                LoginnformationXwwwFormUnlencoded.append("&")
                LoginnformationXwwwFormUnlencoded.append("grant_type=password")


                PostRequestRegister(this).execute(
                    RegisterInformationJson.toString(),
                    LoginnformationXwwwFormUnlencoded.toString(),
                    Context.MODE_PRIVATE.toString()
                )
            }
        }
    }

    fun isConnected(): Boolean {
        var connectivityManager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var networkInfo: NetworkInfo = connectivityManager.getActiveNetworkInfo()
        return networkInfo != null && networkInfo.isConnected()
    }
}

