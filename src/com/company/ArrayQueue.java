package com.company;

import java.util.Arrays;

public class ArrayQueue implements Queue {
    private Integer[] queueArray;
    private int size;
    private int start = 0;
    private int end = 0;

    public ArrayQueue(int size) {
        this.size = size;
        queueArray = new Integer[size];
    }

    @Override
    public boolean empty() {
        if (start == end) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(int e) {
        if ((end - start) < size) {
            queueArray[end % size] = e;
            end++;
        } else throw new IllegalStateException("Queue full!");
        return true;
    }

    @Override
    public int poll() {
        if (start != end) {
            int val = queueArray[start];
            queueArray[start] = null;
            start++;
            if (start == size) {    //when start of the queue jumps to size -> change it to zero and reset end with (% size) operation
                start %= size;
                end %= size;
            }
            return val;
        } else throw new IllegalStateException("Queue empty!");
    }

    @Override
    public int peek() {
        if (!empty()) {
            return queueArray[start];
        } else throw new IllegalStateException("Queue empty!");
    }

    public String toString(){
        return Arrays.toString(queueArray);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println(arrayQueue.empty());
        for (int i = 0; i < 5; i++) {
            arrayQueue.add(i+1);
        }
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        System.out.println(arrayQueue.empty());
        arrayQueue.add(6);
        arrayQueue.add(7);
        arrayQueue.add(7);
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.add(9);
        arrayQueue.add(2);
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.add(32);
        arrayQueue.add(-32);
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.add(9);
        arrayQueue.add(2);
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        arrayQueue.add(32);
        System.out.println(arrayQueue.toString());
        System.out.println(arrayQueue.getStart() + " " + arrayQueue.getEnd());
    }
}
