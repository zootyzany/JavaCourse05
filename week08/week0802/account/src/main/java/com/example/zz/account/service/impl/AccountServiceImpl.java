package com.example.zz.account.service.impl;

import com.example.zz.account.dao.AccountMapper;
import com.example.zz.account.model.Account;
import com.example.zz.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sp0038
 * @date 2021/9/26
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean decrease(Long accountId, Long amount) {
        return accountMapper.decrease(accountId, amount);
    }

    @Override
    public Boolean increase(Long accountId, Long amount) {
        return accountMapper.increase(accountId, amount);
    }

    @Override
    public Account getById(Long id) {
        return accountMapper.getById(id);
    }

    @Override
    public Boolean updateStatus(Long accountId, Integer status) {
        return accountMapper.updateStatus(accountId, status);
    }
}
