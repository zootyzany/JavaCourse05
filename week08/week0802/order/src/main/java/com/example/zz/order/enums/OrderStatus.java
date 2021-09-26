package com.example.zz.order.enums;

import lombok.Getter;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Getter
public enum OrderStatus {
    WAITING_PAY(0, "待支付"),
    FREEZE(-1, "冻结"),
    SUCCESS(2, "交易成功");
    private Integer value;
    private String desc;

    OrderStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
