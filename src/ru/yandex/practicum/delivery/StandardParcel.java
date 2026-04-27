package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int COEFFICIENT = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getCalculateCoefficient() {
        return COEFFICIENT;
    }
}
