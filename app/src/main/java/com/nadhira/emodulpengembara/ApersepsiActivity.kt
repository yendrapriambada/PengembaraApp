package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityApersepsiBinding

class ApersepsiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApersepsiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApersepsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@ApersepsiActivity, ImperialismeActivity::class.java).also {
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
        Intent(this@ApersepsiActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}