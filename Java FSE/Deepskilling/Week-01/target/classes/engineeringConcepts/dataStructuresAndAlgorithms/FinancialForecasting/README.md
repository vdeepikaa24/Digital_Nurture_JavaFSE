# 📈 Exercise 7: Financial Forecasting

## 📌 Project Overview
This module builds a predictive Financial Forecasting tool designed to compute compound asset values down a designated sequence of years. Rather than using standard iterative index loops (`for` or `while`), this asset valuation engine handles calculations using **Recursive Functions**.

---

## 🧠 Understanding Recursive Algorithms

### What is Recursion?
Recursion is an algorithmic paradigm where a method **calls itself** to solve a problem. It works by breaking down a large structural problem into smaller, bite-sized instances of the exact same problem.

Every valid recursive algorithm relies on two parts:
1. **The Base Case:** The exit door. A fundamental condition that stops the recursion from firing infinitely by returning a concrete value instantly.
2. **The Recursive Case:** The engine. The block where the method calls itself while passing a slightly modified, smaller version of the original input parameters.

### How it Simplifies Problems
Recursion matches the nature of hierarchical or compounding problems (like compound interest, tree-traversals, or file-directory mappings). It eliminates complex tracking variables and state changes, allowing code to read identically to mathematical expressions.

---

## 📊 Performance & Complexity Analysis

### Standard Recursive Approach
In the standard `calculateFutureValue` method, predicting the outcome for $n$ years causes the function to call itself exactly $n$ times.
* **Time Complexity:** $O(n)$ — Execution time scales linearly with the forecast horizon.
* **Space Complexity:** $O(n)$ — Every self-call allocates a new frame on the system's runtime **Call Stack**. If you forecast 5,000 years out, you risk triggering a `java.lang.StackOverflowError`.

---

## 🛠️ Optimization Strategies

To prevent excessive performance bottlenecks and mitigate call stack limitations, recursive solutions can be optimized using two main techniques:

### 1. Divide & Conquer Exponentiation (Implemented Above)
Instead of processing years linearly ($Years - 1$), we use fast recursive squaring. By computing half the problem size at each step (e.g., $x^{16} = x^8 \times x^8$), we cut down the execution profile drastically.
* **Optimized Time Complexity:** $O(\log n)$
* **Optimized Space Complexity:** $O(\log n)$ (Drastically lowers the stack depth. A 1,000-year forecast drops from 1,000 call frames down to just 10!).

### 2. Memoization (Caching)
For more volatile or multi-variable models (such as tracking changing annual growth rates matching Fibonacci behavior sequences), you can introduce a lookup cache. Before performing any recursive calls, the algorithm checks a temporary map:
* If the calculation for that year was already handled previously, it returns the cached result in $O(1)$ time.
* This completely eliminates redundant tree branch recalculations.