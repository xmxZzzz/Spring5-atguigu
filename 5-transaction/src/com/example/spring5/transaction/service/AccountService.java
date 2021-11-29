package com.example.spring5.transaction.service;

import com.example.spring5.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
