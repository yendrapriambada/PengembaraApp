package com.nadhira.emodulpengembara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.nadhira.emodulpengembara.databinding.ActivityPerlawananInggrisBinding
import com.nadhira.emodulpengembara.databinding.ActivityPerlawananSpanyolBinding

class PerlawananInggrisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerlawananInggrisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerlawananInggrisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@PerlawananInggrisActivity, PerlawananSpanyolActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }
            btnNext.setOnClickListener {
                Intent(this@PerlawananInggrisActivity, PracticePerjuanganActivity::class.java).also {
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
        Intent(this@PerlawananInggrisActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}