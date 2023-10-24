package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Profiler {

    private final EnvMemoryHolder memoryHolder;

    private final Menu menu;

    @Autowired
    public Profiler(EnvMemoryHolder memoryHolder, Menu menu) {
        this.memoryHolder = memoryHolder;
        this.menu = menu;
    }

    public void doWork() {
        menu.printMenu();
    }
}
