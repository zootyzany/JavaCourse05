package com.example.zz.week01.service.impl;

import com.example.zz.week01.mapper.OrderMapper;
import com.example.zz.week01.model.Order;
import com.example.zz.week01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    public Boolean createOrder(Order order) {
        return orderMapper.createOrder(order);
    }

    @Override
    public Boolean update(Order order) {
        return orderMapper.update(order);
    }
}
