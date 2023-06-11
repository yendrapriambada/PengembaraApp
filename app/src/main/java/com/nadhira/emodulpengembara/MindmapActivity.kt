package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityMindmapBinding

class MindmapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMindmapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMindmapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@MindmapActivity, Mindmap2Activity::class.java).also {
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
        Intent(this@MindmapActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}