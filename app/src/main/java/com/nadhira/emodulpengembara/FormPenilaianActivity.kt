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

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val pernyataanList = listOf(
            binding.pernyataan1Yes to binding.pernyataan1No,
            binding.pernyataan2Yes to binding.pernyataan2No,
            binding.pernyataan3Yes to binding.pernyataan3No,
            binding.pernyataan4Yes to binding.pernyataan4No,
            binding.pernyataan5Yes to binding.pernyataan5No
        )

        for ((yesButton, noButton) in pernyataanList) {
            val pernyataanKey = when (yesButton) {
                binding.pernyataan1Yes -> "pernyataan1"
                binding.pernyataan2Yes -> "pernyataan2"
                binding.pernyataan3Yes -> "pernyataan3"
                binding.pernyataan4Yes -> "pernyataan4"
                binding.pernyataan5Yes -> "pernyataan5"
                else -> ""
            }

            // Retrieve the string value from SharedPreferences
            val pernyataanValue = sharedPref.getString(pernyataanKey, "default")

            // Set the image resource based on the retrieved value
            val yesDrawable = when (pernyataanValue) {
                "nyala" -> {
                    R.drawable.outline_check_box_24
                }
                "default" -> {
                    R.drawable.outline_check_box_outline_blank_24
                }
                else -> {
                    R.drawable.outline_check_box_outline_blank_24
                }
            }

            val noDrawable = when (pernyataanValue) {
                "mati" -> {
                    R.drawable.outline_check_box_24
                }
                "default" -> {
                    R.drawable.outline_check_box_outline_blank_24
                }
                else -> {
                    R.drawable.outline_check_box_outline_blank_24
                }
            }

            yesButton.setImageResource(yesDrawable)
            noButton.setImageResource(noDrawable)

            yesButton.setOnClickListener {
                yesButton.setImageResource(R.drawable.outline_check_box_24)
                noButton.setImageResource(R.drawable.outline_check_box_outline_blank_24)

                // Save the data to SharedPreferences
                editor.putString(pernyataanKey, "nyala").apply()
            }

            noButton.setOnClickListener {
                yesButton.setImageResource(R.drawable.outline_check_box_outline_blank_24)
                noButton.setImageResource(R.drawable.outline_check_box_24)

                // Save the data to SharedPreferences
                editor.putString(pernyataanKey, "mati").apply()
            }
        }

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