package com.example.zz.order.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Data
public class Account implements Serializable {
    /**
     * 账号ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 总余额
     */
    private Long amount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
