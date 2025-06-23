package com.gondo.chatequipeivoire.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.gondo.chatequipeivoire.R
import com.gondo.chatequipeivoire.models.UserModel

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>(), Filterable {

    var items:MutableList<UserModel> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            usersFiltrer=value
            notifyDataSetChanged()
        }

    private var usersFiltrer:MutableList<UserModel> = mutableListOf()

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraints: CharSequence?): FilterResults {
                val motRechercher=constraints.toString()
                if (motRechercher.isEmpty()){
                    usersFiltrer=items
                }else{
                    val resultList = items.filter{it.nomPrenom.lowercase().contains(motRechercher.lowercase())}
                    usersFiltrer=resultList as MutableList<UserModel>
                }
                val filterResult=FilterResults()
                filterResult.values=usersFiltrer
                return filterResult
            }

            override fun publishResults(constraints: CharSequence?, results: FilterResults?) {
                usersFiltrer=results?.values as MutableList<UserModel>
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user=usersFiltrer[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int=usersFiltrer.size

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvShortName:TextView=itemView.findViewById(R.id.tv_short_name)
        val tvNomPrenom:TextView=itemView.findViewById(R.id.tv_nom_prenom)
        fun bind(user:UserModel){
            tvNomPrenom.text=user.nomPrenom
            tvShortName.text=user.nomPrenom[0].toString().uppercase()
        }
    }

}