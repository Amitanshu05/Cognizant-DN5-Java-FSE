# 🏦 Exercise 1: PL/SQL Control Structures

## 🧠 The Core Logic: Kya Pooch Raha Hai Aur Kyun?

Bank database mein millions of customers hote hain. Agar hum Java ka use karke database se 1 million records RAM mein laayenge, unhe update karenge, aur wapas database bhejenge, toh system bohot slow ho jayega (High Network I/O). 

> **The Goal:** PL/SQL (Procedural Language extension to SQL) hume allow karta hai ki hum loops (`FOR`) aur conditions (`IF/ELSE`) seedha Database ke server par hi run kar dein. Isse computation ultra-fast ho jati hai. Is exercise mein hum Bank ke real-world scenarios ko PL/SQL blocks se solve kar rahe hain.

---

## 🔑 Key Interview Terms (GenC Next Cheat Sheet)

* **PL/SQL Block:** PL/SQL code hamesha `DECLARE`, `BEGIN`, aur `END` blocks ke andar likha jata hai. Yeh ek complete unit of work hota hai.
* **Cursor:** Database memory ka ek pointer. Jab hume ek se zyada rows (multiple records) ko process karna hota hai, toh hum Cursor banate hain. Ek-ek karke row Cursor mein aati hai aur hum uspar logic lagate hain.
* **`SYSDATE`:** Oracle/SQL ka in-built function jo current date aur time return karta hai. Scenario 3 mein humne `SYSDATE + 30` use kiya future 30 days nikalne ke liye.
* **`DBMS_OUTPUT.PUT_LINE`:** Java ke `System.out.println()` ka PL/SQL version. Yeh database console par text print karne ke kaam aata hai.

---

## ⚙️ How We Coded It (The Workflow)

### Scenario 1: Senior Citizen Discount
Humne `Customers` table se sabki `age` uthayi. Ek `FOR` loop lagaya. Jiske liye bhi `IF age > 60` true nikla, humne uski `Loans` table mein jaakar interest rate 1% kam kar diya.

### Scenario 2: VIP Promotion
Yahan humne `FOR UPDATE` cursor lagaya. Iska faayda yeh hai ki jab loop chal raha hota hai, toh koi aur user us record ko change nahi kar sakta (Row-level locking). Agar balance 10,000 se zyada nikla, toh `IsVIP` ko 'TRUE' set kar diya using `WHERE CURRENT OF` (jo seedha loop ki current row ko target karta hai).

### Scenario 3: 30-Day Reminders
Yahan hume kuch update nahi karna tha, bas print karna tha. Humne `JOIN` laga kar Customers aur unke Loans ko combine kiya. Condition lagayi ki `due_date` aaj se lekar agle 30 din ke beech (`BETWEEN`) honi chahiye. Jo records filter ho ke aaye, unhe message format mein print karwa diya.