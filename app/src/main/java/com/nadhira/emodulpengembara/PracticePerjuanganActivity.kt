package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityPracticePerjuanganBinding

class PracticePerjuanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPracticePerjuanganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticePerjuanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtJawaban1, binding.edtJawaban2
        )

        for (i in data.indices) {
            val savedDataDiri = sharedPref.getString("dataPractice${i + 1}", "default").toString()
            if (savedDataDiri != "default") data[i].setText(savedDataDiri)
        }

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataPractice${i+1}", data[i].text.toString().trim())
                }
                editor.apply()


                Intent(this@PracticePerjuanganActivity, FormPenilaianActivity::class.java).also {
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
        Intent(this@PracticePerjuanganActivity, PerlawananInggrisActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}