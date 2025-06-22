package com.gondo.chatequipeivoire.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.models.MessageModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatAdapter:RecyclerView.Adapter<ChatAdapter.ViewHolder>(){

    var items:MutableList<MessageModel> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(viewType,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemViewType(position: Int): Int {

        val res=when(items[position].isReceived){
            true -> R.layout.item_chat_left
            false -> R.layout.item_chat_right
        }

        return res
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val message=items[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int =items.size

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val tvMessage:TextView=itemView.findViewById(R.id.tv_msg)
        val tvHeure:TextView=itemView.findViewById(R.id.tv_heure)

        fun bind(message:MessageModel){
            tvMessage.text=message.text
            val sdf= SimpleDateFormat("HH:mm", Locale.getDefault())
            tvHeure.text=sdf.format(Date(message.heure))
        }

    }

}