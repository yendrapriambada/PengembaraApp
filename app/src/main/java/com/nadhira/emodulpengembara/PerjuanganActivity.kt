package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPerjuanganBinding

class PerjuanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerjuanganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerjuanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@PerjuanganActivity, Perjuangan2Activity::class.java).also {
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
        Intent(this@PerjuanganActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}