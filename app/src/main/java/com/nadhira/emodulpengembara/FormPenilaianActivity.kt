package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityFormPenilaianBinding

class FormPenilaianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormPenilaianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPenilaianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHome.setOnClickListener {
                Intent(this@FormPenilaianActivity, DaftarIsiActivity::class.java).also {
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
        Intent(this@FormPenilaianActivity, PracticePerjuanganActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}