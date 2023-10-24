package org.example.config;

import org.example.beans.EnvMemoryHolder;
import org.example.beans.InMemoryManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = @PropertySource("classpath:application-in-memory.properties"))
@Profile("memory")
public class InMemoryConfig {

    @Bean
    public EnvMemoryHolder memoryHolder() {
        return new InMemoryManager();
    }

}
