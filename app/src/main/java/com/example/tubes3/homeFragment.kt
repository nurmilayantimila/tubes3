package com.example.tubes3

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tubes3.adapter.UserAdapter
import com.example.tubes3.realm.User
import io.realm.Realm
import io.realm.RealmObject
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.fragment_home.*


class homeFragment : Fragment() {
    lateinit var userAdapter: UserAdapter
    lateinit var realm: Realm
    val nama1: String= "Nama :: "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        action()
    }


    fun initView(){
        val lm=LinearLayoutManager(activity)
        rv_user.layoutManager=lm
        userAdapter= UserAdapter(activity!!)
        userAdapter.notifyDataSetChanged()
        rv_user.adapter = userAdapter
        realm = Realm.getDefaultInstance()
        getAllUser()

    }

    fun action(){


        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count =0
            realm.where(User::class.java).findAll().let {
                for (i in it){
                    count++
                }
            }


            try {
                var user = realm.createObject(User::class.java)
                user.setId(count+1)

                user.setNama(et_nama.text.toString())
                user.setJenisKelamin(et_jeniskelamin.text.toString())
                user.setJabatan(et_jabatan.text.toString())
                user.setEmail(et_email.text.toString())

                getAllUser()
                //tv_result.text=user.getId().toString()+"Nama :: "+ user.getNama() + " " +user.getJenisKelamin()+" " +user.getJabatan()+" "+user.getEmail()
                et_nama.setText("")
                et_jeniskelamin.setText("")
                et_jabatan.setText("")
                et_email.setText("")

                realm.commitTransaction()
            }catch (e: RealmException){
                Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        btn_update.setOnClickListener {
            realm.beginTransaction()
            realm.where(User::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.setNama(et_nama.text.toString())
                it!!.setJenisKelamin(et_jeniskelamin.text.toString())
                it!!.setJabatan(et_jabatan.text.toString())
                it!!.setEmail(et_email.text.toString())

                //realm.copyToRealmOrUpdate(it)

                //realm.isAutoRefresh()
                //RealmObject.addChangeListener(User, listener);
            }

            realm.commitTransaction()
            getAllUser()
        }

        btn_delete.setOnClickListener {
            realm.beginTransaction()
            realm.where(User::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
                getAllUser()
            }
            realm.commitTransaction()

        }

    }
    fun getAllUser (){
        realm.where(User::class.java).findAll().let {
            userAdapter.setUser(it)

            //Log.d(TAG,"On Error: Error in saving Data!")
        }

    }

}
