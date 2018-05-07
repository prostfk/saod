package by.bntu.fitr.prostrmk;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomArray {

    private int[] array;
    private int[] indexTable;

    public CustomArray(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100;
        }
        initIndexTable();
    }

    public CustomArray(int... ints) {
        array = ints;
        initIndexTable();
    }

    public int linearSearch(int value, int[] mas) {
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

    public int binarySearch(int element, int[] mas) {
        int newMas[] = new int[mas.length];
        System.arraycopy(mas, 0, newMas, 0, mas.length);
        sort(newMas);
        int i = -1;
        int count = 0;
        int low = 0, high = newMas.length, mid;
        while (low < high) {
            count++;
            mid = (low + high) / 2;
            if (element == newMas[mid]) {
//                i = mid;
                break;
            } else {
                if (element < newMas[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return count;
    }

    public int indexSequentialSearch(int element, int[] mas) {
        int[] newMas = new int[mas.length];
        System.arraycopy(mas, 0, newMas, 0, mas.length);
        sort(newMas);
        var countOfComparison = 0;
        int indexOfKeyLast = 0;
        int indexOfKeyFirst = 0;
        while (indexOfKeyLast < indexTable.length) {
            System.out.println(indexOfKeyLast);
            countOfComparison++;
            if (element < newMas[indexTable[indexOfKeyLast]] && element > newMas[indexTable[indexOfKeyFirst]]) {
                break;
            }
            indexOfKeyLast++;
            indexOfKeyFirst = indexOfKeyLast - 1;
        }



        if (indexOfKeyLast == indexTable.length) {
            indexOfKeyLast -= 2;
        }
        if (indexOfKeyLast == 0) {
            indexOfKeyFirst = indexTable[0];
            indexOfKeyLast = indexTable[1];
        } else {
            indexOfKeyFirst = indexTable[indexOfKeyLast - 1];
            indexOfKeyLast = indexTable[indexOfKeyLast];
        }
        countOfComparison += 2;
        for (int i = indexOfKeyFirst; i < indexOfKeyLast; i++) {
            if (newMas[i] == element) {
                return ++countOfComparison;
            }
        }
        return -1;
    }



    public int sort(int[] mas) {
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


    public String dataComparison() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        int temp[];
        while (length < 100) {
            length += 10;
            temp = new int[length];
            randomFilling(temp);
            sb.append("__________________________________________________________________________________________________________________\n");
            sb.append(binarySearch(temp[0], temp)).append(" comparison count in binary search(").append(temp.length).append(" elements)\n");
            sb.append(linearSearch(temp[5], temp)).append(" comparison count in linear search(").append(temp.length).append(" elements)\n");
            sb.append(indexSequentialSearch(temp[6], temp)).append(" comparison count in index sequential search(").append(temp.length).append(" elements)\n");
            sb.append(sort(temp)).append(" - sort(").append(temp.length).append(" elements)\n\n");
            sb.append("__________________________________________________________________________________________________________________\n");

        }
        return sb.toString();

    }

    public void randomFilling(int[] emptyArray) {
        Random random = new Random();
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = random.nextInt(200) - 100;
        }
    }

    public int getMaxMultiple() {
        int max = firstMultiple();
        for (int i : array) {
            if (i > max && i % 2 == 0) {
                max = i;
            }
        }
        return max;
    }

    private int firstMultiple() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                return array[i];
            }
        }
        return -101;
    }

    private void initIndexTable() {
        this.indexTable = new int[(array.length / 5) + 1];
        int index;int i;
        for (i = 0, index = 0; i < array.length; i += 5, index++) {
            indexTable[index] = i;
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
