# 👥 Exercise 4: Employee Management System

## 📌 Project Overview
This module models a foundational corporate Employee Management System. It tracks organizational member entries (`Employee`) by managing raw record allocations using a primitive array layout. 

---

## 🧠 Array Representation in Memory

### How Arrays Work Under the Hood
An array is a **contiguous block of memory** where elements of the exact same data type are stored sequentially right next to each other. 

When you instantiate `new Employee[5]`, Java reserves a single, unbroken block of memory addresses. 

* **The Formula:** Because it is contiguous, accessing any index ($i$) uses a fast base-offset address calculator:
  $$\text{Address of Element} = \text{Base Address} + (i \times \text{Size of Object Reference})$$

### Core Advantages of Arrays
1. **O(1) Random Access:** Because of the mathematical offset formula above, you can hop directly to any index instantaneously without traversing the elements before it.
2. **Memory Efficiency:** Arrays carry virtually zero architectural overhead compared to node-based structures like LinkedLists (which require storing extra explicit data pointers like `next` and `prev`).
3. **CPU Cache Friendliness:** Since elements reside sequentially in physical memory hardware, modern CPU spatial locality pre-fetching mechanisms can load blocks of adjacent elements into the processor cache simultaneously, minimizing runtime cache misses.

---

## 📊 Operations & Time Complexity Analysis

| Operation | Time Complexity | Why? |
| :--- | :--- | :--- |
| **Add (Append)** | $O(1)$ | Inserting at the end (`size` tracker position) maps directly to an index and executes in constant time. |
| **Search** | $O(n)$ | In an unsorted configuration, checking for a specific property (like `employeeId`) requires a linear scan from the beginning to the end. |
| **Traverse** | $O(n)$ | Printing or operating on every single item demands stepping sequentially through all active elements. |
| **Delete** | $O(n)$ | Once the item is located, all subsequent elements must be structurally shifted left to close the gap and prevent empty null voids. |

---

## ⚠️ Core Limitations of Arrays

* **Fixed Capacity Constraint:** Once defined, an array's length cannot be dynamically expanded or shrunk. If a company outgrows its original array sizing boundaries, a brand new array must be fully allocated, and all existing objects must be re-copied ($O(n)$ overhead cost).
* **Expensive Structural Deletions/Insertions:** Manipulating items positioned at index 0 requires rippling shifts throughout the remaining array bounds.

### When should you use an Array?
Arrays are the absolute perfect data choice when:
1. The **maximum dataset scale limits are fixed** and known reliably ahead of execution boundaries.
2. The primary operational bottleneck is heavily dependent on performing **rapid lookups by index** rather than ongoing random insertions or deletions.