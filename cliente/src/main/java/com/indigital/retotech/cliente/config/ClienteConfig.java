package com.indigital.retotech.cliente.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.indigital.retotech.core.config.CoreConfig;

@Configuration
@Import(CoreConfig.class)
@ComponentScan(basePackages = {"com.indigital.retotech.cliente"})
public class ClienteConfig {

}
