package Queue;

/**
 * Algorithms.
 * @author Viktors Soltums
 * @version 29 Oct 2022
 *
 */

public class Queue {
    private final int[] array;
    private int head;
    private int tail;
    private final int capacity;
    private int count;

    public Queue(int size)
    {
        array = new int[size];
        capacity = size;
        head = 0;
        tail = -1;
        count = 0;
    }

    public void pushToEnd(int data) {
        if (count < capacity) {
            tail = increase(tail);
            array[tail] = data;
            count++;
        } else {

            throw new ArrayStoreException("Queue is full");
        }
    }

    public int remove() {
        if (count > 0) {
            int temp = array[head];
            array[head] = 0;
            head = increase(head);
            count--;
            return temp;
        } else {
            throw new ArrayStoreException("Queue is empty");
        }
    }

    public int peek() {
        return array[head];
    }
    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    private int increase(int num) {
        if (num + 1 == capacity) {
            num = 0;
        } else {
            num++;
        }
        return num;
    }
}
