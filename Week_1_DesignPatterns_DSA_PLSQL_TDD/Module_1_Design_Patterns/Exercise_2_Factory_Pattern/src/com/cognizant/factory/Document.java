package com.cognizant.factory;

/**
 * Common interface for all document types.
 */
public interface Document {
    void open();
    void save();
    void close();
}