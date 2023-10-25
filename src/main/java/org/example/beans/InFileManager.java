package org.example.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.exceptions.ManagerSaveException;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.addAll;

//@Scope("singleton")
@Component
@Data
@Primary

public class InFileManager implements EnvMemoryHolder {

    private InMemoryManager manager;

    private final static String PATH = "resources\\data.csv";


    @Value("{app.env}")
    public String env;

    public InFileManager(InMemoryManager manager) {
        this.manager = manager;
    }
    @Override
    public void loadTasks() {
        System.out.println("load from file");
    }
        //todo логику считывания из файла

    @Override
    public void saveTasks() {
        try {

            Path path = Path.of(PATH);
            String data = personToString() + System.lineSeparator();

           Files.writeString(path, data);
        } catch (IOException e) {
            throw new ManagerSaveException("Ошибка, при записи файла произошел сбой!");
        }
    }

    private String personToString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Person> taskDump = new ArrayList<>(manager.getDump().values());
        System.out.println(taskDump.size());
            for (Person i: taskDump) {
                stringBuilder.append(i.getFullName()).append(";")
                        .append(i.getPhoneNumber()).append(";")
                        .append(i.getEmail())
                        .append(System.lineSeparator());
            }
        return stringBuilder.toString();
    }
}
