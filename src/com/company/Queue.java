package com.company;

public interface Queue {
    boolean empty();
    boolean add(int e);
    int poll();
    int peek();
}
