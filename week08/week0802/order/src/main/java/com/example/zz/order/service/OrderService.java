package com.example.zz.order.service;

import com.example.zz.order.model.Order;

/**
 * @author sp0038
 * @date 2021/9/26
 */
public interface OrderService {
    /**
     * 获取订单信息
     *
     * @param orderId 订单ID
     * @return 订单信息
     */
    Order getById(Long orderId);


    /**
     * 更新订单状态
     *
     * @param orderId 订单ID
     * @param status  订单状态
     * @return 是否成功
     */
    Boolean updateStatus(Long orderId, Integer status);
}
