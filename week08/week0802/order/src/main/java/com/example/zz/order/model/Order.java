package com.example.zz.order.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Data
public class Order implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
