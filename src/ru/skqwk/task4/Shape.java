package ru.skqwk.task4;


public class Shape {

    // всевозможные комбинации линий для изображения чисел
    private static final String[] lines = new String[] {
            " ***** ",// 0
            " *   * ",// 1
            " *     ",// 2
            "     * ",// 3
            "   *   ",// 4
            " * *   ",// 5
            "    *  ",// 6
    };

    // порядок линий для каждого числа
    private static final int[][] schemas = new int[][] {
            {0,1,1,1,0}, // 0
            {4,5,4,4,0}, // 1
            {0,3,0,2,0}, // 2
            {0,3,0,3,0}, // 3
            {1,1,0,3,3}, // 4
            {0,2,0,3,0}, // 5
            {0,2,0,1,0}, // 6
            {0,6,4,2,2}, // 7
            {0,1,0,1,0}, // 8
            {0,1,0,3,0}, // 9
    };

    private final int[] schema;
    protected char symbol;
    private int readHead = 0;
    Shape(char symbol) {
        this.symbol = symbol;
        this.schema = schemas[symbol - '0'];
    }

    public boolean hasNextLine() {
        return (readHead < schema.length);
    }

    public String getNextLine() {
        if (readHead == schema.length) readHead = 0;
        return lines[schema[readHead++]];
    }
}
