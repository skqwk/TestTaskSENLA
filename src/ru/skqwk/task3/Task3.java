package ru.skqwk.task3;

import java.util.*;

public class Task3 {

    public static final Set<Character> vowels = new HashSet<>(Arrays.asList('а', 'у', 'о', 'и', 'э', 'ы', 'я', 'ю', 'е', 'ё'));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Integer, ArrayList<String>> orderedMap = countVowels(str);
        for (Map.Entry<Integer, ArrayList<String>> entry : orderedMap.entrySet()) {
            for (String s : entry.getValue()) {
                System.out.println(s);
            }
        }
    }

    public static Map<Integer, ArrayList<String>> countVowels(String s) {
        Map<Integer, ArrayList<String>> orderedMap = new TreeMap<>(Collections.reverseOrder());

        int count = 0, beginIndex = 0, endIndex = 0, firstVowelIndex = -1;

        for (; endIndex < s.length(); ++endIndex) {
            char c = Character.toLowerCase(s.charAt(endIndex));

            if (c == ' ') {
                String formatStr = formatString(s, beginIndex, endIndex, firstVowelIndex);
                addToMap(orderedMap, formatStr, count);
                count = 0;
                beginIndex = endIndex+1;
                firstVowelIndex = -1;
            }
            else if (vowels.contains(c)) {
                ++count;
                if (count == 1) firstVowelIndex = endIndex-beginIndex;
            }
        }
        String formatStr = formatString(s, beginIndex, endIndex, firstVowelIndex);
        addToMap(orderedMap, formatStr, count);
        return orderedMap;
    }

    public static String formatString(String s, int beginIndex, int endIndex, int firstVowelIndex) {
        StringBuilder str = new StringBuilder(s.substring(beginIndex, endIndex));
        if (firstVowelIndex != -1) str.setCharAt(firstVowelIndex, Character.toUpperCase(str.charAt(firstVowelIndex)));
        return str.toString();
    }

    public static void addToMap(Map<Integer, ArrayList<String>> orderedMap, String str, int count)  {
        if (orderedMap.containsKey(count)) orderedMap.get(count).add(str);
        else orderedMap.put(count, new ArrayList<>(List.of(str)));
    }


}
