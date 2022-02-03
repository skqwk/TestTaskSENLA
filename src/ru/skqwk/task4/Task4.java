package ru.skqwk.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            while (isNotNumeric(str)) {
                str = sc.nextLine();
            }

            ArrayList<Symbol> symbols = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                symbols.add(new Symbol(str.charAt(i)));
            }

            new Printer().print(symbols);
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

