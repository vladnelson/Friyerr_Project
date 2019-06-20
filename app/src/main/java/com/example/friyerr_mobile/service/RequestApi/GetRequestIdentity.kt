package com.example.friyerr_mobile.service.RequestApi

import android.app.Activity
import android.os.AsyncTask
import android.util.Log
import android.view.View
import com.example.friyerr_mobile.view.ui.activity.PresentationActivity
import com.example.friyerr_mobile.viewmodel.Profil.TokenVM
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

internal class GetRequestIdentity( var ContextParent:Activity , var TAG :String) : AsyncTask<String,String,Boolean>(){


    override fun onPreExecute() {

    }


    override fun doInBackground(vararg params: String?): Boolean {
        Log.d(TAG, "Je vais aller charger des informations pour login")

        var IsGetIdentity = false


        val sharedPreference = ContextParent!!.getSharedPreferences(
            PresentationActivity.PreferenceName,
            android.content.Context.MODE_PRIVATE
        )

        var AccountToken: String? = sharedPreference.getString(PresentationActivity.PreferenceToken, null)
        var json = Gson()
        var response = TokenVM()
        response = json.fromJson(AccountToken, TokenVM::class.java)


        var conn : HttpURLConnection?
        conn = URL(PresentationActivity.URLAPI+PresentationActivity.UrlApiIdentity).openConnection() as HttpURLConnection
        conn.requestMethod=PresentationActivity.MethodeGET
        conn.connectTimeout=PresentationActivity.RequestTimeOut
        conn.setRequestProperty("Content-Type","application/json")
        conn.setRequestProperty("Authorization", response.token_type + " " + response.access_token)

        try {
            conn.connect()


            val br = BufferedReader(InputStreamReader(conn.inputStream,PresentationActivity.UTF8))

            if(conn.responseCode == HttpURLConnection.HTTP_OK){
                Log.d(TAG, "Good")
                IsGetIdentity = true

                var output: String?
                output =br.readLine()
                if (output !=  null){

                    var editor =  sharedPreference.edit()
                    editor.putString(PresentationActivity.PreferenceUser,output)
                    editor.commit()
                }

            }else{
                IsGetIdentity=false
            }


        }catch (e: IOException){
            Log.e(TAG, e.message)
            e.printStackTrace()
        }

        return  IsGetIdentity
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }

}