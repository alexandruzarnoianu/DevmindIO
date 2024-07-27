package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public void solve(Scanner sc1, Scanner sc2, BufferedWriter bw) throws IOException {
        int[] array1 = new int[0];
        int[] array2 = new int[0];

        while (sc1.hasNext()) {
            array1 = add(array1, sc1.nextInt());
        }
        while (sc2.hasNext()) {
            array2 = add(array2, sc2.nextInt());
        }

        int[] merge = mergeSortedArrays(array1, array2);

        for (int i : merge) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
    }

    private int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] merge = new int[array1.length + array2.length];
        int i1 = 0;
        int i2 = 0;
        int iM = 0;

        while (i1 < array1.length && i2 < array2.length) {
            if (array1[i1] < array2[i2])
                merge[iM++] = array1[i1++];
            else
                merge[iM++] = array2[i2++];
        }

        while (i1 < array1.length) {
            merge[iM++] = array1[i1++];
        }

        while (i2 < array2.length) {
            merge[iM++] = array2[i2++];
        }

        return merge;
    }

    private int[] add(int[] array, int number) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = number;
        return array;
    }
}
