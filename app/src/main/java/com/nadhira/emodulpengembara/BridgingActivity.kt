package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityBridgingBinding

class BridgingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBridgingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBridgingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNext.setOnClickListener {
                Intent(this@BridgingActivity, SkenarioActivity::class.java).also {
                    it.putExtra(EXTRA_FROM, 1)
                    startActivity(it)
                }
                finish()
            }

            btnPortugis.setOnClickListener {
                Intent(this@BridgingActivity, SkenarioActivity::class.java).also {
                    it.putExtra(EXTRA_FROM, 1)
                    startActivity(it)
                }
                finish()
            }

            btnSpanyol.setOnClickListener {
                Intent(this@BridgingActivity, SkenarioActivity::class.java).also {
                    it.putExtra(EXTRA_FROM, 2)
                    startActivity(it)
                }
                finish()
            }

            btnInggris.setOnClickListener {
                Intent(this@BridgingActivity, SkenarioActivity::class.java).also {
                    it.putExtra(EXTRA_FROM, 3)
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
        Intent(this@BridgingActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    companion object {
        const val EXTRA_FROM = "extra_from"
    }
}