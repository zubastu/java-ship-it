package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private int currentWeight;
    private ArrayList<T> parcels;


    public ParcelBox(int maxWeight) {
        this.parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void addParcel(T parcel) {
        if (parcel != null && (currentWeight + parcel.getWeight() <= maxWeight)) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
        } else {
            System.out.println("Посылку нельзя добавить.");
        }
    }

    public void printParcelBox() {
        if (parcels.isEmpty()) {
            System.out.println("\n Посылок нет.");
        } else {
            for (T parcel : parcels) {
                System.out.println(parcel.getDescription());
            }
        }
    }
}