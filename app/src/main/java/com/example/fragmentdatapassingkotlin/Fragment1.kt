package com.example.fragmentdatapassingkotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentdatapassingkotlin.databinding.Fragment1Binding


class Fragment1 : IOnBackPressed, Fragment() {

    lateinit var binding: Fragment1Binding
    lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = Fragment1Binding.inflate(inflater, container, false)

        binding.passData.setOnClickListener {
            val Data1 = binding.data1.text.toString()
            val Data2 = binding.data2.text.toString()
            val Data3 = binding.data3.text.toString()
            bundle = Bundle()
            bundle.putString("data1", Data1)
            bundle.putString("data2", Data2)
            bundle.putString("data3", Data3)
            val fragment: Fragment = Fragment2()
            fragment.arguments = bundle
            val fragmentTransaction = activity
                ?.getSupportFragmentManager()
                ?.beginTransaction()
            if (fragmentTransaction != null) {
                fragmentTransaction.replace(R.id.frameLayout, fragment)
                    .setReorderingAllowed(true)
                    .addToBackStack("name")
                    .commit()
            }
        }

        return binding.root
    }


    override fun onBackPressed(): Boolean {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)

        return false
    }
}