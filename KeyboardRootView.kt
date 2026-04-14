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

    private fun build() {
        listOf(
            mk("FEED", 10001),
            mk("PLAY", 10002),
            mk("SLEEP", 10003),
            mk("SAVE", 9000),
            mk("LOAD", 9001),
            mk("A", 97),
            mk("B", 98),
            mk("SPACE", 32),
            mk("BACK", -5)
        ).forEach {
            buttons += it
            addView(it)
        }
    }

    private fun mk(label: String, code: Int): Button {
        return Button(context).apply {
            text = label
            setOnClickListener { onKey(code) }
        }
    }

    override fun onMeasure(w: Int, h: Int) {
        val width = MeasureSpec.getSize(w)

        display.measure(
            MeasureSpec.makeMeasureSpec(width / 2, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(width / 2, MeasureSpec.EXACTLY)
        )

        buttons.forEach {
            it.measure(
                MeasureSpec.makeMeasureSpec(width / 3, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(120, MeasureSpec.EXACTLY)
            )
        }

        setMeasuredDimension(width, width + 400)
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        val size = display.measuredWidth
        display.layout(0, 0, size, size)

        var x = 0
        var y = size

        val cols = 3

        buttons.forEachIndexed { i, v ->
            val col = i % cols
            val row = i / cols

            v.layout(
                col * v.measuredWidth,
                y + row * v.measuredHeight,
                col * v.measuredWidth + v.measuredWidth,
                y + row * v.measuredHeight + v.measuredHeight
            )
        }
    }
}
