package com.example.zz.order.dao;

import com.example.zz.order.model.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author sp0038
 * @date 2021/9/26
 */
public interface OrderMapper {
    /**
     * 获取订单信息
     *
     * @param orderId 订单ID
     * @return 订单信息
     */
    @Select("select * from t_order where id = #{orderId}")
    Order getById(Long orderId);


    /**
     * 更新订单状态
     *
     * @param orderId 订单ID
     * @param status  订单状态
     * @return 是否成功
     */
    @Update("update t_account set status = #{status} where id = #{orderId}")
    Boolean updateStatus(Long orderId, Integer status);
}
