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
import com.example.friyerr_mobile.view.ui.Activity.PresentationActivity
import com.example.friyerr_mobile.view.ui.Fragment.ProfileFragment
import com.example.friyerr_mobile.viewmodel.Profil.TokenVM
import com.facebook.login.LoginManager
import com.google.gson.Gson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

internal class PostRequestLogout(val Context: View, var ContextParent: Activity?) :
    AsyncTask<String, String, Boolean>() {

    var txtLogout = Context.findViewById<TextView>(R.id.txtLogoutForInformation)
    val btn = Context.findViewById<LinearLayout>(R.id.BtnLogoutForInformation)
    val PBLogout = Context.findViewById<ProgressBar>(R.id.ProgressbarLogoutForInformation)

    override fun onPreExecute() {
        txtLogout.layoutParams = LinearLayout.LayoutParams(0, 0)
        PBLogout.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        PBLogout.visibility = View.VISIBLE
    }

    override fun doInBackground(vararg params: String?): Boolean {
        var IsLogout = false


        val sharedPreference = ContextParent!!.getSharedPreferences(
            PresentationActivity.PreferenceName,
            android.content.Context.MODE_PRIVATE
        )

        var AccountToken: String? = sharedPreference.getString(PresentationActivity.PreferenceToken, null)
        var json = Gson()
        var response = TokenVM()
        response = json.fromJson(AccountToken, TokenVM::class.java)

        var conn: HttpURLConnection?
        conn =
            URL(PresentationActivity.URLAPI + PresentationActivity.UrlApiLogout).openConnection() as HttpURLConnection
        conn.requestMethod = PresentationActivity.MethodePOST
        conn.connectTimeout = PresentationActivity.RequestTimeOut


        Log.e(ProfileFragment.TAG, response.token_type + " " + response.access_token)

        conn.setRequestProperty("Authorization", response.token_type + " " + response.access_token)
        conn.setRequestProperty("Content-Type", "application/json")

        try {
            conn.connect()

            /*
        val out = DataOutputStream(conn.outputStream)
        out.writeBytes(params[0])
        try {
            out.flush()
        } catch (e: IOException) {
            Log.e(InformationFragment.TAG, e.message)
        } finally {
            out.close()
        }*/

            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                Log.d(ProfileFragment.TAG, "Logout Sucess !!!")
                IsLogout = true
            } else {
                Log.e(ProfileFragment.TAG, conn.responseMessage)
                IsLogout = false
            }

        } catch (e: IOException) {
            Log.e(ProfileFragment.TAG, e.message)
        } finally {
            conn?.disconnect()
        }
        return IsLogout
    }

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Boolean) {
        LoginManager.getInstance().logOut()
        val sharedPreference = ContextParent!!.getSharedPreferences(
            PresentationActivity.PreferenceName,
            android.content.Context.MODE_PRIVATE
        )


        var AccountToken: String? = sharedPreference.getString(PresentationActivity.PreferenceToken, null)
        var json = Gson()
        var response = TokenVM()
        response = json.fromJson(AccountToken, TokenVM::class.java)


        var editor = sharedPreference.edit()

        editor.putString(PresentationActivity.PreferenceLastUser, response.userName)


        editor.remove(PresentationActivity.PreferenceToken)
        editor.commit()

        ContextParent!!.startActivity(Intent(ContextParent, FriyerrLoginActivity::class.java))
        ContextParent!!.finish()
    }
}