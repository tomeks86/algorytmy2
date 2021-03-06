package com.company;

import com.company.tree.Node;

import java.util.ArrayList;

public class BST {
    static Node root;

    public static void addNode(int value) {
        Node node = root;
        //while(node.getLeft() != null | node.getRight() != null) {
        while (node != null) {
            if (value > node.getValue()) {
                if (node.getRight() != null) node = node.getRight();
                else {
                    node.setRight(new Node(value));
                    break;
                }
            } else {
                if (node.getLeft() != null) node = node.getLeft();
                else {
                    node.setLeft(new Node(value));
                    break;
                }
            }
        }
    }

    public static Node search(int value) {
        Node node = root;
        //while (node.getLeft() != null | node.getRight() != null) {
        while (node != null & node.getValue() != value) {
            if (value > node.getValue()) {
                node = node.getRight();
            } else node = node.getLeft();
        }
        return node;
    }

    /*private static Node[] search2(int value) {
        Node node = root;
        Node[] result = new Node[2];
        if (node.getValue() == value) {
            result[0] = null;
            result[1] = root;
        } else {
            while (node != null & node.getValue() != value) {
                if (node.getLeft().getValue() == value) {
                    result[0] = node;
                    result[1] = node.getLeft();
                } else if (node.getRight().getValue() == value) {
                    result[0] = node;
                    result[1] = node.getRight();
                }
            }
        }
        return result;
    }*/

    public static void preOrder(Node newRoot) {
        if (newRoot != null) {
            System.out.println(newRoot.getValue());
            preOrder(newRoot.getLeft());
            preOrder(newRoot.getRight());
        }
    }

    public static void inOrder(Node newRoot) {
        if (newRoot != null) {
            inOrder(newRoot.getLeft());
            System.out.print(newRoot.getValue() + " ");
            inOrder(newRoot.getRight());
        }
    }

    public static ArrayList<Integer> inOrderList(Node newRoot, ArrayList<Integer> lista) {
        if (newRoot != null) {
            inOrderList(newRoot.getLeft(), lista);
            lista.add(newRoot.getValue());
            inOrderList(newRoot.getRight(), lista);
        }
        return lista;
    }

    public static int depth(int initDepth, Node node) {
        int dpL = initDepth, dpR = initDepth;
        if (node.getLeft() != null) dpL = depth(++dpL, node.getLeft());
        if (node.getRight() != null) dpR = depth(++dpR, node.getRight());
        return (dpL > dpR ? dpL : dpR);
    }

    public static void print() {    //BFS
        ArrayList<Node> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
            //int lvl = -1;
            int i = 0;
            int ndSize = 1;
            while (i < nodes.size()) {
                for (int j = i; j < ndSize; j++) {
                    if (nodes.get(j).getLeft() != null) nodes.add(nodes.get(j).getLeft());
                    if (nodes.get(j).getRight() != null) nodes.add(nodes.get(j).getRight());
                    i++;
                    System.out.print(nodes.get(j).getValue() + " ");
                    //System.out.println(i + " " + j);
                }
                ndSize = nodes.size();
                System.out.println();
                //lvl++;
            }
            /*for (int j = 0; j < nodes.size(); j++) {
                System.out.print(nodes.get(j).getValue() + " ");
            }*/
            //System.out.println();
            //System.out.println("level is: " + lvl);
        }
    }

    public static boolean remove(int value) {
        Node prevNode = root;
        if (prevNode.getValue() == value) { //start of the root exchange block
            if (prevNode.getRight() != null) { //search for the leftmost node in the right branch of root
                prevNode = prevNode.getRight();
                if (prevNode.getLeft() == null) {
                    prevNode.setLeft(root.getLeft());
                    root = prevNode;
                    return true;
                }
                Node nextNode = prevNode.getLeft();
                while (nextNode.getLeft() != null) {
                    prevNode = prevNode.getLeft();
                    nextNode = nextNode.getLeft();
                }
                if (nextNode.getRight() != null) { //relink the nodes: 1) prevNode.setLeft(nextNode.getRight()), 2) nextNode -> root (and links)
                    prevNode.setLeft(nextNode.getRight());
                    nextNode.setLeft(root.getLeft());
                    nextNode.setRight(root.getRight());
                    root = nextNode;
                } else { // just nextNode -> root
                    prevNode.setLeft(null);
                    nextNode.setLeft(root.getLeft());
                    nextNode.setRight(root.getRight());
                    root = nextNode;
                }
            } else { //root node has nothing on the RHS
                root = root.getLeft();
                return true;
            }
        } //end of the root exchange block
        //if value was not found in the root block...
        Node nextNode = null;
        if (value > prevNode.getValue()) { //initialization of the nextNode
            nextNode = prevNode.getRight();
        } else {
            nextNode = prevNode.getLeft();
        }
        while (nextNode != null) {
            if (nextNode.getValue() == value) break;
            if (value > nextNode.getValue()) {
                prevNode = nextNode;
                nextNode = nextNode.getRight();
            } else {
                prevNode = nextNode;
                nextNode = nextNode.getLeft();
            }
        }
        if (nextNode == null) return false;
        else { // 3(4) possibilities here depending on the nextNode children count
            if (nextNode.getLeft() == null && nextNode.getRight() == null) { // delete if no children
                //nextNode = null;
                if (value > prevNode.getValue()) prevNode.setRight(null);
                else prevNode.setLeft(null);
                return true;
            } else if (nextNode.getLeft() != null && nextNode.getRight() == null) { // no right child
                if (nextNode.getLeft().getValue() > prevNode.getValue()) {
                    prevNode.setRight(nextNode.getLeft());
                } else {
                    prevNode.setLeft(nextNode.getLeft());
                }
            } else if (nextNode.getLeft() == null && nextNode.getRight() != null) { // no left child
                if (nextNode.getRight().getValue() > prevNode.getValue()) {
                    prevNode.setRight(nextNode.getRight());
                } else {
                    prevNode.setLeft(nextNode.getRight());
                }
            } else { // we have two children!
                Node prevNode1 = nextNode;
                Node nextNode1 = nextNode.getRight();
                while (nextNode1.getLeft() != null) {
                    prevNode1 = nextNode1;
                    nextNode1 = nextNode1.getLeft();
                }
                if (nextNode1.getRight() != null) { //node1.right reconnected @ prev1.left
                    prevNode1.setRight(nextNode1.getRight());
                }
                if (nextNode1.getValue() > prevNode.getValue()) {
                    prevNode.setRight(nextNode1);
                } else {
                    prevNode.setLeft(nextNode1);
                }
                nextNode1.setLeft(nextNode.getLeft());
                if (nextNode.getRight() != nextNode1) {
                    nextNode1.setRight(nextNode.getRight());
                }
            }
            return true;
        }
    }

    public static boolean isOrdered(ArrayList<Integer> table) {
        int cur = table.get(0);
        for (int i = 1; i < table.size(); i++) {
            if (table.get(i) < cur) return false;
            else cur = table.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        root = new Node(5);
        //int[] nums = {4,3,2,6,3,7,6,-1,4,54,10,55};
        int[] nums = {32, 4, 65, -32, 5, 3, 6, 3, 2, 8, -1, 3, 4};
        for (int num : nums) {
            addNode(num);
        }
        print();
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println();

        //preOrder(root);

        //System.out.println(search(54).getValue());
        System.out.println(remove(3));
        System.out.println(remove(3));
        System.out.println(remove(10));
        System.out.println(remove(4));
        System.out.println(remove(-1));
        //System.out.println(remove(55)); // problem
        System.out.println();
        print();
        System.out.println();
        inOrder(root);
        System.out.println();
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println(inOrderList(root,test).toString());
        System.out.println(isOrdered(test));
    }
}
