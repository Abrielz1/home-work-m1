package org.example.beans;

import java.util.Scanner;

public class Menu {

    Scanner scanner  = new Scanner(System.in);

    int userInput = scanner.nextInt();

    String personInput = scanner.nextLine();

    //todo написать меню и его обработку

    public void printMenu() {
        while(true) {
            menu();
        }
    }

    //todo
    public static void menu() {
        System.out.println("Здравствуйте!");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
