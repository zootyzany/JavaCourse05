package com.example.zz.account.dao;

import com.example.zz.account.model.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author sp0038
 * @date 2021/9/26
 */
public interface AccountMapper {

    @Update("update t_account set amount = amount - #{amount} where account_id = #{accountId}")
    Boolean decrease(Long accountId, Long amount);

    @Update("update t_account set amount = amount + #{amount} where account_id = #{accountId}")
    Boolean increase(Long accountId, Long amount);

    @Select("select * from t_account where id = #{id}")
    Account getById(Long id);

    @Update("update t_account set status = #{status} where account_id = #{accountId}")
    Boolean updateStatus(Long accountId, Integer status);
}
