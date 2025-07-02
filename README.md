# Clash Royale Elixir Tracker (LAST UPDATED DURING MY SOPHOMORE YEAR OF HIGH SCHOOL, 2022)

A lightweight **OpenCV-based Elixir tracking tool** for **Clash Royale** on PC emulators (Bluestacks), automatically detecting your and your opponent’s Elixir usage in real time while providing a “winning score” estimate.

This project was created for an **English final** as a demonstration of applying **computer vision and Java skills** to a practical, engaging project.

---

## Features

- Tracks **your Elixir** and **enemy Elixir** live.
- Estimates a **win score** based on Elixir advantage.
- Supports **all cards** dynamically.
- Processes emulator screen using **OpenCV** for real-time detection.
- Fully implemented in **Java** for performance and familiarity.

---

## Tech Stack

- **Java**
- **OpenCV (Java bindings)**

---

## Usage

1. **Install Bluestacks** and open Clash Royale.
2. Clone this repository:
    ```bash
    git clone https://github.com/justinangara/clash-royale-enemy-elixir-tracker
    cd clash-royale-elixir-tracker
    ```
3. Ensure **OpenCV Java bindings** are installed and linked in your IDE or build system.
4. Build and run:
    ```bash
    javac ElixirTracker.java
    java ElixirTracker
    ```
5. Keep the emulator window active. The tracker will:
    - Display **live Elixir counts** for both you and your opponent.
    - Estimate your win status in real time.

---

## How It Works

- Captures a **screen region** of your emulator window.
- Uses **OpenCV’s color filtering and contour detection** to detect Elixir bars visually.
- Calculates Elixir count based on detected bar heights or widths.
- Updates and displays the Elixir values along with a “winning status” estimate based on your Elixir advantage.

---

## Demo

[![Watch the video](https://img.youtube.com/vi/81xeJecRxg0/0.jpg)](https://www.youtube.com/watch?v=81xeJecRxg0)

---

## Why I Made This

> “I created this project to practically learn computer vision and demonstrate how programming can solve fun, game-related problems in real time. It was challenging and rewarding, showcasing how quickly you can transform an idea into a functional tool.”  
> – Justin Angara

---

## Future Ideas

- Card image recognition for **precise game state tracking**.
- Overlay GUI instead of console for seamless integration.
- Predict opponent cycle and game trends based on tracked Elixir usage.

---

## License

MIT
