package com.example.virtualkbd

import android.inputmethodservice.InputMethodService
import android.view.View

class MyIME : InputMethodService() {

    private lateinit var pet: PetState
    private lateinit var storage: PetStorage
    private lateinit var root: KeyboardRootView

    override fun onCreateInputView(): View {
        storage = PetStorage(this)
        pet = storage.load()
        root = KeyboardRootView(this, pet, ::onKey)
        return root
    }

    override fun onDestroy() {
        storage.save(pet)
        super.onDestroy()
    }

    private fun onKey(code: Int) {
        val ic = currentInputConnection

        when (code) {
            -5 -> ic?.deleteSurroundingText(1, 0)
            32 -> ic?.commitText(" ", 1)
            10 -> ic?.commitText("\n", 1)

            9000 -> storage.save(pet)
            9001 -> pet = storage.load()

            10001 -> pet.hunger = (pet.hunger - 20).coerceAtLeast(0)
            10002 -> pet.happiness = (pet.happiness + 20).coerceAtMost(100)
            10003 -> pet.energy = (pet.energy + 25).coerceAtMost(100)

            else -> if (code in 32..126) {
                ic?.commitText(code.toChar().toString(), 1)
            }
        }

        root.invalidate()
    }
}
