package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityKarakterBinding

class KarakterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKarakterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKarakterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHome.setOnClickListener {
                Intent(this@KarakterActivity, DaftarIsiActivity::class.java).also {
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
        Intent(this@KarakterActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}