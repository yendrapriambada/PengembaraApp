package com.nadhira.emodulpengembara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.nadhira.emodulpengembara.databinding.ActivityCptpactivityBinding
import com.nadhira.emodulpengembara.databinding.ActivityImperialismeBinding

class ImperialismeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImperialismeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImperialismeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHome.setOnClickListener {
                Intent(this@ImperialismeActivity, DaftarIsiActivity::class.java).also {
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
        Intent(this@ImperialismeActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}