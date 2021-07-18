package org.spring.research.service;

import org.spring.research.entity.Order;

import java.util.List;

/**
 * @author EAverkin
 */
public interface OrderService {

    Long createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrders();

    void updateOrder(Order order);

    void deleteOrderById(Long id);
}
