package com.example.contactapp.DataClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactapp.R
import com.example.contactapp.databinding.ContactItemViewBinding

class Adapter(var contactList: List<Contact>): RecyclerView.Adapter<Adapter.ContactViewHolder>() {
    var oncontactItemClickListener:onContactItemClickListener?=null
    class ContactViewHolder(var it:View):ViewHolder( it){

        var name:   TextView=it.findViewById(R.id.contact_name)
        var phone:   TextView=it.findViewById(R.id.contact_phone)
    }
///////////////////////////////////////////////////////////////////


   fun interface onContactItemClickListener{

        fun onContactItemClick(item:Contact)}


////////////////////////////////////////////////////////////////////
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
         var contact=parent.context
        var view=LayoutInflater.from(contact).inflate(R.layout.contact_item_view,parent,false)

        return   ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size?:0
     }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item=contactList[position]
        holder.name.text=item.name
        holder.phone.text=item.phone
        holder.itemView.setOnClickListener{
            oncontactItemClickListener?.onContactItemClick(item)

        }


     }
}