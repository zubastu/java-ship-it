package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(60);
    private static ParcelBox<PerishableParcel> perishParcelBox = new ParcelBox<>(60);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(60);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    printAllTrackable();
                    break;
                case 5:
                    showParcelBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отправления поддерживающие трекинг.");
        System.out.println("5 - Показать содержимое коробки.");
        System.out.println("0 — Завершить");
    }

    private static void showParcelTypesMenu() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - Стандартная.");
        System.out.println("2 - Скоропортящаяся.");
        System.out.println("3 - Хрупкая.");
    }

    private static void addParcel() {
        showParcelTypesMenu();
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.println("Выбран тип посылки - Стандарт.");
                String name = askParcelDescription();
                int weight = askParcelWeight();
                String address = askParcelDeliveryAddress();
                int sendDay = askParcelSendDay();
                StandardParcel standardParcel = new StandardParcel(name, weight, address, sendDay);
                allParcels.add(standardParcel);
                addParcelInBox(standardParcel);
                System.out.println("Посылка собрана.");
            }
            case 2 -> {
                System.out.println("Выбран тип посылки - Скоропортящаяся.");
                String name = askParcelDescription();
                int weight = askParcelWeight();
                String address = askParcelDeliveryAddress();
                int sendDay = askParcelSendDay();
                int timeToLive = askParcelTimeToLive();
                PerishableParcel perishableParcel = new PerishableParcel(name, weight, address, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                addParcelInBox(perishableParcel);
                System.out.println("Посылка собрана.");
            }
            case 3 -> {
                System.out.println("Выбран тип посылки - Хрупкая.");
                String name = askParcelDescription();
                int weight = askParcelWeight();
                String address = askParcelDeliveryAddress();
                int sendDay = askParcelSendDay();
                FragileParcel fragileParcel = new FragileParcel(name, weight, address, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                addParcelInBox(fragileParcel);
                System.out.println("Посылка собрана.");
            }
            default -> {
                System.out.println("Введён некорректный тип посылки.");
            }
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран\
        int totalDeliveryCost = 0;
        for (Parcel parcel : allParcels) {
            totalDeliveryCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставок " + totalDeliveryCost + " р.");
    }

    private static String askParcelDescription() {
        System.out.println("Введите описание посылки:");
        String choice = scanner.nextLine();
        return choice;
    }

    private static int askParcelWeight() {
        System.out.println("Введите вес посылки:");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    private static String askParcelDeliveryAddress() {
        System.out.println("Введите адрес доставки:");
        String choice = scanner.nextLine();
        return choice;
    }

    private static int askParcelSendDay() {
        System.out.println("Введите день отправки:");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    private static int askParcelTimeToLive() {
        System.out.println("Введите срок годности посылки(в днях):");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    private static String askParcelNewLocation() {
        System.out.println("Введите новое местоположение:");
        String choice = scanner.nextLine();
        return choice;
    }

    private static void printAllTrackable() {
        String newLocation = askParcelNewLocation();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void addParcelInBox(Parcel parcel) {
        if (parcel instanceof StandardParcel) {
            standardParcelBox.addParcel((StandardParcel) parcel);
        } else if (parcel instanceof PerishableParcel) {
            perishParcelBox.addParcel((PerishableParcel) parcel);
        } else if (parcel instanceof FragileParcel) {
            fragileParcelBox.addParcel((FragileParcel) parcel);
        } else {
            System.out.println("Ошибка, неверный тип посылки.");
        }
    }

    private static void showParcelBox() {
        showParcelTypesMenu();
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println("Коробка со стандартными посылками:");
                standardParcelBox.printParcelBox();
            }
            case 2 -> {
                System.out.println("Коробка со скоропортящимися посылками:");
                perishParcelBox.printParcelBox();
            }
            case 3 -> {
                System.out.println("Коробка с хрупкими посылками:");
                fragileParcelBox.printParcelBox();
            }
            default -> System.out.println("Неверный тип посылки.");
        }

    }
}

