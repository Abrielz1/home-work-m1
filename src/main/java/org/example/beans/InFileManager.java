package org.example.beans;

import lombok.Data;
import org.example.exceptions.ManagerSaveException;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
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

    private String[] readFromFile() {
        try {
            return Files.readString(Path.of(PATH), StandardCharsets.UTF_8).split(System.lineSeparator());
        } catch (IOException err) {
            throw new ManagerSaveException("Ошибка при восстановлении данных");
        }
    }

    @Override
    public void loadPersons() {

        String[] lines = readFromFile();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] content = line.split("\\;");
            manager.putPersonToMap(new Person(content[0], content[1], content[2]));
        }
    }


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
        for (Person i : taskDump) {
            stringBuilder.append(i.getFullName()).append(";")
                    .append(i.getPhoneNumber()).append(";")
                    .append(i.getEmail())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
