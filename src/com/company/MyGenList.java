package com.company;

public class MyGenList<T extends Element> {
    T head;

    public int getSize() {
        T element = head;
        int size = 0;
        while (element != null) {
            element = (T) element.getNext();
            size++;
        }
        return size;
    }

    public boolean addToTail(T newElement) {
        int pos = getSize();
        return add(newElement, pos);
    }

    public boolean add(T newElement, int pos) {
        T element = head;
        int i = 0;
        if (pos == 0) {
            addToHead(newElement);
            return true;
        }
        while (element != null && i < (pos - 1)) {
            element = (T) element.getNext();
            i++;
        }
        if (i == (pos - 1) && element != null) {
            newElement.setNext(element.getNext());
            element.setNext(newElement);
            return true;
        } else throw new IllegalStateException("Unable to insert at position " + pos + "!");
    }

    public boolean addToHead(T newElement) { //attach to head
        T element = head;
        if (head == null) {
            head = newElement;
        } else {
            newElement.setNext(element);
            head = newElement;
        }
        return true;
    }

    public boolean remove(int pos) {
        T element = head;
        int i = 0;
        if (pos == 0 && element != null) {
            head = (T) head.getNext();
        }
        while (element != null && i < (pos - 1)) {
            element = (T) element.getNext();
            i++;
        }
        if (i == (pos - 1) && element.getNext() != null) {
            element.setNext(element.getNext().getNext());
            return true;
        } else throw new IllegalStateException("Index " + pos + " out of bounds!");
    }

    public T getHead() {
        if (head != null) {
            T ret = head;
            head = (T) head.getNext();
            return ret;
        } else return null;
    }

    public boolean empty() {
        if (head == null) return true;
        else return false;
    }

    public void print() {
        T element = head;
        while (element != null) {
            System.out.print(element.getValue() + " ");
            element = (T) element.getNext();
        }
        System.out.println();
    }
}
