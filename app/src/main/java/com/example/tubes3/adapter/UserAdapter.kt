package com.example.tubes3.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tubes3.R
import com.example.tubes3.realm.User
import com.google.android.material.transition.Hold

class UserAdapter (val context : Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val users: MutableList<User> = mutableListOf()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
       return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.bindModel(users[position])

    }
    fun setUser(data : List<User>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()


    }
    
    inner class UserViewHolder (i : View) : RecyclerView.ViewHolder(i){

        val tvId : TextView= i.findViewById(R.id.tv_id)
        val tvName : TextView= i.findViewById(R.id.tv_nama)
        val tvjenisKelamin : TextView= i.findViewById(R.id.tv_jenisKelamin)
        val tvJabatan : TextView= i.findViewById(R.id.tv_jabatan)
        val tvEmail : TextView= i.findViewById(R.id.tv_email)

        fun  bindModel(u: User){
            tvId.text= u.getId().toString()
            tvName.text=u.getNama()
            tvjenisKelamin.text=u.getJenisKelamin()
            tvJabatan.text=u.getJabatan()
            tvEmail.text=u.getEmail()

        }

    }

}