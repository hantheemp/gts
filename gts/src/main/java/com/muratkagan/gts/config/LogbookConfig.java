package com.muratkagan.gts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;

import com.muratkagan.gts.components.DatabaseLogbookSink;

@Configuration
public class LogbookConfig {

    @Bean
    public Logbook logbook(DatabaseLogbookSink databaseLogbookSink) {
        return Logbook.builder()
                .sink(databaseLogbookSink)
                .build();
    }
}