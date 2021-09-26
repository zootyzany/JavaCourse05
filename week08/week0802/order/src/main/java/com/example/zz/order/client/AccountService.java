package com.example.zz.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@FeignClient(value = "account")
public interface AccountService {
    /**
     * 账户扣减
     *
     * @param accountId 账号ID
     * @param amount    金额
     * @return 是否成功
     */
    @PostMapping(value = "/api/v1/decrease")
    Boolean decrease(Long accountId, Long amount);


    /**
     * 账户入账
     *
     * @param accountId 账号ID
     * @param amount    金额
     * @return 是否成功
     */
    @PostMapping(value = "/api/v1/increase")
    Boolean increase(Long accountId, Long amount);

    /**
     * 根据主键ID获取 账号
     *
     * @param id 账号ID
     * @return 账号信息
     */
    @PostMapping(value = "/api/v1/getById")
    Account getById(Long id);

    /**
     * 更新账号状态
     *
     * @param accountId 账号ID
     * @param status    状态
     * @return 是否成功
     */
    @PostMapping(value = "/api/v1/updateStatus")
    Boolean updateStatus(Long accountId, Integer status);
}
