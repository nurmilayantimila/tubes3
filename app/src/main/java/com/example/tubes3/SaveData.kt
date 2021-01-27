package com.example.tubes3

import android.content.Context
import android.content.SharedPreferences

class SaveData (context: Context) {
    private val sharedPreference : SharedPreferences = context.getSharedPreferences("File", Context.MODE_PRIVATE)


    fun setDarkModeState (state : Boolean?){
        val editor = sharedPreference.edit()
        editor.putBoolean("Light", state!!)
        editor.apply()
    }

    fun loadDarkModestate() : Boolean?{
        val state = sharedPreference.getBoolean("Dark", false)
        return (state)
    }
}