package com.company;

public class MyList implements List{
    Element head;

    @Override
    public boolean add(int value, int pos) {
        Element element = head;
        int i = 0;
        if (pos == 0) {
            addToHead(value);
            return true;
        }
        while (element != null && i < (pos - 1)) {
            element = element.getNext();
            i++;
        }
        if (i == (pos - 1) && element != null) {
            Element newElement = new Element(value, element.getNext());
            element.setNext(newElement);
            return true;
        } else throw new IllegalStateException("Unable to insert at position " + pos + "!");
    }

    public boolean addToHead(int value) { //attach to head
        if (head == null) {
            head = new Element(value,null);
        } else {
            Element element = new Element(value, head);
            head = element;
            //head.setNext(element);
        }
        return true;
    }

    @Override
    public boolean remove(int pos) {
        Element element = head;
        int i = 0;
        if (pos == 0 && element != null) {
            head = head.getNext();
        }
        while (element != null && i < (pos - 1)) {
            element = element.getNext();
            i++;
        }
        if (i == (pos - 1) && element.getNext() != null) {
            element.setNext(element.getNext().getNext());
            return true;
        } else throw new IllegalStateException("Index " + pos + " out of bounds!");
    }

    @Override
    public boolean removeElement(int value) {
        Element element = head;
        if (element.getValue() == value) {  //element found at head
            head = element.getNext();
            return true;
        }
        while (element.getNext() != null && element.getNext().getValue() != value) {
            element = element.getNext();
        }
        if (element.getNext() != null && element.getNext().getValue() == value) {
            element.setNext(element.getNext().getNext());
            return true;
        } else throw new IllegalStateException("Value " + value + " not found in the list!");
    }

    @Override
    public int find(int e) {
        Element element = head;
        int i = 0;
        while (element != null && element.getValue() != e) {
            element = element.getNext();
            i++;
        }
        if (element == null) throw new IllegalStateException("Element " + e + " not found! List range exceeded!");
        if (element.getValue() == e) return i;
        else return -1;
    }

    @Override
    public int first() {
        if (head != null) return head.getValue();
        else return -1;
    }

    @Override
    public int last() {
        if (head != null) {
            Element element = head;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            return element.getValue();
        } else return -1;
    }

    @Override
    public boolean empty() {
        if (head == null) return true;
        else return false;
    }

    @Override
    public void print() {
        Element element = head;
        while (element != null) {
            System.out.print(element.getValue() + " ");
            element = element.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        for (int i = 0; i < 10; i++) {
            myList.addToHead((i + 1) * 2);
        }
        myList.addToHead(15);
        myList.addToHead(-14);
        myList.print();

        //System.out.println(myList.find(1));

        myList.remove(10);
        myList.print();
        myList.remove(10);
        myList.add(124,10);
        myList.print();
        myList.removeElement(8);
        myList.print();
        System.out.println("first element is: " + myList.first());
        System.out.println("last element is: " + myList.last());
        System.out.println("is myList empty? " + myList.empty());
    }
}
