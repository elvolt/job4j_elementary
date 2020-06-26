package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static void main(String[] args) {
        int euro = Converter.rubleToEuro(140);
        int dollars = Converter.rubleToDollar(180);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("180 rubles are " + dollars + " dollars.");
        int euroIn = 140;
        int dollarIn  = 180;
        int euroExpected = 2;
        int dollarExpected = 3;
        int euroOut = rubleToEuro(euroIn);
        int dollarOut = rubleToDollar(dollarIn);
        boolean euroPassed = euroExpected == euroOut;
        boolean dollarPassed = dollarExpected == dollarOut;
        System.out.println("140 rubles are 2 euro. Test result : " + euroPassed);
        System.out.println("180 rubles are 3 dollars. Test result : " + dollarPassed);
    }
}
