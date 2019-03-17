package com.example.friyerr_mobile

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_presentation.*
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.io.InputStream



class PresentationActivity: AppCompatActivity() {
    private val TAG ="PresentationActivity"
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()

        setContentView(R.layout.activity_presentation)
        Thread(Runnable { startupapps() }).start()
    }

    fun startupapps(){
        //animation_test.startAnimation()
        try {
            var inputstream : InputStream = this.assets.open("friyerr_f.gif")
            var byte : ByteArray = IOUtils.toByteArray(inputstream)
            LogGif.setBytes(byte)
            LogGif.startAnimation()
        }catch( ex: IOException) {
            Log.e(TAG,"Erreur ")
        }


        try {

            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }


        if (true) {
            startActivity(Intent(this, FriyerrLoginActivity::class.java))

        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}