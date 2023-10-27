package org.example.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Profile("file")
@Scope("singleton")
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
        System.out.println("saving to file");
        file.saveTasks();
    }
}
