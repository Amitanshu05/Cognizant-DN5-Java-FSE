# 📈 Exercise 7: Financial Forecasting (Recursion)

## 🧠 The Core Logic: Kya Pooch Raha Hai Aur Kyun?

Jab hum compound interest ya kisi startup ka future revenue predict karte hain, toh har aane wale saal ka profit pichle saal ke base par calculate hota hai. 
Example: *Year 3 = Year 2 * (1 + rate)*.
Kyunki har step ek hi jaisa calculation kar raha hai, hum ise loop ki jagah **Recursion** (function calling itself) se likh sakte hain. Recursion complex mathematical formulas ko code mein bohot simple aur readable bana deta hai.

> **The Problem:** Agar humein 1000 years aage ka forecast chahiye, toh normal recursion 1000 baar apne aap ko call karega. Ise "Excessive Computation" kehte hain, jisse memory full ho sakti hai (Stack Overflow). Humein ise optimize karna hai.

---

## 🔑 Key Interview Terms (GenC Next Cheat Sheet)

* **Recursion:** Ek aisi programming technique jahan ek function apne aap ko call karta hai ek choti problem solve karne ke liye, jab tak ki wo ek stopping point (Base Case) par na pohoch jaye.
* **Base Case:** Recursion ka "brake". Agar base case nahi hoga, toh function infinite loop mein chala jayega aur system crash ho jayega. Humare code mein `if (periods == 0)` base case hai.
* **Call Stack:** Memory ka wo hissa jahan Java track rakhta hai ki konsa function run ho raha hai. Excessive recursion call stack ko bhar deta hai.

---

## ⚖️ Analysis: Time Complexity & Optimization

### 1. Standard Recursion (The Slower Way)
* **Time Complexity:** O(N) 
* **Explanation:** Agar 10 saal ka data nikalna hai, toh function 10 baar multiply karega. `periods - 1` har step mein 1 subtract karta hai. It scales linearly.

### 2. Optimized Recursion: Fast Exponentiation (The Pro Way)
* **Time Complexity:** O(log N)
* **Explanation:** Humne "Divide and Conquer" (Exponentiation by Squaring) use kiya. Agar humein $X^{10}$ nikalna hai, toh hum $X$ ko 10 baar multiply karne ki jagah, pehle $X^5$ nikalte hain, aur phir bas $(X^5 \times X^5)$ kar dete hain. 
* **Why it's better:** Problem size har step mein aadhi (half) ho jati hai. Jiske liye O(N) ko 1000 steps lagte, wo O(log N) sirf ~10 steps mein kar dega. Yeh interviewers ko bohot impress karega!