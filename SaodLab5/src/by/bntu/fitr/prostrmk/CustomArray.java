package by.bntu.fitr.prostrmk;

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
                return comparisonCount;
            }
        }
        return -1;
    }

    public int[] getArray() {
        return array;
    }

    public int binarySearch(int x, int []mas) {
        int newMas[] = new int[mas.length];
        System.arraycopy(mas, 0, newMas, 0, mas.length);
        sort(newMas);
        int i = -1;
        int count = 0;
        int low = 0, high = newMas.length, mid;
        while (low < high) {
            count++;
            mid = (low + high)/2;
            if (x == newMas[mid]) {
                i = mid;
                break;
            } else {
                if (x < newMas[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return count;
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
            sb.append(binarySearch(temp[0], temp)).append( " - binary search(").append(temp.length).append(" elements)\n");
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

    public int getMaxMultiple(){
        int max = firstMultiple();
        for (int i : array) {
            if (i > max && i % 2 == 0){
                max = i;
            }
        }
        return max;
    }

    private int firstMultiple(){
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                return array[i];
            }
        }
        return -101;
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
