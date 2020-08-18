package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру 11!");
        Scanner input = new Scanner(System.in);
        int matches = 11;
        int playerNum = 1;
        while (matches > 0) {
            System.out.print("Игрок " + playerNum + ", сколько спичек Вы тяните? ");
            int pulledMatches = Integer.valueOf(input.nextLine());
            if (pulledMatches > matches
                || pulledMatches > 3
                || pulledMatches < 1) {
                System.out.println("Некорректный ввод. Попробуйе ещё раз.");
                continue;
            }
            matches -= pulledMatches;
            System.out.println("Осталось " + matches + " спичек.");
            playerNum = (playerNum == 1) ? 2 : 1;
        }
        System.out.println("Победа!");
    }
}
