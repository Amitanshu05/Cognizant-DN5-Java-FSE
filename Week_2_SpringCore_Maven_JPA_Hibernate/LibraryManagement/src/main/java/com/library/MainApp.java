package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Spring Container...");
        
        // Use ClassPathXmlApplicationContext explicitly taaki close method mil sake
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Bean nikal rahe hain
        BookService service = (BookService) context.getBean("bookServiceBean");
        
        // Execute kar rahe hain
        service.manageLibrary();
        
        // 🧹 WARNING FIX: Memory leak bachane ke liye context close kar diya
        context.close();
        
        System.out.println("✅ Exercise 1 Completed Successfully!");
    }
}