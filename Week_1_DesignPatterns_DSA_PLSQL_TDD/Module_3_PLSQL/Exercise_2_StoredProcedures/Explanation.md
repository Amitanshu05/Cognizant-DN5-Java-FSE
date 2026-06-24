# ⚙️ Exercise 3: PL/SQL Stored Procedures

## 🧠 The Core Logic: Kya Pooch Raha Hai Aur Kyun?

Jab hum Java ya Python se database ko query bhejte hain, toh data network ke through travel karta hai. Agar hume 10,000 accounts mein interest add karna hai, toh Java se baar-baar commands bhejna bohot slow hoga. 

> **The Goal:** Stored Procedures database ke andar save kiye gaye programs hote hain. Hum apna logic seedha Database Server par store kar dete hain. Ab Java ko bas ek line bolni hoti hai: `CALL ProcessMonthlyInterest()`, aur server turant data update kar deta hai. Yeh fast, secure, aur reusable hota hai.

---

## 🔑 Key Interview Terms (GenC Next Cheat Sheet)

* **Stored Procedure (`CREATE OR REPLACE PROCEDURE`):** Ek naam wala PL/SQL block jo database mein permanent save ho jata hai aur baaki applications isko trigger kar sakti hain.
* **IN Parameters (`p_amount IN NUMBER`):** Yeh functions ke arguments hote hain. `IN` ka matlab hai ki hum values procedure ke andar bhej rahe hain (jaise department id ya bonus percentage).
* **ACID Properties (Atomicity):** Scenario 3 mein funds transfer ho rahe hain. Atomicity ka rule hai: "Ya toh poora transaction hoga, ya kuch nahi hoga." Aisa nahi ho sakta ki source se paise kat jayein aur target mein add na hon.
* **`COMMIT` aur `ROLLBACK`:** `COMMIT` ka matlab hai changes ko permanently database mein save kar do. `ROLLBACK` ka matlab hai "Undo"—agar koi error aa jaye ya balance kam ho, toh database ko uski purani state mein waapas bhej do.
* **`FOR UPDATE`:** Yeh concurrency control karta hai. Agar ek user ATM se paise nikal raha hai aur dusra user usi time GPay kar raha hai, toh `FOR UPDATE` us account ki row par lock laga deta hai taaki data clash (race condition) na ho.

---

## 🛠️ How We Coded It (The Workflow)

### Scenario 1: Process Monthly Interest
Yahan humne directly `UPDATE` query chalayi hai bina kisi parameters ke. `balance = balance + (balance * 0.01)` mathematically saare savings accounts ka balance 1% bada dega.

### Scenario 2: Employee Bonus
Yeh ek parameterized procedure hai. Humne `p_department_id` aur `p_bonus_percentage` as input accept kiye. Query dynamically sirf usi department ke employees ka salary update karegi jo parameter mein pass kiya gaya hai.

### Scenario 3: Secure Fund Transfer (The Banking Standard)
Banking logic requires heavy security. 
1. Pehle humne source account ka balance check kiya.
2. Agar balance amount se zyada ya equal hai, tabhi humne do `UPDATE` statements chalaye (deduct and add).
3. Agar balance kam hai, toh humne `RAISE_APPLICATION_ERROR` use karke custom error feka aur transaction ko `ROLLBACK` kar diya taaki paise safe rahein.