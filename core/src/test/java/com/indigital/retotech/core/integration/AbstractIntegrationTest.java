package com.indigital.retotech.core.integration;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.indigital.retotech.core.config.CoreConfig;

@ExtendWith(value = {SpringExtension.class})
@ContextConfiguration(classes = CoreConfig.class)
@TestPropertySource(locations = {"classpath:application-test-integration.properties", "classpath:application-core.properties"})
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public abstract class AbstractIntegrationTest {

}
