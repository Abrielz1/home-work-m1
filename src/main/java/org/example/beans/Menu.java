package org.example.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    Pattern patternPhone = Pattern.compile("\\+\\d(-\\d{3})-{2}-\\d{4}");

    Pattern patternEmail = Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}");

    private Boolean flag = true;


    public void printMenu() {

        while (flag) {

            try {

                menu();

                int userInput = scanner.nextInt();

                switch (userInput) {

                    case 1 -> {

                    System.out.println("""
                            Please enter Person's personal info in fields:
                            1st Enter persons full name,
                            then enter phone number (like +8@@@@@@@) in 8digits and
                            at last email
                            """);

                        System.out.println("name is -");

                        String name = scanner.next();

                        if (name.isBlank()) {
                            name = scanner.next();
                        }

                        System.out.println("phone is -");

                        String phone = scanner.next();

                        Matcher matcherPhone = patternPhone.matcher(phone);

                        if (!matcherPhone.find()) {
                            phone = scanner.next();
                        }

                        System.out.println("email is -");

                        String email = scanner.next();

                        Matcher matcherEmail = patternEmail.matcher(phone);

                        if (!matcherEmail.find()) {
                            phone = scanner.next();
                        }

                        memory.putPersonToMap(new Person(name, phone, email));
                    }

                    case 2 -> {
                        System.out.println("If you want to remove person, enter his/her email");
                        memory.removeByEmail(scanner.nextLine());
                    }

                    case 3 -> memory.printMap();
                    case 4 -> file.saveTasks();
                    case 5 -> file.loadPersons();
                    case 0 -> {
                        file.saveTasks();
                        flag = false;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and 5 or 0" );
                scanner.next();
            }
        }
    }

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
