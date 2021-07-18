package org.spring.research.service.impl;

import lombok.RequiredArgsConstructor;
import org.spring.research.dao.OrderDao;
import org.spring.research.entity.Order;
import org.spring.research.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author EAverkin
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Override
    public Long createOrder(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    @Transactional
    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    @Transactional
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderDao.deleteOrderById(id);
    }
}
