package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPracticePerjuanganBinding

class PracticePerjuanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPracticePerjuanganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticePerjuanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }
            btnNext.setOnClickListener {
                Intent(this@PracticePerjuanganActivity, FormPenilaianActivity::class.java).also {
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
        Intent(this@PracticePerjuanganActivity, PerlawananInggrisActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}