package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.databinding.ActivityLembarHasilBinding
import com.nadhira.emodulpengembara.databinding.ActivityMindmapKesimpulanBinding

class MindmapKesimpulanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMindmapKesimpulanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMindmapKesimpulanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val data = listOf(
            binding.edtKedatangan1, binding.edtKedatangan2, binding.edtKedatangan3,
            binding.edtFaktor1, binding.edtFaktor2, binding.edtFaktor3,
            binding.edtPerjuangan1, binding.edtPerjuangan2, binding.edtPerjuangan3, binding.edtImperialisme
        )

        for (i in data.indices) {
            val savedDataHasil = sharedPref.getString("dataMindmap${i + 1}", "default").toString()
            if (savedDataHasil != "default") data[i].setText(savedDataHasil)
        }

        binding.apply {
            btnHome.setOnClickListener {
                for (i in data.indices) {
                    editor.putString("dataMindmap${i+1}", data[i].text.toString().trim())
                }
                editor.apply()

                backIntent()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                for (i in data.indices) {
                    editor.putString("dataRolePlaying${i+1}", data[i].text.toString().trim())
                }
                editor.apply()

                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@MindmapKesimpulanActivity, DaftarIsiActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}