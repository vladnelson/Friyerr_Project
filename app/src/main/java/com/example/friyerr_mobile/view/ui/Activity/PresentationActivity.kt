package com.example.friyerr_mobile.view.ui.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.friyerr_mobile.R
import kotlinx.android.synthetic.main.activity_presentation.*
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.io.InputStream


class PresentationActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "PresentationActivity"
        //-------------------------------------------------------------------------------
        // URL Acces API
        //-------------------------------------------------------------------------------
        val URLAPI: String = "http://vladnels-001-site1.htempurl.com/"
        val UrlApiLogin: String = "token"
        val UrlApiRegister: String = "api/Account/Register"
        val UrlApiLogout: String = "api/Account/Logout"
        val UrlApiLoginFacebook : String = "api/Account/FacebookLogin"
        //-------------------------------------------------------------------------------
        // Share Préférence
        //-------------------------------------------------------------------------------
        val PreferenceName: String = "ACCOUNT"
        val PreferenceToken: String = "TOJENJson"
        val PreferenceLastUser: String = "LastMailUser"

        //-------------------------------------------------------------------------------
        // Configuration request
        //-------------------------------------------------------------------------------
        val RequestTimeOut: Int = 30000

        //-------------------------------------------------------------------------------
        // Méthode
        //-------------------------------------------------------------------------------
        val MethodePOST = "POST"
        val MethodeGET = "GET"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()

        setContentView(R.layout.activity_presentation)
        Thread(Runnable { startupapps() }).start()
    }

    fun startupapps() {
        //animation_test.startAnimation()
        try {
            var inputstream: InputStream = this.assets.open("friyerr_f.gif")
            var byte: ByteArray = IOUtils.toByteArray(inputstream)
            LogGif.setBytes(byte)
            LogGif.startAnimation()
        } catch (ex: IOException) {
            Log.e(TAG, "Erreur with Animation ")
        }

        try {

            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val sharedPreference = getSharedPreferences(PreferenceName, Context.MODE_PRIVATE)


        // A RETIRER
        // var editor = sharedPreference.edit()
        // editor.remove(PresentationActivity.PreferenceToken)
        //editor.commit()

        var AccountToken: String? = sharedPreference.getString(PreferenceToken, null)

        if (AccountToken == null) {
            startActivity(Intent(this, FriyerrLoginActivity::class.java))

        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}