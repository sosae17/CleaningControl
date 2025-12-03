package com.example.cleaningcontrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleaningcontrol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ---------------------------
        // Después lo sincronizo con la DB
        // ---------------------------
        val BathNeedCleaning = false
        val VolunteersNeeded = true

        // ---------------------------
        // Tarjeta dinámica
        // ---------------------------
        when {
            VolunteersNeeded -> {
                binding.statusText.text = "⚠️ Algunos voluntarios no se presentaron"
                binding.statusCard.setCardBackgroundColor(getColor(android.R.color.holo_red_light))
            }
            BathNeedCleaning -> {
                binding.statusText.text = "🟡 Atención: un baño requiere limpieza"
                binding.statusCard.setCardBackgroundColor(getColor(android.R.color.holo_orange_light))
            }
            else -> {
                binding.statusText.text = "🟢 Todo está en orden"
                binding.statusCard.setCardBackgroundColor(getColor(android.R.color.holo_green_light))
            }
        }

        // ---------------------------
        // Navegación
        // ---------------------------
        binding.buttonBathrooms.setOnClickListener {
            startActivity(Intent(this, BathroomsActivity::class.java))
        }

        binding.buttonVolunteers.setOnClickListener {
            startActivity(Intent(this, VoluntariesActivity::class.java))
        }
    }
}
