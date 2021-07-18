package org.spring.research.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.research.dao.OrderDao;
import org.spring.research.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author EAverkin
 */
@Repository
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

    private final SessionFactory sessionFactory;

    @Override
    public Long createOrder(Order order) {
        return (Long)sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public List<Order> getOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM Order o", Order.class)
                .getResultList();
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        session.delete(order);
    }
}
