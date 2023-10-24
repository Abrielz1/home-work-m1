package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class InFileManager implements MemoryHolder  {
    @Override
    public void loadTasks() {

    }

    @Override
    public void saveTasks() {

    }
    //todo логику считывания и записи в файл
}
