package by.bntu.fitr.prostrmk;

import java.util.Arrays;
import java.util.Random;

public class CustomArray {

    private int[] array;

    public CustomArray(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100;
        }
    }

    public CustomArray(int...ints){
        array = ints;
    }

    public boolean linearSearch(int value) {
        int comparisonCount = 0;
        for (int i : array) {
            comparisonCount++;
            if (i == value) {
                System.out.println(value + " is in array. Count of comparison: " + comparisonCount);
                return true;
            }
        }
        System.out.println(value + "is not in array. Count of comparison: " + comparisonCount);
        return false;
    }



    public boolean binarySearch(int value) {
        int position;
        int first = 0;
        int last = array.length;
        int comparisonCount = 1;

        position = last / 2;

        while ((array[position] != value) && (first <= last)) {
            comparisonCount++;
            if (array[position] > value) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(value + " is in array. Count of comparison: " + comparisonCount);
            return true;
        } else {
            System.out.println(value + "is not in array. Count of comparison: " + comparisonCount);
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append("\t");
        }
        return sb.toString();
    }
}
