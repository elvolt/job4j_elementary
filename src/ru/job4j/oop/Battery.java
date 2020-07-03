package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        this.load += another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(10);
        Battery battery2 = new Battery(15);
        System.out.println("Battery 1: " + battery1.load + ", battery 2: " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("Battery 1: " + battery1.load + ", battery 2: " + battery2.load);
    }
}
