package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityDaftarPustakaBinding

class DaftarPustakaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarPustakaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarPustakaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@DaftarPustakaActivity, DaftarPustaka2Activity::class.java).also {
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
        Intent(this@DaftarPustakaActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}