package com.example.cleaningcontrol

data class BathroomGroup(
    val groupName: String,            // Ej: "Baños de arriba"
    val bathrooms: MutableList<Bathroom>
)
