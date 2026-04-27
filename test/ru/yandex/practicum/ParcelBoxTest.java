package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class ParcelBoxTest {
    @Test
    public void parcelSuccessAddInBoxStandard() {
        ParcelBox<StandardParcel> standardParcelParcelBoxTest = new ParcelBox<>(10);
        StandardParcel standardParcelTest = new StandardParcel("стандарт", 10, "Москва", 20);
        standardParcelParcelBoxTest.addParcel(standardParcelTest);
        Assertions.assertEquals(1, standardParcelParcelBoxTest.getAllParcels().size());
    }

    @Test
    public void parcelFailAddInBoxStandard() {
        ParcelBox<StandardParcel> standardParcelParcelBoxTest = new ParcelBox<>(10);
        StandardParcel standardParcelTest1 = new StandardParcel("стандарт", 10, "Москва", 20);
        StandardParcel standardParcelTest2 = new StandardParcel("стандарт", 10, "Москва", 20);
        standardParcelParcelBoxTest.addParcel(standardParcelTest1);
        standardParcelParcelBoxTest.addParcel(standardParcelTest2);
        Assertions.assertEquals(1, standardParcelParcelBoxTest.getAllParcels().size());
    }

    @Test
    public void parcelExactLimitAddInBoxStandard() {
        ParcelBox<StandardParcel> standardParcelParcelBoxTest = new ParcelBox<>(10);
        StandardParcel standardParcelTest1 = new StandardParcel("стандарт", 7, "Москва", 20);
        StandardParcel standardParcelTest2 = new StandardParcel("стандарт", 3, "Москва", 20);
        standardParcelParcelBoxTest.addParcel(standardParcelTest1);
        standardParcelParcelBoxTest.addParcel(standardParcelTest2);
        Assertions.assertEquals(2, standardParcelParcelBoxTest.getAllParcels().size());
    }

    @Test
    public void parcelSuccessAddInBoxFragile() {
        ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(10);
        FragileParcel fragileParcelTest = new FragileParcel("хрупкая", 10, "Новосибирск", 1);
        fragileParcelParcelBox.addParcel(fragileParcelTest);
        Assertions.assertEquals(1, fragileParcelParcelBox.getAllParcels().size());
    }

    @Test
    public void parcelFailsAddInBoxFragile() {
        ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(10);
        FragileParcel fragileParcelTest1 = new FragileParcel("хрупкая", 10, "Новосибирск", 1);
        FragileParcel fragileParcelTest2 = new FragileParcel("хрупкая", 10, "Новосибирск", 1);
        fragileParcelParcelBox.addParcel(fragileParcelTest1);
        fragileParcelParcelBox.addParcel(fragileParcelTest2);
        Assertions.assertEquals(1, fragileParcelParcelBox.getAllParcels().size());
    }

    @Test
    public void parcelExactLimitAddInBoxFragile() {
        ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(10);
        FragileParcel fragileParcelTest1 = new FragileParcel("хрупкая", 8, "Новосибирск", 1);
        FragileParcel fragileParcelTest2 = new FragileParcel("хрупкая", 2, "Новосибирск", 1);
        fragileParcelParcelBox.addParcel(fragileParcelTest1);
        fragileParcelParcelBox.addParcel(fragileParcelTest2);
        Assertions.assertEquals(2, fragileParcelParcelBox.getAllParcels().size());
    }

    @Test
    public void parcelSuccessAddInBoxPerishable() {
        ParcelBox<PerishableParcel> perishableParcelParcelBoxTest = new ParcelBox<>(10);
        PerishableParcel perishableParcelTest = new PerishableParcel("скоропортящаяся", 10, "Питер", 10, 2);
        perishableParcelParcelBoxTest.addParcel(perishableParcelTest);
        Assertions.assertEquals(1, perishableParcelParcelBoxTest.getAllParcels().size());
    }

    @Test
    public void parcelFailAddInBoxPerishable() {
        ParcelBox<PerishableParcel> perishableParcelParcelBoxTest = new ParcelBox<>(10);
        PerishableParcel perishableParcelTest1 = new PerishableParcel("скоропортящаяся", 10, "Питер", 10, 2);
        PerishableParcel perishableParcelTest2 = new PerishableParcel("скоропортящаяся", 10, "Питер", 10, 2);
        perishableParcelParcelBoxTest.addParcel(perishableParcelTest1);
        perishableParcelParcelBoxTest.addParcel(perishableParcelTest2);
        Assertions.assertEquals(1, perishableParcelParcelBoxTest.getAllParcels().size());
    }

    @Test
    public void parcelExactLimitAddInBoxPerishable() {
        ParcelBox<PerishableParcel> perishableParcelParcelBoxTest = new ParcelBox<>(10);
        PerishableParcel perishableParcelTest1 = new PerishableParcel("скоропортящаяся", 9, "Питер", 10, 2);
        PerishableParcel perishableParcelTest2 = new PerishableParcel("скоропортящаяся", 1, "Питер", 10, 2);
        perishableParcelParcelBoxTest.addParcel(perishableParcelTest1);
        perishableParcelParcelBoxTest.addParcel(perishableParcelTest2);
        Assertions.assertEquals(2, perishableParcelParcelBoxTest.getAllParcels().size());
    }
}
