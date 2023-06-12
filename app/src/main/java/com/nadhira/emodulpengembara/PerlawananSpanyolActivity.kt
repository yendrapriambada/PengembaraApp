package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPerlawananSpanyolBinding

class PerlawananSpanyolActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerlawananSpanyolBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerlawananSpanyolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }
            btnNext.setOnClickListener {
                Intent(this@PerlawananSpanyolActivity, PerlawananInggrisActivity::class.java).also {
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
        Intent(this@PerlawananSpanyolActivity, Perjuangan2Activity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}