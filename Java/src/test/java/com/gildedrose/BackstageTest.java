package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BackstageTest {
    private static Item backstage;

    @BeforeEach
    void setUp() {
        backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 35);
    }

    @ParameterizedTest(name = "Day {0}, sellIn = {1}, quality = {2}")
    @MethodSource("valuesToCheck")
    void checkQualityAccordingTheDay(int sellingDayNumber, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{backstage});
        IntStream.range(1, sellingDayNumber + 1)
                .forEach(day -> gildedRose.updateQuality());

        Assertions.assertEquals(sellIn, backstage.sellIn, "SellIn");
        Assertions.assertEquals(quality, backstage.quality, "Quality");
    }

    private static Stream<Arguments> valuesToCheck() {
        return Stream.of(Arguments.of(0, 11, 35),
                Arguments.of(1, 10, 36),
                Arguments.of(2, 9, 38),
                Arguments.of(3, 8, 40),
                Arguments.of(4, 7, 42),
                Arguments.of(5, 6, 44),
                Arguments.of(6, 5, 46),
                Arguments.of(7, 4, 49),
                Arguments.of(8, 3, 50),
                Arguments.of(9, 2, 50),
                Arguments.of(10, 1, 50),
                Arguments.of(11, 0, 50),
                Arguments.of(12, -1, 0)
        );
    }
}
