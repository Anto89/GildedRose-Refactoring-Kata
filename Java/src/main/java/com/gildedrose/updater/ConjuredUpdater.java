package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        decrementQualityIfAboveMin(item, DEFAULT_DECREMENT * 2);
        decrementSellIn(item);
        if (item.sellIn < 0) {
            decrementQualityIfAboveMin(item, DEFAULT_DECREMENT * 2);
        }
    }
}
