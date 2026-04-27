package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    @Test
    public void shouldCalculateStandardParcelCost() {
        StandardParcel standardParcelTest = new StandardParcel("стандарт", 10, "Москва", 20);
        assertEquals(20, standardParcelTest.calculateDeliveryCost(), "Расчет для стандартной посылки неправильный.");
    }

    @Test
    public void shouldCalculateStandardParcelCostWithZeroWeight() {
        StandardParcel standardParcelTest = new StandardParcel("стандарт", 0, "Москва", 20);
        assertEquals(0, standardParcelTest.calculateDeliveryCost(), "Расчет для стандартной посылки неправильный.");
    }

    @Test
    public void shouldCalculatePerishParcelCost() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 10, 2);
        assertEquals(30, perishableParcelTest.calculateDeliveryCost(), "Расчет для скоропортящейся посылки неправильный.");
    }

    @Test
    public void shouldCalculatePerishParcelCostWithZeroWeight() {
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 0, "Питер", 10, 2);
        assertEquals(0, perishableParcelTest.calculateDeliveryCost(), "Расчет для скоропортящейся посылки неправильный.");
    }


    @Test
    public void shouldCalculateFragileParcelCost() {
        FragileParcel fragileParcelTest = new FragileParcel("хрупкая", 10, "Новосибирск", 1);
        assertEquals(40, fragileParcelTest.calculateDeliveryCost(), "Расчет для хрупкой посылки неправильный.");
    }

    @Test
    public void shouldCalculateFragileParcelCostWithZeroWeight() {
        FragileParcel fragileParcelTest = new FragileParcel("хрупкая", 0, "Новосибирск", 1);
        assertEquals(0, fragileParcelTest.calculateDeliveryCost(), "Расчет для хрупкой посылки неправильный.");
    }
}
