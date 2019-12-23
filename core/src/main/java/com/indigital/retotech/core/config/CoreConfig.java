package com.indigital.retotech.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages = {
        "com.indigital.retotech.core.service",
        "com.indigital.retotech.core.repository"})
@EnableMongoRepositories(basePackages = {"com.indigital.retotech.core.repository"})
public class CoreConfig {

}
