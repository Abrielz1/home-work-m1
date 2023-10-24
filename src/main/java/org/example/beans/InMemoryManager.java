package org.example.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Scope("singleton")
@Component
@Data
//@RequiredArgsConstructor
public class InMemoryManager implements EnvMemoryHolder {


    private final Map<String, Person> dump = new HashMap<>();


    @Value("{app.env}")
    public String env;


    public void removeByEmail() {


    }

    @Override
    public void loadTasks() {
        System.out.println("load from memory");
    }

    @Override
    public void saveTasks() {

    }


    //todo логику хранилища в памяти
}
