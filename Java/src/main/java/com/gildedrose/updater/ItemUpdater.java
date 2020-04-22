package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class ItemUpdater {
    public static final int DEFAULT_INCREMENT = 1;
    public static final int DEFAULT_DECREMENT = 1;

    private static final int QUALITY_MINIMUM = 0;

    public abstract void update(Item item);

    protected void decrementQualityIfAboveMin(Item item, int decrement) {
        if (item.quality > QUALITY_MINIMUM) {
            item.quality = item.quality - decrement;
        }
    }

    protected void incrementQualityIfUnderMax(Item item) {
        if (underMaximumHighQuality(item)) {
            item.quality = item.quality + DEFAULT_INCREMENT;
        }
    }

    protected boolean underMaximumHighQuality(Item item) {
        return item.quality < 50;
    }

    protected void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
