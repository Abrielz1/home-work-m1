package org.example.beans;

import org.springframework.stereotype.Component;

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
}