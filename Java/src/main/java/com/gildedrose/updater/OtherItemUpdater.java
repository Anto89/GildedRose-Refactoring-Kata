package com.gildedrose.updater;

import com.gildedrose.Item;

public class OtherItemUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        decrementQualityIfAboveMin(item, DEFAULT_DECREMENT);
        decrementSellIn(item);
        if (item.sellIn < 0) {
            decrementQualityIfAboveMin(item, DEFAULT_DECREMENT);
        }
    }
}
