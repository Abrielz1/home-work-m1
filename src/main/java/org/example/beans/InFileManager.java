package org.example.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("singleton")
@Component
@Data
@Primary
//@RequiredArgsConstructor
public class InFileManager implements EnvMemoryHolder {

    @Value("{app.env}")
    public String env;

    @Override
    public void loadTasks() {
        System.out.println("load from file");
    }

    @Override
    public void saveTasks() {

    }
    //todo логику считывания и записи в файл
}
