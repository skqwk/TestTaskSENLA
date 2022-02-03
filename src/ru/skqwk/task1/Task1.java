package ru.skqwk.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        assert(sumDigit("1234") == 10);
        assert(sumDigit("1a2b3c4") == 10);
        assert(sumDigit("aaaa1234") == 10);
        assert(sumDigit("abcd") == 0);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(sumDigit(str));

    }

    public static int sumDigit(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                res += (c - '0');
            }
        }
        return res;
    }
}
