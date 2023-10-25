package org.example.beans;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Menu {

    Scanner scanner  = new Scanner(System.in);

    int userInput = scanner.nextInt();

    String personInput = scanner.nextLine();

    //todo написать меню и его обработку



    private Boolean flag = true;


    public void printMenu() {
        while(flag) {
            menu();

            switch (userInput) {
                case 1 -> System.out.println("1");
                case 2 -> System.out.println("2");
                case 3 -> System.out.println("3");
                case 4 -> System.out.println("4");
                case 5 -> System.out.println("5");
                case 0 -> flag = false;
            }
        }
    }

    //todo
    public static void menu() {
        System.out.println("Здравствуйте!");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Создать контакт");
        System.out.println("2 - Удалить контакт");
        System.out.println("3 - Вывести список контактов на экран");
        System.out.println("4 - Сохранить в файл");
        System.out.println("5 - Загрузить из файла");
        System.out.println("0 - Выход");
    }
}
