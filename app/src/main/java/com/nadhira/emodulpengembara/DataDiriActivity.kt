package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityDataDiriBinding

class DataDiriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataDiriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDiriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtNama, binding.edtKelas, binding.edtAbsen
        )

        for (i in data.indices) {
            val savedDataDiri = sharedPref.getString("dataDiri${i + 1}", "default").toString()
            if (savedDataDiri != "default") data[i].setText(savedDataDiri)
        }

        binding.apply {
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataDiri${i+1}", data[i].text.toString().trim())
                }
                editor.apply()


                Intent(this@DataDiriActivity, CaraPenggunaanActivity::class.java).also {
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
        Intent(this@DataDiriActivity, MainActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}