package com.nadhira.emodulpengembara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.nadhira.emodulpengembara.databinding.ActivityCaraPenggunaanBinding
import com.nadhira.emodulpengembara.databinding.ActivityDaftarIsiBinding

class DaftarIsiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarIsiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarIsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnCptp.setOnClickListener {
                Intent(this@DaftarIsiActivity, CptpActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnImperialisme.setOnClickListener {
                Intent(this@DaftarIsiActivity, ImperialismeActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnKedatangan.setOnClickListener {
                Intent(this@DaftarIsiActivity, KedatanganActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnRoleplaying.setOnClickListener {
                Intent(this@DaftarIsiActivity, KarakterActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnFaktor.setOnClickListener {
                Intent(this@DaftarIsiActivity, MindmapActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnPerjuangan.setOnClickListener {
                Intent(this@DaftarIsiActivity, PerjuanganActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnSkenario.setOnClickListener {
                Intent(this@DaftarIsiActivity, BridgingActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnLembarhasil.setOnClickListener {
//                Intent(this@DaftarIsiActivity, BridgingActivity::class.java).also {
//                    startActivity(it)
//                }
//                finish()
            }

            btnMindmap.setOnClickListener {
//                Intent(this@DaftarIsiActivity, BridgingActivity::class.java).also {
//                    startActivity(it)
//                }
//                finish()
            }

            btnRefleksi.setOnClickListener {
//                Intent(this@DaftarIsiActivity, BridgingActivity::class.java).also {
//                    startActivity(it)
//                }
//                finish()
            }

            btnEvaluasi.setOnClickListener {
//                Intent(this@DaftarIsiActivity, BridgingActivity::class.java).also {
//                    startActivity(it)
//                }
//                finish()
            }

            btnPustaka.setOnClickListener {
                Intent(this@DaftarIsiActivity, DaftarPustakaActivity::class.java).also {
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
        Intent(this@DaftarIsiActivity, CaraPenggunaanActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}