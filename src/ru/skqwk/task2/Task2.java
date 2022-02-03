package ru.skqwk.task2;

import java.util.Scanner;

public class Task2 {

    public static void primeFactorsOfNum(int num) {
        int primeFactor = 2;
        while(num > 1) {
            if (num % primeFactor == 0){
                System.out.println(primeFactor);
                num /= primeFactor;
            }
            else primeFactor++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (isNotNumeric(str)) {
            str = sc.nextLine();
        }

        primeFactorsOfNum(Integer.parseInt(str));
    }

    public static boolean isNotNumeric(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Программа ожидает на вход целое число");
            return true;
        }
        return false;
    }
}
