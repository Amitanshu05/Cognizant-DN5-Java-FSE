# 🚀 Exercise 1: Singleton Design Pattern

## 🧠 The Core Logic: Kya Pooch Raha Hai Aur Kyun?

Imagine tum ek heavy data parser API ya complex diagnostic pipeline bana rahe ho. App mein hazaron lines ka code hai aur bohot saare functions ek saath chal rahe hain. Agar har function apna khud ka naya `Logger` object banane lag gaya (`new Logger()`), toh do badi problems aayengi:

* **Memory Waste:** Faltu mein hazaron objects RAM gher lenge.
* **Data Clash:** Agar 10 objects ek hi log file mein ek saath likhne ki koshish karenge, toh text mix ho jayega ya file corrupt ho jayegi.

> **The Goal:** Ek aisi `Logger` class design karo jiska application ki puri life mein sirf aur sirf **EK hi object (Single Instance)** ban paye. Chahe koi kitni baar bhi logger maange, usko wahi same ek object milna chahiye. Isko "Singleton Pattern" bolte hain.

---

## 🔑 Key Interview Terms (GenC Next Cheat Sheet)

Agar Java nayi lag rahi hai, toh in terms ko apni dictionary mein add kar lo:

* **`private` (The Bouncer):** Java mein iska matlab hai "No Entry". Humne constructor ko private kar diya hai, taaki bahar ka koi bhi file galti se bhi `new Logger()` use karke object na bana sake.
* **`static` (The Shared Asset):** Yeh batata hai ki variable kisi ek object ka nahi, balki puri **Class** ki property hai. Memory mein iski sirf ek hi fixed jagah hoti hai, jise sab share karte hain.
* **`volatile` (The Freshness Guarantee):** Yeh Java ko strict order deta hai: *"Is variable ko local cache mat karna. Hamesha seedha Main Memory (RAM) se fresh value uthana."* Yeh multithreading ke bugs ko rokta hai.
* **`synchronized` (The Traffic Signal):** Yeh ek lock laga deta hai. Yeh ensure karta hai ki us code block ke andar ek time par sirf ek hi process (thread) enter kar sake, taaki galti se do objects na ban jayein.

---

## ⚙️ How We Coded It (The 3 Steps)

Real-life example: Tumhare college ka ek hi Principal hota hai. Agar har student apna naya Principal bana lega, toh system crash ho jayega. Hum bas ek global Logger chahte hain. Java mein isko 3 steps mein achieve karte hain:

1. **The Private Constructor (`private Logger()`):** Darwaza andar se lock kar diya. Koi aur class naya object create nahi kar sakti.
2. **The Static Variable (`private static Logger instance`):** Class ke andar hi ek fixed copy bana li jo memory mein ek hi baar store hogi.
3. **The Gateway Method (`public static Logger getInstance()`):** Darwaza lock hai, toh log is method ke through logger maangenge. Yeh check karta hai: kya object pehle se bana hai? Agar nahi, toh naya banata hai. Agar haan, toh purana wala hi return kar deta hai (Lazy Initialization).

> **💡 Interview Bonus Point (Double-Checked Locking):** Code mein `synchronized` block isliye lagaya hai kyunki agar 2 threads ekdum same millisecond par `getInstance()` call kar dein, toh dono ko lagega ki object `null` hai, aur wo 2 objects bana denge. Lock lagane se application thread-safe banti hai.


