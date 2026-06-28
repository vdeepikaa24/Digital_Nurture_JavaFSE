# 📦 Exercise 3: Sorting Customer Orders

## 📌 Project Overview
This module handles prioritizing customer orders on an e-commerce backend platform by ordering them dynamically according to their `totalPrice`. Processing high-value transactions first ensures premium delivery allocations and targeted fulfillment flows.

---

## ⚡ Core Sorting Algorithms Explained

* **Bubble Sort:** A simple, comparative sorting method that continually steps through a list, compares adjacent items, and swaps them if they are out of the desired order. Elements sequentially "bubble" to their correct destination.
* **Insertion Sort:** Builds a final sorted collection one element at a time. It removes an element from the unsorted segment and inserts it systematically into its correct relative position within the already-sorted part.
* **Merge Sort:** A structural divide-and-conquer strategy. It breaks down an array into halves recursively until individual single-item arrays remain, then merges those sub-arrays back together in highly optimized sorted paths.
* **Quick Sort:** Another highly capable divide-and-conquer mechanism. It selects an element as a **pivot** points, partitions the remaining elements into two groups based on whether they are greater or lesser than the pivot, and recursively sorts the sub-groups.

---

## 📊 Performance & Complexity Analysis

### Time and Space Complexities

| Algorithm | Best-Case Time | Average-Case Time | Worst-Case Time | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | $O(n)$ *(Optimized)* | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Quick Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ *(Call stack)* |

### Critical Performance Breakdown

* **Bubble Sort Efficiency:** If the array is inverted, Bubble Sort performs a costly $O(n^2)$ comparison matrix. On $100,000$ incoming orders, it demands roughly $10,000,000,000$ internal operations.
* **Quick Sort Efficiency:** Quick Sort bypasses localized brute-force steps by applying log-based splitting operations. For the same $100,000$ orders, it operates within average thresholds of roughly $1,700,000$ steps.

---

## 🎯 Architectural Conclusion: Why Quick Sort Wins

For handling an enterprise-level stream of production e-commerce orders, **Quick Sort is universally preferred** over Bubble Sort due to several realities:

1. **Logarithmic Scaling:** In the real world, $O(n \log n)$ execution scaling profiles reliably support massive datasets without causing thread blocks or runtime timeouts.
2. **Minimal Cache Invalidation:** Quick Sort achieves structural sorted arrays **in-place** with highly localized memory access structures, allowing CPU architecture hardware caches to fetch instruction strings with immense efficiency.
3. **Low Overhead Constants:** While Merge Sort shares an identical theoretical time speed bounds, it demands temporary array space allocation ($O(n)$ space complexity). Quick Sort maintains low space metrics while keeping execution thresholds lightning fast.