# 🏭 Exercise 2: Factory Method Design Pattern

## 🧠 The Core Logic: Kya Pooch Raha Hai Aur Kyun?

Maan lo tum ek Document Management System bana rahe ho jisme alag-alag type ki files (Word, PDF, Excel) process hoti hain. Agar tumhara main program har jagah khud `new WordDocument()` ya `new PdfDocument()` likhne lagega, toh code bohot "tightly coupled" (ek dusre par dependent) ho jayega. 

Agar kal ko company boley ki "Ab PowerPoint files bhi support karni hain", toh tumhe apna main code jagah-jagah jaakar change karna padega, jisse bugs aa sakte hain.

> **The Goal (Factory Method):** Object banane ki zimmedari (responsibility) main code se cheen kar ek alag "Factory" class ko de do. Main app ko bas "Document" chahiye, wo kaise banta hai, uske andar kya logic hai, ye Factory sambhalegi. It's like going to a restaurant—you just order a Pizza (Document), the Chef (Factory) handles the messy creation process.

---

## 🔑 Key Interview Terms (GenC Next Cheat Sheet)

* **Loose Coupling:** (Interview panel's favorite word). Iska matlab hai ki tumhara main program aur documents ek dusre se direct connected nahi hain. Main app sirf `Document` interface ko janta hai, `WordDocument` class ko nahi. Change ek jagah karo, baki code safe rehta hai.
* **`interface` (The Contract):** Java mein interface ek rulebook hoti hai. Humne `Document` interface mein bola ki `open()`, `save()`, aur `close()` methods hone hi chahiye. Word, PDF, aur Excel teeno ko yeh rules follow karne padenge.
* **`abstract class` (The Blueprint):** Ek aisi class jiska khud ka object (`new DocumentFactory()`) nahi ban sakta. Yeh bas ek framework deti hai ki isko extend karne wali sub-classes ko kya-kya banana padega (jaise `createDocument()` method).
* **`@Override`:** Yeh annotation batata hai ki hum parent class (ya interface) ke purane method ko apne naye child class ke logic se replace/implement kar rahe hain. 

---

## ⚙️ How We Coded It (The Workflow)

1. **The Products (`Document`, `WordDocument`):** Pehle humne document ka structure banaya ki har file open, save aur close hogi.
2. **The Abstract Creator (`DocumentFactory`):** Humne ek factory ka blueprint banaya jisme ek rule set kiya: *"Jo bhi is factory ko use karega, use `createDocument()` method implement karna padega."*
3. **The Concrete Creators (`PdfDocumentFactory`):** Phir humne specific factories banayi. Word Factory sirf Word document banayegi, PDF Factory sirf PDF.
4. **The Client (`FactoryMethodPatternExample`):** Main program ko jab PDF chahiye, usne direct `new PdfDocument()` nahi likha. Usne `PdfDocumentFactory` ko bulaya aur apna kaam karwa liya. System clean aur professional ho gaya.