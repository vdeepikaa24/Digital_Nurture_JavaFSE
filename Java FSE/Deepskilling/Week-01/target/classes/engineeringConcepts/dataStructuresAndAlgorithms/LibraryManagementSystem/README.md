# 📚 Exercise 6: Library Management System

## 📌 Project Overview
This module designs search operations for a Library Management System. It allows readers to search for matching records within a catalog repository using either standard sequential entry checks (**Linear Search**) or mathematical cut-in-half splits (**Binary Search**).

---

## 🧠 Search Mechanics Deep Dive

### Linear Search
Linear Search steps through a collection systematically from index $0$ to $n-1$, checking if the current element matches our target criteria. It has zero architectural requirements—the dataset can be completely random, unsorted, or stored across linked nodes.

### Binary Search
Binary Search employs a **divide-and-conquer** optimization approach. It looks at the midpoint of a collection. If the target value isn't matched, it rules out an entire half of the search pool based on alphabetical order. This process is repeated recursively. **Constraint:** The data *must* be sorted ahead of execution.

---

## 📊 Performance & Complexity Analysis

### Complexity Matrix

| Algorithm | Best-Case Time | Average-Case Time | Worst-Case Time | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Linear Search** | $O(1)$ | $O(n)$ | $O(n)$ | $O(1)$ |
| **Binary Search** | $O(1)$ | $O(\log n)$ | $O(\log n)$ | $O(1)$ |

### Real-World Scaling Impact
If a municipal or university library expands its archive collection registry to $100,000$ books:
* **Linear Search** requires making up to **100,000 index comparisons** if a book is missing or sits at the absolute end.
* **Binary Search** cuts down the remaining bounds continuously, completing the same search in a maximum of **17 comparisons**.

---

## 🎯 Strategic Decision Matrix: When to Use Each?

Choosing the correct lookup tool depends heavily on data scale constraints and update behavior metrics:

### Use Linear Search When:
1. **The Dataset is Small:** For minor arrays (e.g., fewer than 50 books), the overhead of checking elements linearly is so tiny that it executes instantaneously.
2. **The Data is Frequently Changing or Unsorted:** If the library catalog is continuously receiving random new book drops, sorting the array constantly takes $O(n \log n)$ time. It is cheaper to use Linear Search directly on raw unsorted data rather than maintaining order.

### Use Binary Search When:
1. **The Dataset is Large:** Essential for enterprise-scale platforms tracking thousands or millions of inventory rows.
2. **The Dataset is Read-Heavy & Stable:** In a standard archive directory, books are searched thousands of times an hour, while new book inventory acquisitions happen relatively rarely. Sorting the array once allows you to leverage fast $O(\log n)$ speeds for millions of future searches.