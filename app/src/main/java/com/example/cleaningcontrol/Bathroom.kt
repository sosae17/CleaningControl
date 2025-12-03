package com.example.cleaningcontrol

data class Bathroom(
    val name: String,
    val shift: String,   // "Mañana" o "Tarde"
    val status: String   // "OK", "Atencion", "Advertencia"
)
