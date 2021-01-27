package com.example.tubes3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_info.*


class infoFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false) //apapun kode dibawah kata return ini tidak bakalan dicompile makanya tidak berfungsi
/*
        val btn_call: Button = btn_call.findViewById(R.id.btn_call)
        btn_call.setOnClickListener {
            val btn_call = Intent(Intent.ACTION_DIAL)
            activity!!.startActivityForResult(btn_call, 12345)
        }
*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_call: Button = btn_call.findViewById(R.id.btn_call)
        btn_call.setOnClickListener {
            val it =Intent(Intent.ACTION_DIAL)
            it.setData(Uri.parse("tel:"+ 8938975))
            //Toast.makeText(context,"succes", Toast.LENGTH_SHORT).show()
             startActivity(it)

        }
    }
}