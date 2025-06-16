package org.example;

public class MergeArrays {

    public static void main(String[] args) {
        int[] x = {-20, -7, -4, 0, 1, 7, 12, 19}; // задан первый сортированный массив
        int[] y = {-16, -8, -2, -1, 0, 3, 9, 27}; // задан второй сортированный массив
        int newLength = x.length + y.length;
        int[] z = new int[newLength]; // создаем новый массив
        int count1 = 0;
        int count2 = 0;


        for (int i = 0; i < newLength; i++) {
            if (count1 < x.length && count2 < y.length) {
                if (x[count1] < y[count2]) {
                    z[i] = x[count1];
                    count1++;
                } else {
                    z[i] = y[count2];
                    count2++;
                }
            } else if (count1 >= x.length) {
                z[i] = y[count2];
                count2++;
            } else {
                z[i] = x[count1];
                count1++;
            }
            System.out.println(z[i]);
        }
    }
}
