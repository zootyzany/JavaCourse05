package com.example.zz.week01.controller;

import com.example.zz.week01.model.Order;
import com.example.zz.week01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "")
    public Order getById(@RequestParam(value = "id") Long id) {
        return orderService.getById(id);
    }

    @PostMapping(value = "")
    public Boolean create(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping(value = "")
    public Boolean update(@RequestBody Order order) {
        return orderService.update(order);
    }
}
