# 🌙🍦 The Weird Ice Cream Shop
### *A chaotic, magical, slightly cursed Java console application*

Welcome to **The Weird Ice Cream Shop**, a Java-based ordering system where customers can build custom ice creams, order signature creations, drinks, and side items — and get a **printed receipt** generated straight into your `resources` folder.

This project was built using **Object-Oriented Programming**, enums, abstract classes, file I/O, and a structured UI flow.

---

## ✨ Features

### 🍨 Custom Ice Cream Builder
- Choose **cup type** (waffle, paper cup, edible glass, or… your hands)
- Choose **size** (Cutie Patootie, Just Right, Side Eye)
- Choose **flavors** (with scoop limits)
- Add **toppings** (organized by Mystical, Weird, Fruit, Candy, Drizzle)
- Pricing scales with size + premium toppings

### 🌟 Signature Ice Creams
Pre-designed unhinged creations like:

- *Piccola’s Cage*
- *Founding Titan Feast*
- *Forbidden Birthday Cake*
- *Celestial Matcha*
- *Mango Hex*

Signature items come with preset flavors/toppings, and the user chooses the size + extra toppings.

### 🥤 Drinks System
- Templates for drinks with type, sugar, ice, and size
- Dynamic sizing using `DrinkSize` enum

### 🍿 Side Items
Includes themed sides like:
- *Sukuna Fried Fingers*
- *Raspberry Macaroons*
- *El Cholesterol Macaroon*

### 🧾 Receipt Generation (File I/O)
At checkout:
- A **new receipt file is created for every order**
- Saved to:
