package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        incrementQualityIfUnderMax(item);
        decrementSellIn(item);
        if (item.sellIn < 0) {
            incrementQualityIfUnderMax(item);
        }
    }
}
