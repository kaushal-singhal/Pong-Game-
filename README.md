# 🏓 Pong Game

A classic **2-player Pong Game** built using **Java Swing** and **AWT**. The game recreates the famous arcade Pong experience where two players control paddles and try to score by preventing the ball from passing their side.

---

## 📸 Preview

<img src="images/pong-preview.png" alt="Pong Game" width="700"/>

> *(Replace the image above with a screenshot of your game.)*

---

## ✨ Features

- 🎮 Two-player gameplay
- ⌨️ Keyboard controls
- ⚡ Smooth game loop running at 60 FPS
- 🏓 Ball collision physics
- 🚀 Ball speed increases after every paddle hit
- 📊 Live scoreboard
- 🟥🟩 Different paddle colors for each player
- 🔄 Automatic game reset after every score
- 🖥️ Built using Java Swing & AWT

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Java AWT
- Object-Oriented Programming (OOP)

---



## ⚙️ How It Works

### Game Loop

The game runs using a custom thread with a fixed update rate of **60 FPS**.

Every frame performs:

1. Move paddles
2. Move ball
3. Detect collisions
4. Update score
5. Repaint the screen

---

### Collision Detection

The game checks collisions between:

- Ball and top wall
- Ball and bottom wall
- Ball and left paddle
- Ball and right paddle

Whenever the ball hits a paddle:

- Ball direction changes
- Ball speed increases
- Gameplay becomes progressively faster

---

### Scoring System

- If the ball crosses the **left boundary**, Player 2 scores.
- If the ball crosses the **right boundary**, Player 1 scores.
- After every point:
  - Ball resets
  - Paddles reset
  - Score remains

---

## 🧩 Object-Oriented Design

The project follows an object-oriented approach.

### Classes

### `main`

Entry point of the application.

---

### `gameframe`

Creates the main application window.

Responsibilities:

- Create JFrame
- Add Game Panel
- Configure window properties

---

### `gamepanel`

Handles the complete gameplay.

Responsibilities:

- Game loop
- Rendering
- Collision detection
- Ball movement
- Paddle movement
- Score updates
- Keyboard input

---

### `ball`

Represents the game ball.

Responsibilities:

- Ball movement
- Velocity handling
- Drawing ball
- Random spawn direction

---

### `paddles`

Represents both paddles.

Responsibilities:

- Keyboard controls
- Paddle movement
- Rendering

---

### `score`

Displays the current score.

Responsibilities:

- Draw center line
- Draw player scores

---

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/pong-game.git
```

## 👨‍💻 Author

**Kaushal Singhal**

If you found this project useful, consider giving it a ⭐ on GitHub.
