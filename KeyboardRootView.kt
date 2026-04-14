package com.example.virtualkbd

import android.content.Context
import android.view.ViewGroup
import android.widget.Button

class KeyboardRootView(
    context: Context,
    private val pet: PetState,
    private val onKey: (Int) -> Unit
) : ViewGroup(context) {

    private val display = TamagotchiDisplayView(context, pet)
    private val buttons = mutableListOf<Button>()

    init {
        addView(display)

        build()

        post(object : Runnable {
            override fun run() {
                pet.hunger += 1
                pet.happiness -= 1
                pet.energy -= 1

                pet.x += pet.dirX
                pet.y += pet.dirY

                if (pet.x < 10 || pet.x > 118) pet.dirX *= -1
                if (pet.y < 10 || pet.y > 118) pet.dirY *= -1

                pet.animFrame = (pet.animFrame + 1) % 4

                display.invalidate()
                postDelayed(this, 250)
            }
        })
    }
