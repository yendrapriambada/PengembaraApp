package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityDaftarPustaka2Binding

class DaftarPustaka2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarPustaka2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarPustaka2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnExit.setOnClickListener {
                finishAffinity()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@DaftarPustaka2Activity, DaftarPustakaActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}