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
import com.example.friyerr_mobile.view.ui.Activity.FriyerrRegisterActivity
import com.example.friyerr_mobile.view.ui.Activity.PresentationActivity
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets


internal class PostRequestRegister(val Context: Activity) : AsyncTask<String, String, Boolean>() {
    val TxtRegister = Context.findViewById<TextView>(R.id.TxtInRegisterForRegister)
    val PBRegister = Context.findViewById<ProgressBar>(R.id.ProgressbarRegisterForRegister)
    val btn = Context.findViewById<LinearLayout>(R.id.BtnInRegisterForRegister)


    //  val EMAIL = Context.findViewById<EditText>(R.id.EitInRegisterForEmail)
    // val PASSWORD = Context.findViewById<EditText>(R.id.EitInRegisterForPassword)


    //---------------------------------------------------
    //Avant l'envoie de la requete
    //---------------------------------------------------
    override fun onPreExecute() {
        TxtRegister.layoutParams = LinearLayout.LayoutParams(0, 0)
        PBRegister.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        PBRegister.visibility = View.VISIBLE
    }


    //---------------------------------------------------
    // Execution de la requete
    //---------------------------------------------------
    override fun doInBackground(vararg params: String?): Boolean {
        var isRegister = false

        var conn: HttpURLConnection?
        conn =
            URL(PresentationActivity.URLAPI + PresentationActivity.UrlApiRegister).openConnection() as HttpURLConnection
        conn.requestMethod = PresentationActivity.MethodePOST
        conn.connectTimeout = PresentationActivity.RequestTimeOut
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8")

        try {
            conn.connect()

            val out = DataOutputStream(conn.outputStream)
            out.writeBytes(params[0])
            try {
                out.flush()
            } catch (e: IOException) {
                Log.e(FriyerrRegisterActivity.TAG, e.message)
            } finally {
                out.close()
            }

            //---------------------------------------------------
            // Vérification des résultats
            //---------------------------------------------------
            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                Log.d(FriyerrRegisterActivity.TAG, "Register Sucess !!!")
                isRegister = true
            } else {
                Log.e(FriyerrRegisterActivity.TAG, conn.responseMessage)
                isRegister = false
            }

        } catch (e: IOException) {
            Log.e(FriyerrRegisterActivity.TAG, e.message)
        } finally {
            conn?.disconnect()
        }


        if (isRegister) {
            var isLogin: Boolean = false

            Log.e(FriyerrRegisterActivity.TAG, "On va chercher  un token login now")
            var connLogin =
                URL(PresentationActivity.URLAPI + PresentationActivity.UrlApiLogin).openConnection() as HttpURLConnection
            connLogin.requestMethod = "POST"
            connLogin.connectTimeout = 300000
            // conn.useCaches =false
            //  conn.doInput=true
            // conn.doOutput=true
            connLogin.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")


            var postDataLogin: ByteArray = params[1]!!.toByteArray(StandardCharsets.UTF_8)
            try {
                connLogin.connect()

                val outLogin = DataOutputStream(connLogin.outputStream)
                outLogin.write(postDataLogin)
                try {
                    outLogin.flush()

                } catch (e: IOException) {

                    Log.e(FriyerrRegisterActivity.TAG, e.message)
                } finally {
                    outLogin.close()
                }


                //---------------------------------------------------
                // Récupération des données
                //---------------------------------------------------
                try {

                    val br = BufferedReader(
                        InputStreamReader(
                            connLogin.inputStream, "UTF-8"
                        )
                    )

                    //---------------------------------------------------
                    // Vérification des résultats
                    //---------------------------------------------------
                    if (connLogin.responseCode == HttpURLConnection.HTTP_OK) {
                        Log.d(FriyerrLoginActivity.TAG, "Good")
                        isLogin = true

                        var output: String?
                        output = br.readLine()

                        if (output != null) {
                            val sharedPreference =
                                Context.getSharedPreferences(PresentationActivity.PreferenceName, params[2]!!.toInt())
                            var editor = sharedPreference.edit()
                            editor.putString("TOJENJson", output)
                            editor.commit()
                        }

                    } else {
                        Log.e(FriyerrRegisterActivity.TAG, connLogin.responseMessage)
                        isLogin = false
                    }

                } catch (e: IOException) {
                    Log.e(FriyerrRegisterActivity.TAG, e.message)
                    e.printStackTrace()
                } catch (e: IllegalStateException) {
                    Log.e(FriyerrRegisterActivity.TAG, e.message)
                    e.printStackTrace()
                }


            } catch (e: IOException) {
                Log.e(FriyerrRegisterActivity.TAG, e.message)
            } finally {
                connLogin?.disconnect()
            }
        }

        return isRegister
    }


    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
    }

    //---------------------------------------------------
    // Apres l'envoie de la requete
    //---------------------------------------------------
    override fun onPostExecute(result: Boolean) {

        if (result) {
            var intent = Intent()
            Context.setResult(2, intent)
            Context.finish()
        } else {
            PBRegister.layoutParams = LinearLayout.LayoutParams(0, 0)
            TxtRegister.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            btn.isClickable = true
        }
    }
}