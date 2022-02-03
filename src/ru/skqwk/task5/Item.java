package ru.skqwk.task5;

public class Item implements Volumetric{
    private final int  cost;
    private final int volume;
    public static Item EMPTY_ITEM = new Item(0,0);

    public int getCost() {
        return cost;
    }

    public int getVolume() {
        return volume;
    }

    public Item(int cost, int volume) {
        this.cost = cost;
        this.volume = volume;
    }
}
