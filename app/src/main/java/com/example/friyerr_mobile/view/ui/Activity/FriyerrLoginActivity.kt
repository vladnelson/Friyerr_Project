package com.example.friyerr_mobile.view.ui.Activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.activity_login.*
import android.graphics.Paint
import android.opengl.Visibility
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.*
import com.example.friyerr_mobile.service.RequestApi.PostRequestLogin
import com.example.friyerr_mobile.service.RequestApi.PostRequestLoginFacebook
import com.example.friyerr_mobile.viewmodel.Account.LoginVM
import com.facebook.*
import com.facebook.login.LoginResult
import org.json.JSONObject
import kotlin.math.log


class FriyerrLoginActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "LoginActivity"
    }

    private var callbackManager: CallbackManager? = null

    private var activity: Activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreference = this.getSharedPreferences(
            PresentationActivity.PreferenceName,
            Context.MODE_PRIVATE
        )

        var AccountEmail: String? = sharedPreference.getString(PresentationActivity.PreferenceLastUser, null)

        Log.d(TAG, AccountEmail)
        if (AccountEmail != null) {
            EitInLoginForEmail.setText(AccountEmail)
            EitInLoginForPassword.requestFocus()
        } else {
            EitInLoginForEmail.requestFocus()
        }


        txtInLoginForVRegister.setOnClickListener {
            startActivityForResult(Intent(this, FriyerrRegisterActivity::class.java), 2)
        }

        txtVInLoginForForgotPassword.setOnClickListener {
            startActivityForResult(Intent(this, FriyerrForgotPasswordActivity::class.java), 2)
        }

        txtVInLoginForForgotPassword
            .paintFlags = txtVInLoginForForgotPassword.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        BtnInLoginForLogin.setOnClickListener {
            BtnInLoginForLogin.isClickable = false
            var loginString = EitInLoginForEmail.text.toString()
            var passwordString = EitInLoginForPassword.text.toString()

            if (loginString.trim() == "" || passwordString.trim() == "") {
                TxtInLoginForError.text = "Your email or your password is not valid. Retry again please."
                TxtInLoginForError.visibility = View.VISIBLE
                // Toast.makeText(applicationContext, "VERIFIER VOS CHAMPS , SVP", Snackbar.LENGTH_LONG).show()
                BtnInLoginForLogin.isClickable = true
            } else {
                TxtInLoginForError.visibility = View.INVISIBLE
                var LoginInformation = LoginVM(loginString, passwordString)
                //---------------------------------------------------
                // Entrer les valeurs en JSON
                //---------------------------------------------------
                var LoginnformationXwwwFormUnlencoded: StringBuilder = StringBuilder()

                LoginnformationXwwwFormUnlencoded.append("username")
                LoginnformationXwwwFormUnlencoded.append("=")
                LoginnformationXwwwFormUnlencoded.append(LoginInformation.login)
                LoginnformationXwwwFormUnlencoded.append("&")
                LoginnformationXwwwFormUnlencoded.append("password")
                LoginnformationXwwwFormUnlencoded.append("=")
                LoginnformationXwwwFormUnlencoded.append(LoginInformation.passwordLogin)
                LoginnformationXwwwFormUnlencoded.append("&")
                LoginnformationXwwwFormUnlencoded.append("grant_type=password")

                Log.d(TAG, LoginnformationXwwwFormUnlencoded.toString())
                PostRequestLogin(this).execute(
                    LoginnformationXwwwFormUnlencoded.toString(),
                    Context.MODE_PRIVATE.toString()
                )
            }
        }

        BtnInLoginForLoginFacebook.setOnClickListener {
            Login_buttonFacebook.callOnClick()
        }

        callbackManager = CallbackManager.Factory.create()

        Login_buttonFacebook.setReadPermissions("email")


        Login_buttonFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                //---------------------------------------------------
                // Entrer les valeurs en JSON
                //---------------------------------------------------
                val LoginFacebookInformationJson = JSONObject()
                LoginFacebookInformationJson.put("userid", loginResult.accessToken.userId)
                LoginFacebookInformationJson.put("token", loginResult.accessToken.token.toString())
                LoginFacebookInformationJson.put("username", "")
                LoginFacebookInformationJson.put("firstname", "")
                LoginFacebookInformationJson.put("lastname", "")


                Log.d("FBLOGIN", loginResult.accessToken.token.toString())
                //   Log.d("FBLOGIN", loginResult.accessToken.userId)

                //   Log.d("FBLOGIN", loginResult.recentlyDeniedPermissions.toString())
                //  Log.d("FBLOGIN", loginResult.recentlyGrantedPermissions.toString())

                /* Log.d("FBLOGIN", loginResult.accessToken.applicationId)
                 Log.d("FBLOGIN", loginResult.accessToken.dataAccessExpirationTime.toString())
                 Log.d("FBLOGIN", loginResult.accessToken.permissions.toString())
                 Log.d("FBLOGIN", loginResult.accessToken.expires.toString())
                 Log.d("FBLOGIN", loginResult.accessToken.lastRefresh.toString())
                 Log.d("FBLOGIN", loginResult.accessToken.source.name)
 */
                Log.d(TAG, "envoie request")
                PostRequestLoginFacebook(activity).execute(
                    LoginFacebookInformationJson.toString(),
                    Context.MODE_PRIVATE.toString()
                )


                /*  val request = GraphRequest.newMeRequest(loginResult.accessToken) { `object`, response ->
                      try {
                          //here is the data that you want
                          Log.d("FBLOGIN_JSON_RES", `object`.toString())

                          if (`object`.has("id")) {
                             //handleSignInResultFacebook(`object`)
                          } else {
                              Log.e("FBLOGIN_FAILD", `object`.toString())
                          }

                      } catch (e: Exception) {
                          e.printStackTrace()
                          //dismissDialogLogin()
                      }
                  }

                  val parameters = Bundle()
                  parameters.putString("fields", "name,email,id,picture.type(large)")
                  request.parameters = parameters
                  request.executeAsync()*/

            }

            override fun onCancel() {
                Log.e("FBLOGIN_FAILD", "Cancel")
            }

            override fun onError(error: FacebookException) {
                Log.e("FBLOGIN_FAILD", "ERROR", error)
            }
        })
    }


    /**
     * Attente du résultat de l'inscription
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        val sharedPreference = getSharedPreferences(PresentationActivity.PreferenceName, Context.MODE_PRIVATE)

        var AccountToken: String? = sharedPreference.getString(PresentationActivity.PreferenceToken, null)

        Log.d(TAG, "RCode= " + requestCode + " ,  resultCode= " + resultCode)
        Log.d(TAG, AccountToken)


        if (AccountToken != null) {

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

