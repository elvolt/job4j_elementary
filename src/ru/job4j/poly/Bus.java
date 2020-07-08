package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Rrrrr...");
    }

    @Override
    public void getPassengers(int passengers) {
        System.out.println(passengers);
    }

    @Override
    public double fill(double litersOfFuel) {
        double price = 3.5;
        return price * litersOfFuel;
    }
}
