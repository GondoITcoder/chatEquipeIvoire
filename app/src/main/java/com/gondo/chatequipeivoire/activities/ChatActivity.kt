package com.gondo.chatequipeivoire.activities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.adapters.ChatAdapter
import com.gondo.chatequipeivoire.models.MessageModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity : AppCompatActivity() {
    private lateinit var fabEnvoyerMsg:FloatingActionButton
    private lateinit var edMsg:EditText
    private lateinit var rvChatList:RecyclerView
    private lateinit var chatAdapter:ChatAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        fabEnvoyerMsg=findViewById(R.id.fab_envoyer_msg)
        edMsg=findViewById(R.id.ed_msg)
        rvChatList=findViewById(R.id.rv_chat_list)
        chatAdapter=ChatAdapter()

        val nomSender=intent.getStringExtra("amis")
        supportActionBar?.title = nomSender ?: "ChatEquipeIvoire"

        val messageList = mutableListOf<MessageModel>(
            MessageModel("Saly Kone","Gondo Eric","Petit yacouba",45678990,true),
            MessageModel("Saly Kone","Gondo Eric","Comment tu vas ??",45678992,true),
            MessageModel("Eric Gondo","Saly Kone","Dieu fais grace ca vas !",45678994,false),
            MessageModel("Eric Gondo","Saly Kone","Et chez toi ??",45678995,false),
            MessageModel("Saly Kone","Gondo Eric","Ca vas on se plaint pas",45678997,true),
            MessageModel("Saly Kone","Gondo Eric","Soit a l'heure demain",45678998,true),
        )

        fabEnvoyerMsg.setOnClickListener{
            val message=edMsg.text.toString()
            if (message.isNotEmpty()){
                messageList.add(MessageModel("Eric Gondo","Saly Kone",message,System.currentTimeMillis(),false))
                chatAdapter.notifyDataSetChanged()
                edMsg.text.clear()
                //Fermer le clavier
                val inputMethodManager=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(edMsg.windowToken,0)
            }
        }

        chatAdapter.items=messageList

        rvChatList.apply {
            layoutManager=LinearLayoutManager(this@ChatActivity )
            adapter=chatAdapter
        }

    }
}