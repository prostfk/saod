package by.bntu.fitr.prostrmk;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CustomArray array = new CustomArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int element = array.getArray()[8];
        var mas = array.getArray();
        System.out.println(array.indexSequentialSearch(element, mas));

    }


}
