package LinkedList;

/**
 * Algorithms.
 *
 * @author Viktors Soltums
 * @version 06 Nov 2022
 * @testsLink: https://github.com/SoltVik/AlgorithmsHomeWorks/tree/main/src/test/java/TestMyLinkedList.java
 */


public class MyLinkedList implements Linked {
    private int size = 0;
    private Node first;
    private Node last;

    @Override
    public void pushToHead(int data) {
        if (first == null) {
            first = new Node(data, null);
        } else if (last == null) {
            last = first;
            first = new Node(data, last);
        } else {
            first = new Node(data, first);
        }
        size++;
    }

    @Override
    public void pushToTail(int data) {
        if (first == null) {
            first = new Node(data, null);
        } else if (last == null) {
            last = new Node(data, null);
            first.next = last;
        } else {
            Node newLast = new Node(data, null);
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    @Override
    public void pushToIndex(int index, int data) {
        if (size == 0 && index == 0) {
            pushToHead(data);
        } else if (index < size && index >= 0) {
            if (index == 0) {
                pushToHead(data);
            } else {
                int counter = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (counter == index - 1) {
                        cursor.next = new Node(data, cursor.next);
                        break;
                    }
                    cursor = cursor.next;
                    counter++;
                }
                size++;
            }
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        if (index < size && index >= 0) {
            size--;
            if (index == 0) {
                if (first.next == null) {
                    first = null;
                } else {
                    first = first.next;
                }
            } else {
                int counter = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (counter == index - 1) {
                        Node next = cursor.next;
                        if (index == size) {
                            last = cursor;
                        }
                        cursor.next = next.next;
                        break;
                    }
                    cursor = cursor.next;
                    counter++;
                }
            }
        }
    }

    @Override
    public Integer get(int index) {
        if (index < size && index >= 0) {
            if (index == 0) {
                return first.data;
            } else if (index == size - 1) {
                return last.data;
            } else {
                int counter = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (counter == index) {
                        return cursor.data;
                    }
                    cursor = cursor.next;
                    counter++;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node cursor = first;
        while (cursor != null) {
            sb.append(cursor.data);
            if (cursor.next != null) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        return sb.append("]").toString();
    }

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
