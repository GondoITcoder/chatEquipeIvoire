package com.gondo.chatequipeivoire.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gondo.chatequipeivoire.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AuthentificationActivity : AppCompatActivity() {
    lateinit var tvRegister:TextView
    lateinit var edEmail:TextInputLayout
    lateinit var edPassord:TextInputLayout
    lateinit var btnConnecter:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        tvRegister=findViewById(R.id.tv_register)
        edEmail=findViewById(R.id.ed_email)
        edPassord=findViewById(R.id.ed_passord)
        btnConnecter=findViewById(R.id.btn_connecter)

        tvRegister.setOnClickListener {
            Intent(this,RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        btnConnecter.setOnClickListener{
            edEmail.isErrorEnabled=false
            edPassord.isErrorEnabled=false
            val email=edEmail.editText?.text.toString()
            val password=edPassord.editText?.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                if (email.isEmpty()){
                    edEmail.error="Email obligatoire!"
                    edEmail.isErrorEnabled=true
                }
                if (password.isEmpty()){
                    edPassord.error="Mot de passe obligatoire!"
                    edPassord.isErrorEnabled=true
                }
            }else{
                login(edEmail.editText.toString(),edPassord.editText.toString())
            }
        }

    }

    fun login(email:String,pass:String){
        Log.d("login","Conenxion en cour ...")
        Intent(this,HomeActivity::class.java).also {
            finish()
            startActivity(it)
        }
    }

}