package org.example.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Scope("singleton")
@Component
@Data
@RequiredArgsConstructor
public class InMemoryManager implements EnvMemoryHolder {

    private final InFileManager file;

    public final Map<String, Person> dump = new HashMap<>();


    @Value("{app.env}")
    public String env;

    public void printMap() {
        for (Person i: dump.values()) {
            System.out.println(i);
        }
    }

    public void removeByEmail(String email) {
        dump.remove(email);
    }

    public void putPersonToMap(Person person) {
        dump.put(person.getEmail(), person);
   //     System.out.println("person on the map, the key is: " + dump.get(person).getEmail());
    }

    //todo логику загрузки из файла в мапу
    @Override
    public void loadTasks() {
        file.loadTasks();
    }

    //todo логику загрузки из мапы в файл
    @Override
    public void saveTasks() {
        file.saveTasks();
    }
}
