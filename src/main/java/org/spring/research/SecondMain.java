package org.spring.research;

import lombok.Getter;
import lombok.Setter;
import org.spring.research.config.HibernateConfig;
import org.spring.research.dao.OrderDao;
import org.spring.research.dao.impl.OrderDaoImpl;
import org.spring.research.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author EAverkin
 */
@Component
@Getter
@Setter
public class SecondMain {

    @Autowired
    private Person person;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfig.class);

        Order order = new Order();
        order.setName("Fork");
        order.setOrderTime(LocalDateTime.now());

        OrderDao orderDao = applicationContext.getBean(OrderDaoImpl.class);
        orderDao.createOrder(order);
    }



}
