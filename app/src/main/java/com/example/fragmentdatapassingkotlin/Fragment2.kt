package com.example.fragmentdatapassingkotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentdatapassingkotlin.databinding.Fragment2Binding

class Fragment2 : IOnBackPressed1, Fragment() {

    private lateinit var binding: Fragment2Binding
    private var bundle: Bundle? = null

    // Inflate the layout for this fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        bundle = this.arguments

        if (bundle!=null) {

            val data1: String? = bundle!!.getString("data1")
            val data2: String? = bundle!!.getString("data2")
            val data3: String? = bundle!!.getString("data3")
            binding.data1txtview.text = "Data 1:$data1"
            binding.data2txtview.text = "Data 2:$data2"
            binding.data3txtview.text = "Data 3:$data3"
        } else {
            binding.data1txtview.text = "Data 1:"
            binding.data2txtview.text = "Data 2:"
            binding.data3txtview.text = "Data 3:"
        }


        binding.activity1btn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onBackPressed1(): Boolean {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        return false
    }
}