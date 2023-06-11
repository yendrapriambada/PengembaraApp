package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityCaraPenggunaanBinding

class CaraPenggunaanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCaraPenggunaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaraPenggunaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@CaraPenggunaanActivity, DaftarIsiActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@CaraPenggunaanActivity, DataDiriActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}