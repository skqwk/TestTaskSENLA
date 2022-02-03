package ru.skqwk.task5;

public class Task5 {
    public static void main(String[] args) {
        Item laptop = new Item(2000, 3);
        Item audioPlayer = new Item(3000, 4);
        Item guitar = new Item(1500, 1);
        Item iPhone = new Item(2000, 1);

        Safe safe = new Safe(4);

        new SafeManager().fillSafeByItems(safe, new Item[]{guitar, audioPlayer, laptop});

        System.out.println("Max cost of safe = " + safe.getCost());
    }
}
