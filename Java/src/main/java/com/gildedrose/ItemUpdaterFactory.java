package com.gildedrose;

import com.gildedrose.updater.*;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private static Map<String, ItemUpdater> specificItems = new HashMap<>();

    static {
        specificItems.put("Aged Brie", new AgedBrieUpdater());
        specificItems.put("Backstage passes to a TAFKAL80ETC concert", new BackstageConcertUpdater());
        specificItems.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        specificItems.put("Conjured Mana Cake", new ConjuredUpdater());
    }

    public static ItemUpdater choose(Item item) {
        return specificItems.getOrDefault(item.name, new OtherItemUpdater());
    }
}
