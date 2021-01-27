package com.example.tubes3

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*


class settingFragment : Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //loadLocate()

        return inflater.inflate(R.layout.fragment_setting, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Hello"


        /* val actionBar = activity?.actionBar
         actionBar?.title=resources.getString(R.string.app_name)*/

        var mchangelang : Button= mchangelang.findViewById(R.id.mchangelang)



        mchangelang.setOnClickListener {
            /*showChangelang()*/

                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)

        }

    }

    private fun showChangelang() {

        val listitem = arrayOf("english", "indonesia")
        val  mBuilder = AlertDialog.Builder(activity)
         mBuilder.setTitle("choose langguage")
        mBuilder.setSingleChoiceItems(listitem, -1) { dialog, which ->
            if (which == 0) {
                setLocate("en")
                //recreate()
                activity?.let { recreate(it) }
            } else if (which == 1) {
                setLocate("in")
                activity?.let { recreate(it) }
            }


            dialog.dismiss()

        }

        val mDialog=mBuilder.create()
        mDialog.show()

    }

    private fun setLocate(Lang: String) {
        val locale= Locale(Lang)
        Locale.setDefault(locale)
        val config= Configuration()
        config.locale=locale

        requireContext().resources.updateConfiguration(config, requireContext().resources.displayMetrics)

        val editor = activity?.getSharedPreferences("Setting", Context.MODE_PRIVATE)?.edit()
        editor?.putString("My_Lang", Lang)
        editor?.apply()

    }

    private fun loadLocate(){
        val sharedPreferences = activity?.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val langguage= sharedPreferences?.getString("mylang", "")
        langguage?.let { setLocate(it) }
    }
}




