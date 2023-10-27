package org.example.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LoadFromFile {

    InFileManager file;

    public LoadFromFile(InFileManager file) {
        this.file = file;
    }

    @PostConstruct
    public void loadingAuto() {
        file.loadPersons();
    }

    @PreDestroy
    public void saveToFile() {
        file.saveTasks();
    }
}
