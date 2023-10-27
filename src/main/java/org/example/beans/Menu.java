package org.example.beans;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Validated
public class Menu {

    private final InFileManager file;

    private final InMemoryManager memory;

   private Scanner scanner  = new Scanner(System.in);

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

//                    System.out.println("name is -");
//                    String name = scanner.nextLine();
//
//                    System.out.println("phone is -");
//                    String phone = scanner.nextLine();
//
//                    System.out.println("phone is -");
//                    String email = scanner.nextLine();

                        System.out.println("name is -");

                        @NotBlank
                        String name = scanner.next();


                        System.out.println("phone is -");

                        @Pattern(regexp = "\\+\\d(-\\d{3}){2}-\\d{4}", message = "Phone is incorrect")
                        @NotBlank
                        String phone = scanner.next();

                        System.out.println("email is -");
                        @Pattern(regexp = "^(.+)@(S+) $.", message = "Email is incorrect")
                        @Email(message = "Некорректный email")
                        String email = scanner.next();

                        //    Person person = new Person(name, phone, email);
                        //   System.out.println(person);
                        memory.putPersonToMap(new Person(name, phone, email));

                        // memory.putPersonToMap(new Person(name, phone, email));
                    }

                    case 2 -> {
                        System.out.println("If you want to remove person, enter his/her email");
                        memory.removeByEmail(scanner.nextLine());
                    }

                    case 3 -> memory.printMap();
                    case 4 -> file.saveTasks();
                    case 5 -> file.loadPersons();
                    case 0 -> { //file.saveTasks();
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
