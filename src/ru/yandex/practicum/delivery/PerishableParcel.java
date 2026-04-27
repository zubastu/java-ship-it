package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int COEFFICIENT = 3;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        int expirationDay = getSendDay() + timeToLive;

        if (expirationDay >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected int getCalculateCoefficient() {
        return COEFFICIENT;
    }
}
