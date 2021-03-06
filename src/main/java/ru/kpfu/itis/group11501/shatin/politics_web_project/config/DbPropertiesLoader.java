package ru.kpfu.itis.group11501.shatin.politics_web_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author Oleg Shatin
 * Date: 4/23/17 6:43 PM
 *
 * Loads db.properties into System properties on startup
 */
@Component
public class DbPropertiesLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final Properties dbProperties;

    @Autowired
    public DbPropertiesLoader(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.getProperties().putAll(dbProperties);
    }
}
