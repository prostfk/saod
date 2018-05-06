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

    public int linearSearch(int value, int []mas) {
        int comparisonCount = 0;
        for (int i : mas) {
            comparisonCount++;
            if (i == value) {
//                System.out.println(value + " is in array. Count of comparison: " + comparisonCount);
                return comparisonCount;
            }
        }
//        System.out.println(value + "is not in array. Count of comparison: " + comparisonCount);
        return -1;
    }

    public int[] getArray() {
        return array;
    }

    public int binarySearch(int value, int []mas) {
        int position;
        int first = 0;
        int last = mas.length;
        int comparisonCount = 1;

        position = last / 2;
        System.out.println(position);

        while ((mas[position] != value) && (first <= last)) {
            comparisonCount++;
            if (mas[position] > value) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            return comparisonCount;
        } else {
            return -1;
        }
    }

    public int sort(int []mas) {
        int countOfTransposition = 0;
        for (int i = 1; i < mas.length; i++) {
            for (int j = i; (j >= 1) && (mas[j] < mas[j - 1]); j--) {
                int a = mas[j];
                mas[j] = mas[j - 1];
                mas[j - 1] = a;
                countOfTransposition++;
            }

        }
//        System.out.println("Array was changed " + countOfTransposition + " times");
        return countOfTransposition;
    }


    public String dataComparison(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        int temp[];
        while(length < 100){
            length += 10;
            temp = new int[length];
            randomFilling(temp);
            sb.append(linearSearch(temp[5], temp)).append(" - linear search(").append(temp.length).append(" elements)\n");
//            System.out.println(Arrays.toString(temp));
            sb.append(binarySearch(temp[temp.length / 4], temp)).append( " - binary search(").append(temp.length).append(" elements)\n");
//            System.out.println(length);
            sb.append(sort(temp)).append(" - sort(").append(temp.length).append(" elements)\n\n");
        }
        return sb.toString();

    }

    public void randomFilling(int []emptyArray){
        Random random = new Random();
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = random.nextInt(200) - 100;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append("\t\t");
        }
        return sb.toString();
    }
}
