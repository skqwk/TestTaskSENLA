package ru.skqwk.task4;

public class Symbol extends Shape{
    private static char maxSymbol = '0';

    public Symbol(char symbol) {
        super(symbol);
        maxSymbol = (symbol - '0' > maxSymbol - '0')? symbol : maxSymbol;
    }

    @Override
    public String getNextLine() {
        String line = super.getNextLine();
        if (super.symbol == maxSymbol) line = line.replaceAll("\\*", String.valueOf(maxSymbol));
        return line;
    }


}
