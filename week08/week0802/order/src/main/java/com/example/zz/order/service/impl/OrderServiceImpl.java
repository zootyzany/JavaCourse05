package com.example.zz.order.service.impl;

import com.example.zz.order.dao.OrderMapper;
import com.example.zz.order.model.Order;
import com.example.zz.order.service.OrderService;
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
    public Order getById(Long orderId) {
        return orderMapper.getById(orderId);
    }

    @Override
    public Boolean updateStatus(Long orderId, Integer status) {
        return orderMapper.updateStatus(orderId, status);
    }
}
