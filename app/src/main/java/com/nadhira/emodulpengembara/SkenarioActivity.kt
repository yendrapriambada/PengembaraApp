package com.nadhira.emodulpengembara

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.nadhira.emodulpengembara.BridgingActivity.Companion.EXTRA_FROM
import com.nadhira.emodulpengembara.databinding.ActivitySkenarioBinding

class SkenarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySkenarioBinding
    private lateinit var intentPrev: Intent
    private lateinit var intentNext: Intent
    private lateinit var atribut: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkenarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create Shared Preference
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        when (intent.getIntExtra(EXTRA_FROM, 0)) {
            1 -> {
                val dataPortugis = sharedPref.getString("skenarioPortugis", "default").toString()
                if (dataPortugis != "default") binding.edtJawaban1.setText(dataPortugis)

                binding.tvTitle.text = "Skenario Perlawanan Portugis"
                binding.tvPerintah3.text =
                    "Cerita berisi tentang perjuangan rakyat Aceh yang berprofesi sebagai pedagang, memiliki kapal dagang, memiliki senjata, dan meriam."

                atribut = "skenarioPortugis"

                intentPrev =
                    Intent(this@SkenarioActivity, BridgingActivity::class.java)
                intentNext =
                    Intent(this@SkenarioActivity, SkenarioActivity::class.java).also {
                        it.putExtra(EXTRA_FROM, 2)
                    }
            }
            2 -> {
                val dataSpanyol =
                    sharedPref.getString("skenarioSpanyol", "default").toString()
                if (dataSpanyol != "default") binding.edtJawaban1.setText(dataSpanyol)

                binding.tvTitle.text = "Skenario Perlawanan Spanyol"
                binding.tvPerintah3.text =
                    "Cerita berisi tentang perjuangan rakyat Minahasa yang berprofesi sebagai pedagang beras."

                atribut = "skenarioSpanyol"

                intentPrev =
                    Intent(this@SkenarioActivity, SkenarioActivity::class.java).also {
                        it.putExtra(EXTRA_FROM, 1)
                    }
                intentNext =
                    Intent(this@SkenarioActivity, SkenarioActivity::class.java).also {
                        it.putExtra(EXTRA_FROM, 3)
                    }
            }
            3 -> {
                val dataInggris =
                    sharedPref.getString("skenarioInggris", "default").toString()
                if (dataInggris != "default") binding.edtJawaban1.setText(dataInggris)

                binding.tvTitle.text = "Skenario Perlawanan Inggris"
                binding.tvPerintah3.text =
                    "Cerita berisi tentang perjuangan rakyat Palembang yang berprofesi sebagai pekerja tambang dan timah."

                binding.btnHome.visibility = View.VISIBLE
                binding.btnNext.visibility = View.GONE
                binding.btnPrev.visibility = View.GONE
                atribut = "skenarioInggris"

                intentPrev =
                    Intent(this@SkenarioActivity, SkenarioActivity::class.java).also {
                        it.putExtra(EXTRA_FROM, 2)
                    }
            }
        }

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                // savePref
                editor.putString(atribut, binding.edtJawaban1.text.toString().trim())
                editor.apply()

                startActivity(intentNext)
                finish()
            }

            btnHome.setOnClickListener {
                // savePref
                editor.putString(atribut, binding.edtJawaban1.text.toString().trim())
                editor.apply()

                Intent(this@SkenarioActivity, DaftarIsiActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        startActivity(intentPrev)
        finish()
    }
}