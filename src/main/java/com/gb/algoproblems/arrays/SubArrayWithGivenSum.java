package com.gb.algoproblems.arrays;

import java.util.Scanner;

/**
 * Created by gbalasubramanian on 26/10/17.
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n1 = arr.length;
        int sum = 23;
        subArrayWithGivenSum(arr, n1, sum);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayInputItems[] inputItemsList = new ArrayInputItems[n];
        for (int i = 0; i < n; i++) {
            ArrayInputItems inputItems = new ArrayInputItems();
            inputItems.numberOfItems = sc.nextInt();
            inputItems.sum = sc.nextInt();
            inputItems.itemsList = new int[inputItems.numberOfItems];
            for (int j = 0; j < inputItems.numberOfItems; j++) {
                inputItems.itemsList[j] = sc.nextInt();
            }
            inputItemsList[i] = inputItems;
        }
        for (int i = 0; i < inputItemsList.length; i++) {
            int currentSum = inputItemsList[i].itemsList[0];
            int start = 0;
            for (int j = 1; j <= inputItemsList[i].numberOfItems; j++) {

                while (currentSum > inputItemsList[i].sum && start < j - 1) {
                    currentSum -= inputItemsList[i].itemsList[start];
                    start++;
                }
                if (currentSum == inputItemsList[i].sum) {
                    System.out.println((start + 1) + " " + (j));
                    break;
                }
                if (j < inputItemsList[i].numberOfItems)
                    currentSum += inputItemsList[i].itemsList[j];
            }
            if (currentSum != inputItemsList[i].sum)
                System.out.println(-1);
        }
    }

    static void subArrayWithGivenSum(int[] arr, int n, int sum) {
        int curreentSum = arr[0], start = 0;
        for (int i = 1; i <= n; i++) {
            while (curreentSum > sum && start < i - 1) {
                curreentSum -= arr[start];
                start++;
            }

            if (curreentSum < sum) {
                curreentSum += arr[i];
            }
            if (curreentSum == sum) {
                System.out.println(curreentSum);
                System.out.println("Start " + start + " end" + (i-1));
                break;
            }

        }
    }

    static class ArrayInputItems {
        int numberOfItems;
        int[] itemsList;
        int sum;

    }
}
