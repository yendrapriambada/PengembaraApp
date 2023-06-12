package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityApersepsiBinding

class ApersepsiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApersepsiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApersepsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtJawaban1, binding.edtJawaban2
        )

        for (i in data.indices) {
            val savedData = sharedPref.getString("dataApersepsi${i + 1}", "default").toString()
            if (savedData != "default") data[i].setText(savedData)
        }

        binding.apply {
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataApersepsi${i + 1}", data[i].text.toString().trim())
                }
                editor.apply()

                Intent(this@ApersepsiActivity, ImperialismeActivity::class.java).also {
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
        Intent(this@ApersepsiActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}