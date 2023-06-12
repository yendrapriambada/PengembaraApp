package com.nadhira.emodulpengembara

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityEvaluasiBinding

class EvaluasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEvaluasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvaluasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtSoal4, binding.edtSoal5, binding.edtSoal6
        )
        val pernyataanList = listOf(
            binding.pernyataan1Yes to binding.pernyataan1No,
            binding.pernyataan2Yes to binding.pernyataan2No,
            binding.pernyataan3Yes to binding.pernyataan3No
        )

        for (i in data.indices) {
            val savedData = sharedPref.getString("dataEvaluasi${i + 1}", "default").toString()
            if (savedData != "default") data[i].setText(savedData)
        }

        for ((yesButton, noButton) in pernyataanList) {
            val pernyataanKey = when (yesButton) {
                binding.pernyataan1Yes -> "pernyataanevaluasi1"
                binding.pernyataan2Yes -> "pernyataanevaluasi2"
                binding.pernyataan3Yes -> "pernyataanevaluasi3"
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
            val opsiSets = listOf(
                listOf(opsiA, opsiB, opsiC, opsiD),
                listOf(opsi2a, opsi2b, opsi2c, opsi2d)
                // Add more sets as needed
            )

            for (setIndex in opsiSets.indices) {
                val opsiSet = opsiSets[setIndex]

                for (optionIndex in opsiSet.indices) {
                    val opsi = opsiSet[optionIndex]

                    opsi.setOnClickListener {
                        for (j in opsiSet.indices) {
                            if (optionIndex == j) {
                                opsiSet[j].setImageResource(R.drawable.outline_check_box_24)
                            } else {
                                opsiSet[j].setImageResource(R.drawable.outline_check_box_outline_blank_24)
                            }
                        }

                        // Save the selected option
                        saveSelectedOption(this@EvaluasiActivity, setIndex, optionIndex)
                    }

                    // Load the selected option
                    val selectedOption = loadSelectedOption(this@EvaluasiActivity, setIndex)
                    if (selectedOption == optionIndex) {
                        opsi.setImageResource(R.drawable.outline_check_box_24)
                    } else {
                        opsi.setImageResource(R.drawable.outline_check_box_outline_blank_24)
                    }
                }
            }
        }

        binding.apply {
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataEvaluasi${i + 1}", data[i].text.toString().trim())
                }
                editor.apply()

                Intent(this@EvaluasiActivity, KunciJawabanActivity::class.java).also {
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


    // Save the selected option for a specific set
    private fun saveSelectedOption(context: Context, setIndex: Int, optionIndex: Int) {
        val sharedPreferences = context.getSharedPreferences("Configurations", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("Set_$setIndex", optionIndex)
        editor.apply()
    }

    // Load the selected option for a specific set
    private fun loadSelectedOption(context: Context, setIndex: Int): Int {
        val sharedPreferences = context.getSharedPreferences("Configurations", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("Set_$setIndex", -1)
    }


    private fun backIntent() {
        Intent(this@EvaluasiActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}