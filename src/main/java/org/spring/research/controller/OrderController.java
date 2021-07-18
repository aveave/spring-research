package org.spring.research.controller;

import lombok.RequiredArgsConstructor;
import org.spring.research.entity.Order;
import org.spring.research.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author EAverkin
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/new")
    public Long createOrder(@RequestBody Order order) {
        System.out.println("createOrder");
        return orderService.createOrder(order);
    }

    @GetMapping(value = "/order")
    public @ResponseBody Order getOrderById(@RequestParam(value = "orderId") Long orderId) {
        System.out.println("getOrderById");
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders")
    public @ResponseBody List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PutMapping("/order")
    public void updateOrder(@PathVariable Order order) {
        System.out.println("updateOrder");
        orderService.updateOrder(order);
    }

    @DeleteMapping("/order")
    public void deleteOrderById(@RequestParam(value = "orderId") Long orderId) {
        System.out.println("deleteOrderById");
        orderService.deleteOrderById(orderId);
    }


    @GetMapping("/hello")
    public @ResponseBody
    String getHello() {
        System.out.println("hello");
        return "hello";
    }

}
