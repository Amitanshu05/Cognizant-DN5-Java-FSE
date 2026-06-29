# 📚 Library Management System (Spring Core)

This project demonstrates the foundational concepts of the Spring Framework (Week 2). It is divided into two exercises that explain how Spring manages objects and their relationships.

---

## 🎯 Exercise 1: Inversion of Control (IoC)
**The Concept:** Usually, a programmer creates objects manually using the `new` keyword (e.g., `BookService service = new BookService();`). In Spring, we give this control to the Spring Framework. This reversal of responsibility is called Inversion of Control (IoC).

**How we did it:**
1. Added `spring-context` dependency in `pom.xml` to bring in the Spring IoC Container.
2. Created `applicationContext.xml` and defined our classes as `<bean>`. 
3. Spring reads this XML and automatically creates the objects for `BookRepository` and `BookService` and keeps them in its memory (Context).
4. In `MainApp.java`, we just asked Spring: *"Give me the BookService bean"* using `context.getBean()`. The `new` keyword is completely eliminated!

---

## 💉 Exercise 2: Dependency Injection (DI)
**The Concept:**
Our `BookService` needs `BookRepository` to fetch data. They are dependent on each other. Instead of the Service finding the Repository, Spring actively "injects" the Repository object into the Service object.

**How we did it (Setter Injection):**
1. In `BookService.java`, we created a setter method: `setBookRepository(BookRepository repo)`.
2. In `applicationContext.xml`, inside the `bookServiceBean`, we added:
   `<property name="bookRepository" ref="bookRepositoryBean" />`
3. **The Magic:** Spring created the `BookRepository` object, saw the `<property>` tag, and automatically passed that object into the `setBookRepository()` method of `BookService`. 
4. We added a print statement inside the setter method to mathematically prove that Spring did the injection automatically.

---

## 📁 Industry Standard Folder Structure Used
```text
LibraryManagement/
├── pom.xml (Maven Configuration)
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── library/
        │           ├── repository/
        │           │   └── BookRepository.java (Database Simulation Layer)
        │           ├── service/
        │           │   └── BookService.java (Business Logic Layer)
        │           └── MainApp.java (Entry Point)
        └── resources/
            └── applicationContext.xml (Spring Configuration File)

## ?? Exercise 4: Maven Project Configuration
**The Goal:** Add multiple Spring dependencies (Context, AOP, WebMVC) and configure the Maven Compiler Plugin.
**How we did it:** Updated the pom.xml with <dependencies> block for Spring modules and added the maven-compiler-plugin inside the <build> tag, explicitly setting the source and target to Java 1.8.
