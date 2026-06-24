# 📝 Module 5, Exercise 1: Logging using SLF4J

## 🎯 Overview
In professional enterprise environments, using standard console outputs (like `System.out.println`) is strictly avoided. Instead, we use robust logging frameworks to track application behavior, monitor performance, and debug critical failures without halting the system.

[cite_start]This exercise implements **SLF4J** (Simple Logging Facade for Java) alongside the **Logback** implementation to generate structured log outputs[cite: 121, 123].

## 🧠 Key Technical Implementations
1. [cite_start]**Dependency Injection:** Integrated `slf4j-api` and `logback-classic` via Maven `pom.xml` . SLF4J acts as an interface, while Logback does the actual heavy lifting of writing the logs.
2. [cite_start]**Logger Instantiation:** Created a static immutable logger object bound to the `LoggingExample` class context[cite: 140].
3. [cite_start]**Log Levels:** * Executed `logger.error()` to simulate logging a critical system failure[cite: 142].
   * [cite_start]Executed `logger.warn()` to simulate logging a potential issue that doesn't immediately crash the system[cite: 143].