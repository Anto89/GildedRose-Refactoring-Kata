package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DexterityVestTest {
    private static Item dexterityVest;

    @BeforeEach
    void setUp() {
        dexterityVest = new Item("+5 Dexterity Vest", 2, 5);
    }

    @ParameterizedTest(name = "Day {0}, sellIn = {1}, quality = {2}")
    @MethodSource("valuesToCheck")
    void checkQualityAccordingTheDay(int sellingDayNumber, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{dexterityVest});
        IntStream.range(1, sellingDayNumber + 1)
                .forEach(day -> gildedRose.updateQuality());

        Assertions.assertEquals(sellIn, dexterityVest.sellIn, "SellIn");
        Assertions.assertEquals(quality, dexterityVest.quality, "Quality");
    }

    private static Stream<Arguments> valuesToCheck() {
        return Stream.of(Arguments.of(0, 2, 5),
                Arguments.of(1, 1, 4),
                Arguments.of(2, 0, 3),
                Arguments.of(3, -1, 1),
                Arguments.of(4, -2, 0)
        );
    }
}
