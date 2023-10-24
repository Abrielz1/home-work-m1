package org.example.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
@RequiredArgsConstructor
public class InMemoryManager implements MemoryHolder {



    public void removeByEmail() {


    }

    @Override
    public void loadTasks() {

    }

    @Override
    public void saveTasks() {

    }


    //todo логику хранилища в памяти
}
