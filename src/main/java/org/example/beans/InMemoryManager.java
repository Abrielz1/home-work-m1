package org.example.beans;

import lombok.Data;
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

    private final Map<String, Person> dump = new HashMap<>();


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
    }

    @Override
    public void loadTasks() {
    }

    @Override
    public void saveTasks() {

    }
}
