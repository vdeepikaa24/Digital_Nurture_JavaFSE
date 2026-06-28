# Inventory Management System

## 📌 Project Overview
An in-memory Inventory Management System designed to handle large-scale warehouse stock updates efficiently. This project demonstrates practical usage of **Data Structures and Algorithms (DSA)** alongside core software design principles.

---

## 🛠️ Tech Stack & Architecture
* **Language:** Java (JDK 8+)
* **IDE:** Visual Studio Code
* **Storage Layer:** In-Memory Java Collection (`HashMap`)

---

## ⚡ Data Structure & Complexity Analysis

We selected a **`HashMap`** because looking up products by their unique ID must remain fast, even if the warehouse grows to millions of items.

| Operation | Time Complexity | Why? |
| :--- | :--- | :--- |
| **Add Product** | `O(1)` | Directly hashes the product ID to find its memory bucket. |
| **Update Product** | `O(1)` | Fetches the existing item instantly via its key map. |
| **Delete Product** | `O(1)` | Removes the data node directly without shifting other items. |

---

## 🚀 How to Run the Application

1. Open this project folder in VS Code.
2. Navigate to `InventoryManagementSystem.java`.
3. Click **Run** on your code window or press `F5`.