package com.example.zz.order.enums;

import lombok.Getter;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Getter
public enum AccountStatus {
    FREEZE(-1, "冻结"),
    USEFUL(1, "正常");
    private Integer value;
    private String desc;

    AccountStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
