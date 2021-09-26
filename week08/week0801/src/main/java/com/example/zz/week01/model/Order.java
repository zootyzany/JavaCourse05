package com.example.zz.week01.model;

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
     * 账号ID
     */
    private Long accountId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
