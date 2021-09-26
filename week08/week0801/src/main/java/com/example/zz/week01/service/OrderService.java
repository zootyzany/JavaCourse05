package com.example.zz.week01.service;

import com.example.zz.week01.model.Order;

/**
 * @author sp0038
 * @date 2021/9/26
 */
public interface OrderService {
    /**
     * 根据主键ID 查询订单
     *
     * @param id 订单ID
     * @return 订单详情
     */
    Order getById(Long id);

    /**
     * 创建订单信息
     *
     * @param order 订单
     * @return 是否成功
     */
    Boolean createOrder(Order order);

    /**
     * 更新订单信息
     *
     * @param order 订单信息
     * @return 是否成功
     */
    Boolean update(Order order);
}
