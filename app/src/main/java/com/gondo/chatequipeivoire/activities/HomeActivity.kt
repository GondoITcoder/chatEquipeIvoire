package com.gondo.chatequipeivoire.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.adapters.AmisAdapter
import com.gondo.chatequipeivoire.models.AmisModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    private lateinit var rvAmis:RecyclerView
    private lateinit var fabChat:FloatingActionButton
    private lateinit var amisAdapter:AmisAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvAmis=findViewById(R.id.rv_amis)
        fabChat=findViewById(R.id.fab_chat)

        fabChat.setOnClickListener{

        }

        val amisList= mutableListOf<AmisModel>(
            AmisModel("Saly Kone","Petit yacouba","",12345678),
            AmisModel("Yao Sydney","Bro Ndkw ??","",12345678),
            AmisModel("Koutouglo Abigael","Salut bb","",12345678),
            AmisModel("Banh Armand","Forcement c'est propre","",12345678),
        )

        amisAdapter=AmisAdapter()
        amisAdapter.items=amisList
        rvAmis.apply {
            layoutManager=LinearLayoutManager(this@HomeActivity)
            adapter=amisAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuParam ->Toast.makeText(this,"Parametres clicquer",Toast.LENGTH_SHORT).show()
                /*R.id.menuParam -> Intent(this,ParametreActivity::class.java).also {
                    finish()
                    startActivity(it)
                }*/
            R.id.menuDeconnexion -> Intent(this,AuthentificationActivity::class.java).also {
                finish()
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}