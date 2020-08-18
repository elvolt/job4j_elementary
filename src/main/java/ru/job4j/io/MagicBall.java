package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        String[] answers = new String[] {"Да", "Нет", "Может быть"};
        String answer = answers[new Random().nextInt(3)];
        System.out.println(answer);
    }
}
