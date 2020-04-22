package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstageConcertUpdater extends ItemUpdater {
    @Override
    public void update(Item item) {
        if (underMaximumHighQuality(item)) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                incrementQualityIfUnderMax(item);
            }

            if (item.sellIn < 6) {
                incrementQualityIfUnderMax(item);
            }
        }
        decrementSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
