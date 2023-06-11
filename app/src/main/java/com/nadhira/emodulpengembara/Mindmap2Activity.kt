package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityMindmap2Binding

class Mindmap2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMindmap2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMindmap2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHome.setOnClickListener {
                Intent(this@Mindmap2Activity, DaftarIsiActivity::class.java).also {
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
        Intent(this@Mindmap2Activity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}