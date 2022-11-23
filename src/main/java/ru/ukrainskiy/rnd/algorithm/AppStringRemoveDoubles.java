package ru.ukrainskiy.rnd.algorithm;

import java.util.Arrays;
import java.util.Scanner;

// Удаляет из введеной строки смежные дубли символов в цикле
// Input=abbacatfdkkands
// After remove=catfdands

public class AppStringRemoveDoubles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Input=" + input);
        System.out.println("After remove=" + removeDuplicates(input));
    }

    private static String removeDuplicates(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        char[] inputChar = str.toCharArray();
        char[] array = new char[inputChar.length];
        int index = 0;

        for (int i = 0; i < inputChar.length - 1; i++) {
            if (inputChar[i] == inputChar[i + 1]) {
                inputChar[i] = 0;
                inputChar[i + 1] = 0;

            }
        }
        for (char c : inputChar) {
            if (c != 0) {
                array[index] = c;
                index++;
            }
        }
        char[] arr = Arrays.copyOf(array, index);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                return removeDuplicates(String.copyValueOf(arr));
            }
        }
        return String.copyValueOf(arr);
    }

}
