
package com.example.virtualkbd

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class TamagotchiDisplayView(
    context: Context,
    private val pet: PetState
) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        val mood = (pet.happiness + pet.energy - pet.hunger) / 3

        val color = when {
            mood > 50 -> Color.GREEN
            mood > 20 -> Color.YELLOW
            else -> Color.RED
        }

        paint.color = color
        canvas.drawRect(
            pet.x - 6f,
            pet.y - 6f,
            pet.x + 6f,
            pet.y + 6f,
            paint
        )

        paint.color = Color.BLACK
        canvas.drawCircle(pet.x - 2f, pet.y - 2f + pet.animFrame * 2, 1.5f, paint)
        canvas.drawCircle(pet.x + 2f, pet.y - 2f + pet.animFrame * 2, 1.5f, paint)

        if (mood > 40) {
            canvas.drawLine(pet.x - 3f, pet.y + 3f, pet.x + 3f, pet.y + 3f, paint)
        } else {
            canvas.drawLine(pet.x - 3f, pet.y + 5f, pet.x + 3f, pet.y + 1f, paint)
        }
    }
}
