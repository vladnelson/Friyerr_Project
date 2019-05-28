package com.example.friyerr_mobile.service.RequestApi

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.view.ui.Activity.FriyerrLoginActivity
import com.example.friyerr_mobile.view.ui.Activity.MainActivity
import com.example.friyerr_mobile.view.ui.Activity.PresentationActivity
import com.facebook.login.widget.LoginButton
import kotlinx.android.synthetic.main.activity_login.view.*
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

internal class PostRequestLoginFacebook(val Context: Activity) : AsyncTask<String, String, Boolean>() {

    val btnLFB = Context.findViewById<LoginButton>(R.id.Login_buttonFacebook)

    val PrBFB = Context.findViewById<ProgressBar>(R.id.ProgressbarFacebooForLogin)

    val txtFB = Context.findViewById<TextView>(R.id.TxtInFacebookForLogin)

    override fun onPreExecute() {
        txtFB.layoutParams = LinearLayout.LayoutParams(0, 0)

        PrBFB.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        PrBFB.visibility = View.VISIBLE
    }

    override fun doInBackground(vararg params: String?): Boolean {
        var isLoginFB = false

        Log.d(FriyerrLoginActivity.TAG, "Lancement du recherche de token")

        var conn: HttpURLConnection?
        conn =
            URL(PresentationActivity.URLAPI + PresentationActivity.UrlApiLoginFacebook).openConnection() as HttpURLConnection
        conn.requestMethod = PresentationActivity.MethodePOST
        conn.readTimeout = PresentationActivity.RequestTimeOut
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8")


        var postData: ByteArray = params[0]!!.toByteArray(StandardCharsets.UTF_8)
        Log.e(FriyerrLoginActivity.TAG, params[0].toString())
        try {
            conn.connect()

            val out = DataOutputStream(conn.outputStream)
            out.write(postData)

            try {
                out.flush()

            } catch (e: IOException) {

                Log.e(FriyerrLoginActivity.TAG, e.message)
            } finally {
                out.close()
            }


            //---------------------------------------------------
            // Récupération des données
            //---------------------------------------------------
            try {

                val br = BufferedReader(
                    InputStreamReader(
                        conn.inputStream, "UTF-8"
                    )
                )

                //---------------------------------------------------
                // Vérification des résultats
                //---------------------------------------------------
                if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                    Log.d(FriyerrLoginActivity.TAG, "Good")
                    isLoginFB = true

                    var output: String?
                    output = br.readLine()

                    if (output != null) {
                        //  var json =Gson()
                        //  var response = TokenVM()
                        // response = json.fromJson(output,TokenVM::class.java)
                        val sharedPreference =
                            Context.getSharedPreferences(PresentationActivity.PreferenceName, params[1]!!.toInt())
                        var editor = sharedPreference.edit()
                        editor.putString("TOJENJson", output)
                        editor.commit()
                        Log.d(FriyerrLoginActivity.TAG, sharedPreference.getString("TOJENJson", null))
                        isLoginFB = true
                    }

                } else {
                    Log.e(FriyerrLoginActivity.TAG, conn.responseMessage)
                    isLoginFB = false
                }

            } catch (e: IOException) {
                Log.e(FriyerrLoginActivity.TAG, e.message)
                e.printStackTrace()
            } catch (e: IllegalStateException) {
                Log.e(FriyerrLoginActivity.TAG, e.message)
                e.printStackTrace()
            }

        } catch (e: IOException) {

        }



        return isLoginFB
    }

    override fun onPostExecute(result: Boolean) {
        Log.d(FriyerrLoginActivity.TAG, "J'ai fini")

        if (result) {
            Context.startActivity(Intent(Context, MainActivity::class.java))
            Context.finish()
        } else {
            PrBFB.layoutParams = LinearLayout.LayoutParams(0, 0)
            txtFB.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            btnLFB.visibility = View.VISIBLE
        }

    }

}
