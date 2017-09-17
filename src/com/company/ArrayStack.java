package com.company;

public class ArrayStack implements Stack {

    private int top;
    private int size;
    private Integer[] stackTable;

    public ArrayStack(int size) {
        this.stackTable = new Integer[size];
        this.size = size;
        top = 0;
    }

    @Override
    public boolean empty() {
        if (top == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean push(int e) {
        if (top == size) {
            throw new IllegalStateException("Stack full, only pop method can help you...");
        } else {
            stackTable[top] = e;
            top++;
            return true;
        }
    }

    @Override
    public int pop() {
        if (top == 0) {
            throw new IllegalStateException("Stack is empty, cannot pop from stack!");
        }
        top--;
        int val = stackTable[top];
        stackTable[top] = null;
        return val;
    }

    @Override
    public int peek() {
        if (top == 0) {
            throw new IllegalStateException("Stack is empty, cannot do peek");
        }
        return stackTable[top - 1];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(4);
        for (int i = 0; i < 4; i++) {
            arrayStack.push(5*i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayStack.pop());
        }
        System.out.println(arrayStack.pop());
        //System.out.println(arrayStack.pop());
    }
}
