package by.bntu.fitr.prostrmk;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomArray array = new CustomArray(1,2,3,4,5,6);
        array.binarySearch(4);
        System.out.println(array.linearSearch(4));


    }
}
