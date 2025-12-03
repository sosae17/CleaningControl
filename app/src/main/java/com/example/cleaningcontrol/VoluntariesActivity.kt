package com.example.cleaningcontrol

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cleaningcontrol.databinding.ActivityVoluntariesBinding

class VoluntariesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVoluntariesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoluntariesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cambiamos texto del TextView por si queremos
        binding.tvVoluntarios.text = "Lista de Voluntarios"

        // Ejemplo de funcionalidad: botón muestra un Toast
        binding.btnAgregarVoluntario.setOnClickListener {
            Toast.makeText(this, "Agregar voluntario clickeado", Toast.LENGTH_SHORT).show()
        }
    }
}
