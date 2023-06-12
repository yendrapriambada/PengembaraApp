package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityRefleksiBinding

class RefleksiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRefleksiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefleksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtPeristiwa, binding.edtPerasaan,
            binding.edtPenemuan, binding.edtPenerapan,
        )

        for (i in data.indices) {
            val savedData = sharedPref.getString("dataRefleksi${i + 1}", "default").toString()
            if (savedData != "default") data[i].setText(savedData)
        }

        binding.apply {
            btnHome.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataRefleksi${i + 1}", data[i].text.toString().trim())
                }
                editor.apply()

                backIntent()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@RefleksiActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}