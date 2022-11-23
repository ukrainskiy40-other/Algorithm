package ru.ukrainskiy.rnd.algorithm;


import java.sql.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlgorithmApplication {

    public static void main(String[] args) {
        //Перевернуть слово с использованием char
        reverseStringCycle("Задача1");
        //Перевернуть слово с использованием StringBuilder
        reverseStringSB("Задача2");
        //Подсчет количества строк
        countWord("Current for task posted for Java developers developers");
        //удаление пробелов из строки без использования replace
        removeSpaceFromString(" Мы готовимся     к интервью   на вакансию    Java разработчика");
        //Подсчет максимума лайков
        runLikeCount();

        //Максимальное количество повторяющихся чисел
        int[] a = {1, 2, 9, 10};
        int[] b = {1, 2, 2, 2, 10};
        System.out.println( "Максимальное колличество " + findMaxCount(a, b));

        // Вывод чисел, которые в сумме дают 7
        int[] array = {1, 2, 3, 5, 6, 3, 4, 6, 2, 4, 8, 7, 3, 2, 5, 7, 5, 3, 7, 8, 3, 1, 0, 2, 4, 6, 4, 2, 6};
        doubleSumByNumber(array, 7);

        //Сортировка пузырьком и вывод
        bubbleSortArray(array);

    }

    //Подсчет максимального количества лайков
    private static void runLikeCount() {
        LikeCounter counter = new LikeCounter();
        counter.like(1l);
        counter.like(2l);
        counter.like(1l);
        counter.like(2l);
        counter.like(2l);
        counter.like(1l);
        counter.unLike(1l);
        System.out.println("Like counter max " +counter.getMax());
    }

    //Подсчет максимального количества чисел
    private static int findMaxCount(int[] a, int[] b) {
        int max = 0;
        for (int i : a) {
            int count = 1;
            for (int k : b) {
                if (i == k) {
                    count++;
                } else if(i < k){
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    // Подсчет и вывод чисел в массиве, которые в сумме дают второе число
    private static void doubleSumByNumber(int[] array, int sumNumber) {
        int[][] resultArray = new int[array.length][array.length];

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i + j == sumNumber) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    resultArray[index] = result;
                    index++;
                }
            }
        }
        resultArray = Arrays.copyOf(resultArray, index);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i][0]);
            System.out.print(" ");
            System.out.println(resultArray[i][1]);
        }

    }

    private static void reverseStringCycle(String str) {
        char symbols[] = str.toCharArray();  // конвертируем строку в массив символов, затем выводим символы на экран в обратном порядке
        for(int x= symbols.length-1; x>=0; x--) {
            System.out.print(symbols [x]);
        }
        System.out.println();
    }

    private static void reverseStringSB(String str) {
        StringBuilder stB = new StringBuilder();
        stB.append(str);
        stB = stB.reverse();       // используем StringBuilder для переворота строки
        System.out.println(stB);
    }

    private static void countWord(String str) {
        String[] words = str.split(" ");
        Map<String, Long> wordCount = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordCount.forEach((key, value) -> System.out.println("word <" + key + "> count " + value));
    }

    private static void removeSpaceFromString(String str) {
        char[] charsArray = str.toCharArray();
        StringBuffer strB = new StringBuffer();
        for (int i = 0; i < charsArray.length; i++) {
            if( (charsArray[i] != ' ') && (charsArray [i] != '\t') ) {
                strB.append(charsArray [i]);
            }
        }
        System.out.println(strB);
    }

    private static void bubbleSortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
