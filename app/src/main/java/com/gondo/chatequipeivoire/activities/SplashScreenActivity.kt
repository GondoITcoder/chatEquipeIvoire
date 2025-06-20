package com.gondo.chatequipeivoire.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.gondo.chatequipeivoire.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Aller sur la page AuthentificationActivity
        //Methode 1
        /*val homeIntent= Intent(this,AuthentificationActivity::class.java)
        startActivity(homeIntent)*/
        //Methode 2
        //Ajouter un moniteur
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this,AuthentificationActivity::class.java).also {
                startActivity(it)
            }
            finish()
        },3000)


    }
}