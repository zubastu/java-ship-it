package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    protected int calculateCoefficient;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.calculateCoefficient = 2;
    }


    public void packageItem() {
        System.out.println("Посылка '" + getDescription() + "' упакована");
    }
    public void deliver() {
        System.out.println("Посылка " + getDescription() + " доставлена по адресу" + getDeliveryAddress() + ".");
    };
    public int calculateDeliveryCost() {
        return weight * calculateCoefficient;
    };

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }
}
