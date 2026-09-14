# case_studyjava-

1: payment
1: seatbooking

# 🍔 Food Delivery System - Order Processing

## 📌 Problem Statement

A food delivery application has two independent activities:

* 🍳 One thread prepares the food.
* 🛵 Another thread delivers the food.

The **delivery thread should start only after the food preparation is completed**.

This project demonstrates **thread coordination using the `join()` method in Java**.

---

## 🎯 Objective

The main objective is to understand how the `join()` method coordinates multiple threads and ensures that one thread waits for another thread to complete.

---

## 🛠️ Technologies Used

* **Language:** Java
* **Concept:** Multithreading
* **Method:** `Thread.join()`

---

## ⚙️ How It Works

The program creates two threads:

### 1. Food Preparation Thread

This thread prepares the food and simulates preparation time using `Thread.sleep()`.

### 2. Food Delivery Thread

This thread delivers the food.

The `join()` method is used between them:

```java
preparation.start();
preparation.join();
delivery.start();
```

Here, `preparation.join()` makes the current thread wait until the food preparation thread finishes.

Therefore:

```text
Food Preparation
       ↓
   Completed
       ↓
Food Delivery
```

---

## 📂 Project Structure

```text
Food-Delivery-System/
│
├── food.java
└── README.md
```

---

## ▶️ How to Run

### Step 1: Compile the program

```bash
javac food.java
```

### Step 2: Run the program

```bash
java FoodDeliverySystem
```

---

## 💻 Sample Output

```text
Food preparation started...
Food preparation completed!
Food delivery started...
Food delivered successfully!
```

---

## 🔑 Key Concept: `join()`

The `join()` method causes the current thread to wait until the specified thread
