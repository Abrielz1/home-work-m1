package org.example;

import org.example.beans.LoadFromFile;
import org.example.beans.Profiler;
import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Master {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);
      LoadFromFile loadFromFile = context.getBean(LoadFromFile.class);
       context.getBean(Profiler.class).doWork();
        ((AbstractApplicationContext) context).getBeanFactory().destroyBean(loadFromFile);
    }
}