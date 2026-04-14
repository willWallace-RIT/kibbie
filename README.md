Kibbie (base code written by chat)

A Virtual LCD Keyboard + Tamagotchi IME System for Android


---

🧠 Overview

Kibbie is an experimental Android Input Method Editor (IME) that merges a full 104-key keyboard layout with a virtual LCD simulation layer that runs a Tamagotchi-like autonomous creature.

Instead of treating the keyboard and game as separate systems, Kibbie fuses them into a single interactive environment where:

The keyboard is a functional input device

The display is a virtual LCD constructed from square pixels

A living creature exists inside that LCD and responds to user interaction



---

🟦 Core Concept

Kibbie is designed around a dual-layer system:

1. ⌨️ Virtual 104-Key Keyboard Space

Full PC-style 104-key layout concept

Keys are rendered in paged virtual UI layers

Includes:

Alpha layout (QWERTY)

Function layer (F1–F12)

Symbols layer

Numeric keypad layer



The keyboard is not static — it exists as a navigable interface space where pages represent different regions of the input world.


---

2. 🟦 Virtual LCD Display (Pixel Grid Engine)

The "screen" is not a bitmap image

It is a grid of square logic pixels rendered via Canvas

Each update frame redraws the LCD from state data


This grid acts as:

A miniature display engine

A simulation surface

A reactive environment for the pet



---

3. 🐾 Tamagotchi-like Creature System

Inside the LCD grid exists a living simulated entity:

Has position (x, y)

Has directional movement

Has animation frame state

Has emotional stats:

Hunger

Happiness

Energy



Behavior:

Moves autonomously inside the LCD bounds

Bounces / navigates within the grid space

Changes appearance based on mood state

Animates via frame cycling (pseudo-GIF system)



---

💾 Persistence System

Kibbie includes persistent state tracking:

Saves pet stats

Saves position and direction

Restores state on reload

Uses Android SharedPreferences storage layer


This makes the creature feel like a continuous living system rather than a session-based app.


---

🔁 Interaction Model

User input affects both layers:

Keyboard Layer

Standard text input to system apps

Key events routed through IME service


Pet Layer

Buttons affect pet stats:

Feed → reduces hunger

Play → increases happiness

Sleep → restores energy




---

🧩 Architectural Philosophy

Kibbie is built as a hybrid of:

🧠 Input Method Editor (IME)

🎮 Virtual simulation engine

🟦 Pixel-based LCD renderer

🐾 Autonomous agent system


The goal is to explore:

> What if the keyboard itself was a living computational environment?




---

🛠 Technical Stack

Kotlin (Android native)

InputMethodService (IME framework)

Canvas-based rendering system

SharedPreferences persistence

ViewGroup-based dynamic UI layout



---

🚀 Intended Future Extensions

🧬 Sprite System

Replace primitive shapes with sprite sheets:

Idle animation

Walking animation

Emotional states


🌍 Tile-Based World

Transform LCD into a grid world:

Objects

Food items

Obstacles

Pathfinding AI


🧠 Behavioral Learning

Pet evolves based on user interaction patterns:

Attention tracking

Neglect adaptation

Mood memory system


🔊 Feedback Layer

Haptic responses

Sound effects

Emotional audio cues


🌐 Multi-Device Sync

Shared pets across devices

Cloud persistence or BLE sync



---

⚠️ Experimental Status

Kibbie is a conceptual / experimental system intended for:

UI experimentation

Simulation design

Game engine prototyping inside IME constraints


It is not a production keyboard replacement.


---

🧠 Closing Idea

Kibbie explores the boundary between:

> input device simulation world and living digital system



The keyboard becomes not just a tool for communication —

but a habitat for a digital lifeform.


---
