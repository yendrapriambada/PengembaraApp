package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityLembarHasil2Binding

class LembarHasil2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLembarHasil2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLembarHasil2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtKelebihan, binding.edtKekurangan, binding.edtDiperbaiki
        )

        for (i in data.indices) {
            val savedData = sharedPref.getString("dataLembarEvaluasi${i + 1}", "default").toString()
            if (savedData != "default") data[i].setText(savedData)
        }

        binding.apply {
            btnHome.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataLembarEvaluasi${i + 1}", data[i].text.toString().trim())
                }
                editor.apply()

                Intent(this@LembarHasil2Activity, DaftarIsiActivity::class.java).also {
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
        Intent(this@LembarHasil2Activity, LembarHasilActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}