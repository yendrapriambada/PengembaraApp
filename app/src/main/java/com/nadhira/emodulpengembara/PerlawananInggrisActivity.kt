package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPerlawananInggrisBinding

class PerlawananInggrisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerlawananInggrisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerlawananInggrisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }
            btnNext.setOnClickListener {
                Intent(
                    this@PerlawananInggrisActivity,
                    PracticePerjuanganActivity::class.java
                ).also {
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
        Intent(this@PerlawananInggrisActivity, PerlawananSpanyolActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}