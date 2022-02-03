package ru.skqwk.task5;

public class SafeManager {

    private Safe[][] safes;

    public void printFilledSafes() {
        for (int i = 0; i < safes.length; ++i) {
            for (int j = 0; j < safes[0].length; ++j) {
                System.out.print(safes[i][j].getCost() + "\t\t\t\t\t");
            }
            System.out.println();
        }
    }

    private void _createEmptySafes(int amountItems, int amountVolume) {
        safes = new Safe[amountItems][amountVolume];

        for (int i = 0; i < safes.length; ++i) {
            for (int j = 0; j < safes[0].length; ++j) {
                safes[i][j] = new Safe(j);
            }
        }
    }

    public void fillSafeByItems(Safe safe, Item[] items) {

        _createEmptySafes(items.length+1, safe.getVolume()+1);

        for (int i = 0; i < items.length; ++i) {
            for (int j = 1; j < safes[0].length; ++j) {
                if (!safes[i+1][j].hasVolumeFor(items[i])) {
                    safes[i+1][j] = safes[i][j];
                } else {

                    int prevMax = safes[i][j].getCost();
                    int itemCost = items[i].getCost();
                    Safe safeForFreeVolume = safes[i][j - items[i].getVolume()];

                    if ( prevMax > (itemCost + safeForFreeVolume.getCost())) {
                        safes[i+1][j] = safes[i][j];
                    }
                    else {
                        safes[i+1][j].addAll(safeForFreeVolume);
                        safes[i+1][j].addItem(items[i]);
                    }
                }
            }
        }

        safe.addAll(safes[safes.length-1][safes[0].length-1]);
    }
}
