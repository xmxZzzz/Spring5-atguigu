package com.example.spring5.transaction.normal.service;

import com.example.spring5.transaction.normal.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.REPEATABLE_READ,timeout = -1,readOnly = false)
@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    /*
     * @Method accountMoney
     * @Version  1.0
     * @Description 执行银行转账操作
     * @param fromUsername 转账的来源用户
     * @param toUsername 转账的目标账户
     * @param money 转账的金额
     * @Return void
     * @Date 2021/11/30 上午2:14
     */
    @Transactional
    public void accountMoney(String fromUsername,String toUsername,int money){
        //先减钱
        accountDao.reduceMoney(fromUsername, money);

        //模拟异常
        int i = 10/0;

        //后加钱
        accountDao.addMoney(toUsername, money);
    }
}
