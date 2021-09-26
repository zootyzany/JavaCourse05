package com.example.zz.order.service;

/**
 * @author sp0038
 * @date 2021/9/26
 */
public interface PaymentService {

    /**
     * 支付
     *
     * @param accountId 账号ID
     * @param orderId   订单ID
     * @return 是否成功
     */
    Boolean pay(Long accountId, Long orderId);
}
