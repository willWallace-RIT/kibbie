package com.example.virtualkbd

import android.content.Context
import android.content.SharedPreferences

class PetStorage(context: Context) {

    private val prefs = context.getSharedPreferences("pet_save", Context.MODE_PRIVATE)

    fun save(p: PetState) {
        prefs.edit()
            .putInt("hunger", p.hunger)
            .putInt("happiness", p.happiness)
            .putInt("energy", p.energy)
            .putInt("x", p.x)
            .putInt("y", p.y)
            .putInt("dx", p.dirX)
            .putInt("dy", p.dirY)
            .apply()
    }

    fun load(): PetState {
        return PetState(
            hunger = prefs.getInt("hunger", 50),
            happiness = prefs.getInt("happiness", 50),
            energy = prefs.getInt("energy", 50),
            x = prefs.getInt("x", 64),
            y = prefs.getInt("y", 64),
            dirX = prefs.getInt("dx", 1),
            dirY = prefs.getInt("dy", 0)
        )
    }
}
