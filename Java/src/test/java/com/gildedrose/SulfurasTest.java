package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SulfurasTest {
    private static Item sulfuras;

    @BeforeEach
    void setUp() {
        sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    }

    @ParameterizedTest(name = "Day {0}, sellIn = {1}, quality = {2}")
    @MethodSource("valuesToCheck")
    void checkQualityAccordingTheDay(int sellingDayNumber, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
        IntStream.range(1, sellingDayNumber + 1)
                .forEach(day -> gildedRose.updateQuality());

        Assertions.assertEquals(sellIn, sulfuras.sellIn, "SellIn");
        Assertions.assertEquals(quality, sulfuras.quality, "Quality");
    }

    private static Stream<Arguments> valuesToCheck() {
        return Stream.of(Arguments.of(0, 0, 80),
                Arguments.of(1, 0, 80)
        );
    }
}
