package com.company;

public class Element {
    private int value;
    private Element next;

    public Element() {
        this.next = null;
    }

    public Element(int value, Element next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
