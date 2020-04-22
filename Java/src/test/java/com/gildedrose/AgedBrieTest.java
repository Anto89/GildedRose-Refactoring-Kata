package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AgedBrieTest {
    private static Item agedBrie;

    @BeforeEach
    void setUp() {
        agedBrie = new Item("Aged Brie", 1, 45);
    }

    @ParameterizedTest(name = "Day {0}, sellIn = {1}, quality = {2}")
    @MethodSource("valuesToCheck")
    void checkQualityAccordingTheDay(int sellingDayNumber, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        IntStream.range(1, sellingDayNumber + 1)
                .forEach(day -> gildedRose.updateQuality());

        Assertions.assertEquals(sellIn, agedBrie.sellIn, "SellIn");
        Assertions.assertEquals(quality, agedBrie.quality, "Quality");
    }

    private static Stream<Arguments> valuesToCheck() {
        return Stream.of(Arguments.of(0, 1, 45),
                Arguments.of(1, 0, 46),
                Arguments.of(2, -1, 48),
                Arguments.of(3, -2, 50),
                Arguments.of(4, -3, 50)
        );
    }
}
