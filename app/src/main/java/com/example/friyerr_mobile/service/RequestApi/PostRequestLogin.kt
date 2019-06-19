package com.example.friyerr_mobile.service.RequestApi

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.friyerr_mobile.R
import com.example.friyerr_mobile.view.ui.activity.FriyerrLoginActivity
import com.example.friyerr_mobile.view.ui.activity.MainActivity
import com.example.friyerr_mobile.view.ui.activity.PresentationActivity
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets


/**
 *  Class pour aller chercher des données async
 */
internal class PostRequestLogin(val Context: Activity) : AsyncTask<String, String, Boolean>() {
    val Txt = Context.findViewById<TextView>(R.id.TxtInLoginForLogin)
    val PB = Context.findViewById<ProgressBar>(R.id.ProgressbarLoginForLogin)
    val btn = Context.findViewById<LinearLayout>(R.id.BtnInLoginForLogin)

    val txtPassword = Context.findViewById<EditText>(R.id.EitInLoginForPassword)

    //---------------------------------------------------
    //Avant l'envoie de la requete
    //---------------------------------------------------
    override fun onPreExecute() {
        Txt.layoutParams = LinearLayout.LayoutParams(0, 0)
        PB.layoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        PB.visibility = View.VISIBLE
    }


    //---------------------------------------------------
    // Execution de la requete
    //---------------------------------------------------
    override fun doInBackground(vararg params: String?): Boolean {
        Log.d(FriyerrLoginActivity.TAG, "Je vais aller charger des informations pour login")
        var isRegister = false

        var conn: HttpURLConnection?
        conn = URL(PresentationActivity.URLAPI + PresentationActivity.UrlApiLogin).openConnection() as HttpURLConnection
        conn.requestMethod = PresentationActivity.MethodePOST
        conn.connectTimeout = PresentationActivity.RequestTimeOut
        // conn.useCaches =false
        //  conn.doInput=true
        // conn.doOutput=true
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")


        var postData: ByteArray = params[0]!!.toByteArray(StandardCharsets.UTF_8)
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
                    isRegister = true

                    var output: String?
                    output = br.readLine()

                    if (output != null) {
                        //  var json =Gson()
                        //  var response = TokenVM()
                        // response = json.fromJson(output,TokenVM::class.java)
                        val sharedPreference =
                            Context.getSharedPreferences(PresentationActivity.PreferenceName, params[1]!!.toInt())
                        var editor = sharedPreference.edit()
                        editor.putString(PresentationActivity.PreferenceToken, output)
                        editor.commit()
                        //  Log.d(FriyerrLoginActivity.TAG,sharedPreference.getString ("TOJENJson", null))
                    }

                } else {
                    Log.e(FriyerrLoginActivity.TAG, conn.responseMessage)
                    isRegister = false
                }

            } catch (e: IOException) {
                Log.e(FriyerrLoginActivity.TAG, e.message)
                e.printStackTrace()
            } catch (e: IllegalStateException) {
                Log.e(FriyerrLoginActivity.TAG, e.message)
                e.printStackTrace()
            }


        } catch (e: IOException) {
            Log.e(FriyerrLoginActivity.TAG, e.message)
        } finally {
            conn?.disconnect()
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
            Context.startActivity(Intent(Context, MainActivity::class.java))
            Context.finish()
        } else {
            PB.layoutParams = LinearLayout.LayoutParams(0, 0)
            Txt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            txtPassword.setText("")
            txtPassword.isFocusable = true
            btn.isClickable = true
        }
    }

}
