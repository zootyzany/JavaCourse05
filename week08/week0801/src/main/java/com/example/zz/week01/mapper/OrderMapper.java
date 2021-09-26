package com.example.zz.week01.mapper;

import com.example.zz.week01.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Mapper
public interface OrderMapper {
    /**
     * 创建订单
     *
     * @param order 订单信息
     * @return 是否成功
     */
    Boolean createOrder(Order order);

    /**
     * 更新订单
     *
     * @param order 订单信息
     * @return 是否成功
     */
    Boolean update(Order order);

    /**
     * 根据主键ID 查询订单
     *
     * @param id 主键ID
     * @return 订单信息
     */
    Order findById(Long id);
}
