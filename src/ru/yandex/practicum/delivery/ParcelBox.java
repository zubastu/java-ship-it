package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private int currentWeight;
    private ArrayList<T> parcels;


    public ParcelBox(ArrayList<T> parcels, int maxWeight) {
        this.parcels = parcels;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void addParcel(T parcel) {
        if (parcel != null
                && currentWeight < maxWeight
                && (currentWeight + parcel.getWeight() <= maxWeight)
        ) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
        } else {
            System.out.println("Посылку нельзя добавить.");
        }
    }
}