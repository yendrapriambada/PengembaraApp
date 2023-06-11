package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPerjuangan2Binding

class Perjuangan2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPerjuangan2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerjuangan2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }
            btnNext.setOnClickListener {
                Intent(this@Perjuangan2Activity, PerlawananSpanyolActivity::class.java).also {
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
        Intent(this@Perjuangan2Activity, PerjuanganActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}