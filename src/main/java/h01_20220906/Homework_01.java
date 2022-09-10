/**
 * Algorithms. Homework #1
 * @author Viktors Soltums
 * @version 11 Sep 2022
 *
 */
/*
Given an array arr[] of N elements, the challenge is to write a function to find a given element x in arr[] .
 */
package h01_20220906;

import java.util.Arrays;

public class Homework_01 {
    public static void main(String[] args) {
        int[] array = {2, 59, 23, 26, 94, 27, 25, 84, 98};
        Arrays.sort(array);
        //int result = Arrays.binarySearch(array, 26);
        int result = binarySearch(array, 26);

        System.out.println(Arrays.toString(array));
        System.out.println(result);
    }

    public static int binarySearch(int array[], int find) {
        int first = 0;
        int last = array.length - 1;

        while(first <= last) {
            int middle = (first + last) / 2;

            if (array[middle] == find) {
                return middle;
            } else if (array[middle] < find) {
                first = middle + 1;
            } else if (array[middle] > find) {
                last = middle - 1;
            }
        }
        return -1;
    }
}