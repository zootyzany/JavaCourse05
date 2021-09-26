package com.example.zz.order.controller;

import com.example.zz.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@RestController
@RequestMapping(value = "/api/v1/pay")
public class OrderController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public Boolean pay(@RequestParam(value = "accountId") Long accountId,
                       @RequestParam(value = "orderId") Long orderId) {
        return paymentService.pay(accountId, orderId);
    }
}
