package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
        this.calculateCoefficient = 3;
    }

    public boolean isExpired(int currentDay) {
        int deliveryTime = getSendDay() + timeToLive;

        if (deliveryTime >= currentDay) {
            return false;
        } else {
            return true;
        }
    }
}
