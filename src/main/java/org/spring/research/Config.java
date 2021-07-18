package org.spring.research;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author EAverkin
 */
@Configuration
public class Config {

    @Bean
    public Person person() {
        return new Person("Ivan", "Ivanov");
    }
}
