package com.gondo.chatequipeivoire.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.activities.ChatActivity
import com.gondo.chatequipeivoire.models.AmisModel
import com.google.android.material.imageview.ShapeableImageView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AmisAdapter: RecyclerView.Adapter<AmisAdapter.ViewHolder>() {

    var items:MutableList<AmisModel> = mutableListOf()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_ami,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val amis=items[position];
        holder.bindAmis(amis)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val ivAmis:ShapeableImageView=itemView.findViewById(R.id.iv_amis)
        val tvNom:TextView=itemView.findViewById(R.id.tv_nom)
        val tvDerniserSms:TextView=itemView.findViewById(R.id.tv_dernier_sms)
        val tvHeure:TextView=itemView.findViewById(R.id.tv_heure)

        fun bindAmis(amisModel: AmisModel){
            tvNom.text = amisModel.nom
            tvDerniserSms.text=amisModel.dernierSms
            val sdf=SimpleDateFormat("HH:mm", Locale.getDefault())
            tvHeure.text=sdf.format(Date(amisModel.heure))
            itemView.setOnClickListener{
                Intent(itemView.context,ChatActivity::class.java).also {
                    it.putExtra("amis",amisModel.nom)
                    itemView.context.startActivity(it)
                }
            }
        }

    }

}