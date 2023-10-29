package org.example.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@Scope("singleton")
@RequiredArgsConstructor
public class Menu {

    private final InFileManager file;

    private final InMemoryManager memory;

    private Scanner scanner = new Scanner(System.in);

    Pattern patternPhone = Pattern.compile("^(\\+|\\d)[0-9]{7,16}$");

    Pattern patternEmail = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    private Boolean flag = true;


    public void printMenu() {

        while (flag) {

            try {

                menu();

                int userInput = scanner.nextInt();

                if (userInput > 5 || userInput < 0) {
                    System.out.println("Please enter an integer value between 1 and 5 or 0");
                    userInput = scanner.nextInt();
                }

                switch (userInput) {

                    case 1 -> {

                        System.out.println("""
                                Please enter Person's personal info in fields:
                                
                                1st Enter persons full name like John Doe,
                                then enter phone number like +7(952)555-22-13
                                and at last email example of:
                                
                                1.  prettyandsimple@example.com
                                2.  very.common@example.com
                                3.  disposable.style.email.with+symbol@example.com
                                4.  other.email-with-dash@example.com
                                9.  #!$%&'*+-/=?^_`{}|~@example.org
                                6.  "()[]:,;@\\\\\\"!#$%&'*+-/=?^_`{}| ~.a"@example.org
                                7.  " "@example.org (space between the quotes)
                                8.  üñîçøðé@example.com (Unicode characters in local part)
                                9.  üñîçøðé@üñîçøðé.com (Unicode characters in domain part)
                                10. Pelé@example.com (Latin)
                                11. δοκιμή@παράδειγμα.δοκιμή (Greek)
                                12. 我買@屋企.香港 (Chinese)
                                13. 甲斐@黒川.日本 (Japanese)
                                14. чебурашка@ящик-с-апельсинами.рф (Cyrillic)
                                """);

                        System.out.println("name is -");

                        String name = scanner.nextLine();

                        if (name.isBlank()) {
                            name = scanner.nextLine();
                        }

                        System.out.println("name is:" + name);

                        System.out.println("phone is -");
                        String phone = scanner.next();

                        Matcher matcherPhone = patternPhone.matcher(phone);

                        while (!matcherPhone.find()) {

                            System.out.println("не подходящий формат записи!");
                            System.out.println(matcherPhone.matches());
                            phone = scanner.next();
                            matcherPhone = patternPhone.matcher(phone);

                        }

                        System.out.println("phone is: " + phone);

                        System.out.println("email is - ");

                        String email = scanner.next();

                        Matcher matcherEmail = patternEmail.matcher(email);

                        while (!matcherEmail.find()) {

                            System.out.println(matcherPhone.matches());
                            System.out.println("не подходящий формат записи!");
                            email = scanner.next();
                            matcherEmail = patternEmail.matcher(email);

                        }

                        System.out.println("email is: " + email);

                        memory.putPersonToMap(new Person(name, phone, email));
                    }

                    case 2 -> {

                        System.out.println("If you want to remove person, enter his/her email");
                        String email = scanner.next();

                        if (!memory.getDump().containsKey(memory.getDump().get(email)) || memory.getDump().isEmpty()) {
                            System.out.println("Person is not found!");
                        }

                        System.out.println("person to remove:" + memory.getDump().get(email));;
                        memory.removeByEmail(email);
                        System.out.println(memory.getDump());
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
                System.out.println("Please enter an integer value between 1 and 5 or 0");
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
