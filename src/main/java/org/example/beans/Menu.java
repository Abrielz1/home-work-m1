package org.example.beans;

import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Menu {

    private final InFileManager file;

    private final InMemoryManager memory;

   private Scanner scanner  = new Scanner(System.in);

    //todo написать меню и его обработку

    private Boolean flag = true;


    public void printMenu() {
        while(flag) {

            int userInput = scanner.nextInt();

            String personInput = scanner.nextLine();

            menu();

            switch (userInput) {
                case 1 -> {
                    System.out.println("""
                            Please enter Person's personal info in fields:
                            1st Enter persons full name,
                            then enter phone number (like +8@@@@@@@) in 8digits and 
                            at last email
                            """);
                    Person person = new Person(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    System.out.println(person);
                    memory.putPersonToMap(person);
                    System.out.println(memory.getDump());
                }

                case 2 -> {
                    System.out.println("If you want to remove person, enter his/her email");
                    memory.removeByEmail(scanner.nextLine());
                }

                case 3 -> memory.printMap();
                case 4 -> memory.saveTasks();
                case 5 -> memory.loadTasks();
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
