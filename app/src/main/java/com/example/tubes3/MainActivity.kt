package com.example.tubes3

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.hardware.camera2.params.ColorSpaceTransform
import android.media.ImageWriter.newInstance
import android.net.ConnectivityManager
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest.newInstance
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest.newInstance
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {
    private val homeFragmen=homeFragment()
    private val infoFragmen=infoFragment()
    private val settingFragmen=settingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setConnection()
        replaceFragment(homeFragmen)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home ->replaceFragment(homeFragmen)
                R.id.ic_info ->replaceFragment(infoFragmen)
                R.id.ic_setting ->replaceFragment(settingFragmen)

            }
            true
        }




    }

    private fun setConnection() {
        val manager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo

        if (null != networkInfo){
            if (networkInfo.type == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "Wifi  Connected", Toast.LENGTH_SHORT).show()
            }
            else if (networkInfo.type== ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, "Mobile data  Connected", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            val dialog= Dialog(this)
            dialog.setContentView(R.layout.alert_dialog)

            dialog.setCanceledOnTouchOutside(false)
            dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT)

            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.btn_try_again.setOnClickListener {
                recreate()
            }
            dialog.show()
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}