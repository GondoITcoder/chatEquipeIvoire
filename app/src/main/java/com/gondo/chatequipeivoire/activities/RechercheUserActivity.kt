package com.gondo.chatequipeivoire.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.adapters.AmisAdapter
import com.gondo.chatequipeivoire.adapters.UserAdapter
import com.gondo.chatequipeivoire.models.UserModel

class RechercheUserActivity : AppCompatActivity() {
    private lateinit var edRecherche:EditText
    private lateinit var rvUsers:RecyclerView
    private lateinit var userAdapter:UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_user)
        edRecherche=findViewById(R.id.ed_recherche)
        rvUsers=findViewById(R.id.rv_users)
        val usersList= mutableListOf<UserModel>(
            UserModel("saly@gmail.com","Saly Kone",""),
            UserModel("Soro@gmail.com","Soro Abou Antoine",""),
            UserModel("banh@gmail.com","Banh Kapeu Armand",""),
            UserModel("traore@gmail.com","Traore Aminata",""),)

        userAdapter= UserAdapter()
        userAdapter.items=usersList
        rvUsers.apply {
            layoutManager= LinearLayoutManager(this@RechercheUserActivity)
            adapter=userAdapter
        }

        edRecherche.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userAdapter.filter.filter(s.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }
}