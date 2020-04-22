package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConjuredTest {
    private static Item conjured;

    @BeforeEach
    void setUp() {
        conjured = new Item("Conjured Mana Cake", 2, 10);
    }

    @ParameterizedTest(name = "Day {0}, sellIn = {1}, quality = {2}")
    @MethodSource("valuesToCheck")
    void checkQualityAccordingTheDay(int sellingDayNumber, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{conjured});
        IntStream.range(1, sellingDayNumber + 1)
                .forEach(day -> gildedRose.updateQuality());

        Assertions.assertEquals(sellIn, conjured.sellIn, "SellIn");
        Assertions.assertEquals(quality, conjured.quality, "Quality");
    }

    private static Stream<Arguments> valuesToCheck() {
        return Stream.of(Arguments.of(0, 2, 10),
                Arguments.of(1, 1, 8),
                Arguments.of(2, 0, 6),
                Arguments.of(3, -1, 2),
                Arguments.of(4, -2, 0)
        );
    }
}
