package com.example.tubes3.realm

import android.provider.ContactsContract
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class User : RealmObject(){
    private var  id:Int=0
    private var nama : String =""
   // private var nama1 : String ="Nama :: "
    private var jeniskelamin:String=""
    private var jabatan:String=""
    private var email:String=""



    fun setId(id:Int){
        this.id=id
    }
    fun getId():Int{
        return id
    }
    fun setNama(nama:String){
        this.nama=nama
    }
    fun getNama(): String{
        return nama
    }
    /*fun setNama1(nama1 : String){
        this.nama1=nama1

    }
    fun getNama1(): String{
        return nama1
    }
*/

    fun setJenisKelamin(jeniskelamin:String){
        this.jeniskelamin=jeniskelamin
    }
    fun getJenisKelamin(): String{
        return jeniskelamin
    }
    fun setJabatan(jabatan:String){
        this.jabatan=jabatan
    }
    fun getJabatan(): String{
        return jabatan
    }

    fun setEmail(email:String){
        this.email=email
    }
    fun getEmail(): String{
        return email
    }

}