package org.spring.research;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author EAverkin
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
