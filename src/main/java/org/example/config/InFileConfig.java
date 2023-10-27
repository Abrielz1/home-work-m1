package org.example.config;

import lombok.RequiredArgsConstructor;
import org.example.beans.EnvMemoryHolder;
import org.example.beans.InFileManager;
import org.example.beans.InMemoryManager;
import org.example.beans.Menu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = @PropertySource("classpath:application-in-file.properties"))

@RequiredArgsConstructor
public class InFileConfig {


    private final InFileManager file;

    private final InMemoryManager memory;

    @Bean
    public EnvMemoryHolder memoryHolder() {
        return new InFileManager(memory);
    }

    @Bean
    public Menu menu() {
        return new Menu(file, memory);
    }
}
