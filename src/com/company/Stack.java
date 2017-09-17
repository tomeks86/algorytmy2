package com.company;

public interface Stack {
    boolean empty();
    boolean push(int e) throws IllegalStateException;
    int pop() throws IllegalStateException;
    int peek() throws IllegalStateException;
}
