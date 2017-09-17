package com.company;

public interface List {
    boolean add(int value, int pos);
    boolean remove(int pos);
    boolean removeElement(int value);
    int find(int e);
    int first();
    int last();
    boolean empty();
    void print();
}
