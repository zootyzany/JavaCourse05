package com.example.zz.order.service.impl;

import com.example.zz.order.client.AccountService;
import com.example.zz.order.enums.AccountStatus;
import com.example.zz.order.enums.OrderStatus;
import com.example.zz.order.client.Account;
import com.example.zz.order.model.Order;
import com.example.zz.order.service.OrderService;
import com.example.zz.order.service.PaymentService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;

    @Override
    @HmilyTCC(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public Boolean pay(Long accountId, Long orderId) {
        Order order = orderService.getById(orderId);
        Account account = accountService.getById(accountId);
        if (account.getAmount() < order.getAmount()) {
            throw new RuntimeException("余额不足!");
        }
        orderService.updateStatus(orderId, OrderStatus.FREEZE.getValue());
        accountService.updateStatus(accountId, AccountStatus.FREEZE.getValue());
        return null;
    }

    public void confirmMethod(Long accountId, Long orderId) {
        Order order = orderService.getById(orderId);
        Long amount = order.getAmount();
        orderService.updateStatus(orderId, OrderStatus.SUCCESS.getValue());
        accountService.updateStatus(accountId, AccountStatus.USEFUL.getValue());
        accountService.decrease(accountId, amount);
    }

    public void cancelMethod(Long accountId, Long orderId) {
        Order order = orderService.getById(orderId);
        Long amount = order.getAmount();
        orderService.updateStatus(orderId, OrderStatus.WAITING_PAY.getValue());
        accountService.updateStatus(accountId, AccountStatus.USEFUL.getValue());
        accountService.increase(accountId, amount);
    }
}
