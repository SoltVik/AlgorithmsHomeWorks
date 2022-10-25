/**
 * Algorithms.
 * @author Viktors Soltums
 * @version 22 Oct 2022
 *
 */
package DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class DynamicArray implements Dynamic, Iterable<Integer>, Comparable<DynamicArray>{
    private int[] array;
    private int counter = 0;
    private int size = 0;
    private final int DEFAULT_SIZE = 10;

    DynamicArray(){
        this.array =  new int[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
    }

    DynamicArray(int capacity){
        this.array =  new int[capacity];
        this.size = array.length;
    }

    @Override
    public void add(int data) {
        growSize();
        array[counter++] = data;
    }

    @Override
    public void add(int index, int data) {
        if (index < counter && index >= 0) {
            growSize();
            int[] newArray = new int[array.length + 1];
            System.arraycopy(array, 0, newArray, 0,index);
            System.arraycopy(array, index, newArray, index + 1,array.length - index);
            array = newArray;
            array[index] = data;
            counter++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(int data) {
        if (IntStream.range(0, array.length).filter(i -> data == array[i]).findFirst().isPresent()) {
            removeAt(IntStream.range(0, array.length)
                    .filter(i -> data == array[i])
                    .findFirst()
                    .getAsInt());
        }
    }

    @Override
    public void removeAt(int index) {
        if (index < counter && index >= 0) {
            int[] newArray = new int[array.length - 1];
            System.arraycopy(array, 0, newArray, 0,index);
            System.arraycopy(array, index + 1, newArray, index,array.length - index - 1);
            array = newArray;
            counter--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void growSize() {
        if (counter >= size) {
            if (size < Integer.MAX_VALUE / 2) {
                size *= 2;
            } else {
                size = Integer.MAX_VALUE;
            }
            array = Arrays.copyOf(array,size);
        }
    }

    @Override
    public void shrinkSize() {
        size = counter;
        array = Arrays.copyOf(array, size);
    }

    @Override
    public void set(int index, int data) {
        if (index < counter && index >= 0) {
            array[index] = data;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int get(int index) {
        if (index < counter && index >= 0) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        array =  new int[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
        counter = 0;
    }

    @Override
    public boolean contains(int data) {
        return Arrays.stream(array).anyMatch(x -> x == data);
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public int compareTo(DynamicArray o) {
        return this.getSum() - o.getSum();
    }

    private int getSum() {
        return IntStream.of(array).sum();
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array, counter));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public Integer next() {
            return array[cursor++];
        }
    }

}
