package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityKedatanganBinding

class KedatanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKedatanganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKedatanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHome.setOnClickListener {
                Intent(this@KedatanganActivity, DaftarIsiActivity::class.java).also {
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
        Intent(this@KedatanganActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}