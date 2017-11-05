package com.gb.algoproblems.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gbalasubramanian on 26/10/17.
 */
public class OneMissingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<InputItems> inputItemsList = new ArrayList<>(n);
        for (int i =0;i<n;i++){
            InputItems inputItems = new InputItems();
            inputItems.numberOfItems = sc.nextInt();
            inputItems.itemsList = new int[inputItems.numberOfItems];
            for (int j=0;j<inputItems.numberOfItems-1;j++){
                inputItems.itemsList[j] = sc.nextInt();
            }
            inputItemsList.add(inputItems);
        }

        for (int i=0;i<inputItemsList.size();i++){
            int sum = 0;
            for (int j=0;j<inputItemsList.get(i).itemsList.length;j++){
                sum += inputItemsList.get(i).itemsList[j];
            }
            int originalSum = (inputItemsList.get(i).numberOfItems * (inputItemsList.get(i).numberOfItems + 1)) / 2;
            System.out.println(originalSum - sum);
        }
    }

    static class InputItems{
        int numberOfItems;
        int[] itemsList;
    }
}
