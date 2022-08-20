package homework2.homework1;

import java.lang.reflect.Array;

public class Hometask1 {

    public static void main(String[] args) {

        // Task 1

        System.out.println("Something written in console");
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println(weekdays[0]);

        for (String arg : args) {
            System.out.println("Print this: " + arg);
        }

        // Task 2
        int[] numbers = {3, 7, 6, 13, 33, 9, -100, 25};
        int i = 0;
        int max = numbers[0];
        int min = numbers[0];
        while (i < Array.getLength(numbers)) {
            System.out.print(numbers[i] + " ");

            if (max < numbers[i]) {
                max = numbers[i];
            }
            if (min > numbers[i]) {
                min = numbers[i];
            }
            i++;
        }
        System.out.println("max value:" + max);
        System.out.println("min value:" + min);


        // Task 3

        // Bubble Sort
        int a;
        // int [] numbers2 = {3, 7, 6, 13, 33, 9, -100, 25};
        for (i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    a = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = a;
                }
            }
        }

        /*i = 0;
        while (i < Array.getLength(numbers)){
            System.out.print(numbers[i] + " ");
            //System.out.println("Element position: " + i + " Element: " + numbers[i]);
            i++;
        }*/

        for (int var : numbers) {
            System.out.print(var + " ");
        }

    }
}
