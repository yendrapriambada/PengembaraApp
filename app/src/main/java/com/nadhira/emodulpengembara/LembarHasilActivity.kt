package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityLembarHasilBinding

class LembarHasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLembarHasilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLembarHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtKelompok, binding.edtPartisipasi, binding.edtPenghayatan1, binding.edtPenghayatan2, binding.edtPenghayatan3, binding.edtKerjasama, binding.edtCatatan1,
            binding.edtKelompok2, binding.edtPartisipasi2, binding.edtPenghayatan4, binding.edtPenghayatan5, binding.edtPenghayatan6, binding.edtKerjasama2, binding.edtCatatan2,
        )

        for (i in data.indices) {
            val savedDataHasil = sharedPref.getString("dataRolePlaying${i + 1}", "default").toString()
            if (savedDataHasil != "default") data[i].setText(savedDataHasil)
        }

        binding.apply {
            btnNext.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataRolePlaying${i+1}", data[i].text.toString().trim())
                }
                editor.apply()


                Intent(this@LembarHasilActivity, LembarHasil2Activity::class.java).also {
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
        Intent(this@LembarHasilActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}