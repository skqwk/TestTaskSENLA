package ru.skqwk.task5;

import java.util.ArrayList;
import java.util.List;

public class Safe implements Volumetric {
    private int volume;
    private int cost = 0;
    private final List<Item> items = new ArrayList<>();

    public Safe(int volume) {
        this.volume = volume;
    }

    public boolean hasVolumeFor(Volumetric item) {
        return (volume - item.getVolume() >= 0);
    }

    public void addItem(Item item) {
        if (hasVolumeFor(item)) {
            items.add(item);
            cost += item.getCost();
            volume -= item.getVolume();
        } else {
            System.out.println("Safe couldn't add item");
        }
    }

    public void addAll(Safe safe) {
        if (hasVolumeFor(safe)) {
            cost += safe.getCost();
            volume -= safe.getVolume();
            items.addAll(safe.getItems());

        } else {
            System.out.println("Safe couldn't add items from another safe");
        }
    }

    public int getCost() {
        return cost;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getVolume() {
        return volume;
    }
}
