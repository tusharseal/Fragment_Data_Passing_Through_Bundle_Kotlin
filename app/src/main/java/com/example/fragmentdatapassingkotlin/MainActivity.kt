package com.example.fragmentdatapassingkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    lateinit var firstFragmentBtn: Button
    lateinit var secondFragmentBtn:Button
    lateinit var fragmentdatapassing: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Fragment Data Passing Java"

        firstFragmentBtn = findViewById(R.id.fragment1btn)
        secondFragmentBtn = findViewById(R.id.fragment2btn)
        fragmentdatapassing = findViewById(R.id.fragmentdatapassing)

        firstFragmentBtn.setOnClickListener {
            fragmentdatapassing.visibility = View.GONE
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, Fragment1::class.java, null)
                .commit()
        }

        secondFragmentBtn.setOnClickListener {
            fragmentdatapassing.visibility = View.GONE
            replaceFragment(Fragment2())
        }
    }

    private fun replaceFragment(fragment2: Fragment2) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment2)
            .commit()
    }
    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (fragment !is IOnBackPressed || !(fragment as IOnBackPressed).onBackPressed()) {
            super.onBackPressed()
        }
    }

    fun onBackPressed1() {
        val fragment = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (fragment !is IOnBackPressed1 || !(fragment as IOnBackPressed1).onBackPressed1()) {
            super.onBackPressed()
        }
    }

}