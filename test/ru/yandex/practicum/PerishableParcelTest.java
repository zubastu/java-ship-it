package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelTest {
    @Test
    public void shouldReturnExpiredFalseBefore2Days() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 1, 2);
        Assertions.assertFalse(perishableParcelTest.isExpired(2));
    }

    @Test
    public void shouldReturnExpiredFalseBefore1Day() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 2, 2);
        Assertions.assertFalse(perishableParcelTest.isExpired(3));
    }

    @Test
    public void shouldReturnExpiredFalseInExactDay() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 2, 2);
        Assertions.assertFalse(perishableParcelTest.isExpired(4));
    }

    @Test
    public void shouldReturnExpiredTrue() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 2, 2);
        Assertions.assertTrue(perishableParcelTest.isExpired(5));
    }
}
