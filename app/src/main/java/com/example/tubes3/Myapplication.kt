package com.example.tubes3

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class Myapplication : Application (){
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("Myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
    }
}