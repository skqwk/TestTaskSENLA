package ru.skqwk.task4;

import java.util.ArrayList;

public class Printer {

    public void print(ArrayList<Symbol> symbols) {
        while (symbols.get(0).hasNextLine()) {
            StringBuilder buffer = new StringBuilder();
            for (Symbol s : symbols) {
                buffer.append(s.getNextLine());
            }
            System.out.println(buffer);
        }
    }
}
