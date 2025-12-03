package com.example.cleaningcontrol

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleaningcontrol.databinding.ActivityBathroomsBinding

class BathroomsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBathroomsBinding

    private val bathroomGroups = mutableListOf(
        BathroomGroup(
            "Baños de arriba",
            mutableListOf(
                Bathroom("Bath 1", "Mañana", "Pendiente"),
                Bathroom("Bath 2", "Mañana", "Completo")
            )
        ),
        BathroomGroup(
            "Baños de abajo",
            mutableListOf(
                Bathroom("Bath 3", "Tarde", "Pendiente"),
                Bathroom("Bath 4", "Tarde", "En progreso")
            )
        )
    )

    private lateinit var groupAdapter: BathroomGroupAdapter
    private var currentShift = "Mañana"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBathroomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerBathrooms.layoutManager = LinearLayoutManager(this)

        binding.buttonMorning.setOnClickListener { setShift("Mañana") }
        binding.buttonAfternoon.setOnClickListener { setShift("Tarde") }

        setShift(currentShift)
    }

    private fun setShift(shift: String) {
        currentShift = shift

        // 🔥 Nuevo: adaptador de grupos con filtrado por turno
        groupAdapter = BathroomGroupAdapter(bathroomGroups, shift)
        binding.recyclerBathrooms.adapter = groupAdapter

        updateShiftButtons()
    }

    private fun updateShiftButtons() {
        if (currentShift == "Mañana") {
            binding.buttonMorning.setBackgroundColor(Color.parseColor("#FF6A2A"))
            binding.buttonMorning.setTextColor(Color.WHITE)
            binding.buttonAfternoon.setBackgroundColor(Color.parseColor("#EEEEEE"))
            binding.buttonAfternoon.setTextColor(Color.BLACK)
        } else {
            binding.buttonAfternoon.setBackgroundColor(Color.parseColor("#FF6A2A"))
            binding.buttonAfternoon.setTextColor(Color.WHITE)
            binding.buttonMorning.setBackgroundColor(Color.parseColor("#EEEEEE"))
            binding.buttonMorning.setTextColor(Color.BLACK)
        }
    }
}
