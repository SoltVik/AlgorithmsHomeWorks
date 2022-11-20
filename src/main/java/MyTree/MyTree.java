package MyTree;

/**
 * Algorithms.
 *
 * @author Viktors Soltums
 * @version 13 Nov 2022
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyTree implements ITree, Comparable<MyTree> {
    private int value;
    private MyTree left;
    private MyTree right;

    public MyTree(int value) {
        this.value = value;
    }

    public MyTree(int value, MyTree left, MyTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public MyTree balanceTree() {
        ArrayList<Integer> list = this.getAllValues();

        MyTree temp = new MyTree(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            temp.insertNode(list.get(i));
        }
        return temp;
    }

    private void insertNode(int value) {
        MyTree newNode = new MyTree(value);
        MyTree currentNode = this;
        MyTree parentNode;
        while (true) {
            parentNode = currentNode;
            if (currentNode.compareTo(newNode) == 0) {
                return;
            } else if (currentNode.compareTo(newNode) > 0) {
                currentNode = currentNode.left;
                if (currentNode == null) {
                    parentNode.left = newNode;
                    return;
                }
            } else {
                currentNode = currentNode.right;
                if (currentNode == null) {
                    parentNode.right = newNode;
                    return;
                }
            }
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    private ArrayList<Integer> getAllValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<MyTree> queue = new LinkedList<>();

        queue.offer(this);
        while (!queue.isEmpty()) {
            MyTree tree = queue.poll();

            if (tree.left != null) {
                queue.offer(tree.left);
            }

            if (tree.right != null) {
                queue.offer(tree.right);
            }

            list.add(tree.value);
        }
        return list;
    }

    @Override
    public String toString() {
        return this.getAllValues().toString();
    }

    @Override
    public int compareTo(MyTree o) {
        return this.value - o.value;
    }
}
