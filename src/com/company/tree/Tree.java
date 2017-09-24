package com.company.tree;

import com.company.MyGenList;

public class Tree {
    Node root;

    public static void preOrder(Node newRoot) {
        if (newRoot != null) {
            System.out.print(newRoot.getValue() + " ");
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

    public static void postOrder(Node newRoot) {
        if (newRoot != null) {
            postOrder(newRoot.getLeft());
            postOrder(newRoot.getRight());
            System.out.print(newRoot.getValue() + " ");
        }
    }

    public static void bfs(MyGenList<Node> childrenList) {
        MyGenList<Node> newChildrenList = new MyGenList<>();
        while (!childrenList.empty()) {
            Node currNode = childrenList.getHead();
            if (currNode.getLeft() != null) {
                newChildrenList.addToTail(currNode.getLeft());
            }
            if (currNode.getRight() != null) {
                newChildrenList.addToTail(currNode.getRight());
            }
            System.out.print(currNode.getValue() + " ");
        }
        if (!newChildrenList.empty()) {
            System.out.println();
            bfs(newChildrenList);
        }
    }

    public static int getDepth(int dpZero, Node element) {
        int dpL = dpZero, dpR = dpZero;
        if (element.getLeft() != null) {
            dpL++;
            dpL = getDepth(dpL, element.getLeft());
        }
        if (element.getRight() != null) {
            dpR++;
            dpR = getDepth(dpR, element.getRight());
        }
        return (dpL > dpR) ? dpL : dpR;
    }

    /*public static int treeHeight(Node newRoot, int height) {
        if (newRoot != null) {
            height++;
            treeHeight(newRoot.left, height);
            treeHeight(newRoot.right, height);
        }
        return height;
    }*/

    public static void main(String[] args) {
        int T[][] = {{5,1,2},
                {4,3,4},
                {3,5,6},
                {6,7,8},
                {2,9,0},
                {3,0,0},
                {5,0,0},
                {1,0,0},
                {8,0,0},
                {3,0,0}};

        Node[] myTree = new Node[T.length];
        for (int i = 0; i < T.length; i++) {
            myTree[i] = new Node(T[i][0]);
        }
        for (int i = 0; i < T.length; i++) {
           if (T[i][1] > 0) myTree[i].setLeft(myTree[T[i][1]]);
           if (T[i][2] > 0) myTree[i].setRight(myTree[T[i][2]]);
        }

        MyGenList<Node> myGenList = new MyGenList<>();
        myGenList.addToHead(myTree[0]);
        bfs(myGenList);
        System.out.println();
        System.out.println(getDepth(0,myTree[0]));
        //System.out.println(myTree[0].right.right.right.right.value);
        //preOrder(myTree[0]);
        //inOrder(myTree[0]);
        //postOrder(myTree[0]);
        //System.out.println(treeHeight(myTree[0],0));
    }
}
