package com.example.spring5.transaction.propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HandleAccountService {

    @Autowired
    RequiredAccountService requiredAccountService;

    /*
     * @Method testRequiredPropagation
     * @Version  1.0
     * @Description 若该方法有事务，则reduceMoney和addMoney运行事务；若该方法无事务则新建事务
     * @Date 2021/12/8 上午2:04
     */
//    @Transactional
    public void testRequiredPropagation(){
        requiredAccountService.reduceMoney();
        requiredAccountService.addMoney();
//        throw new RuntimeException("测试异常test");
    }
    
    /*
     * @Method testSupportsPropagation
     * @Version  1.0
     * @Description  若该方法有事务，则reduceMoney1运行事务；若该方法无事务则无事务
     * @Date 2021/12/8 上午2:22
     */
//    @Transactional
    public void testSupportsPropagation(){
        requiredAccountService.reduceMoney1();
        throw new RuntimeException("测试异常test");
    }

    /*
     * @Method testNotSupportsPropagation
     * @Version  1.0
     * @Description 无论该方法有无事务，reduceMoney2都无事务，有异常时无回滚
     * @Return void
     * @Date 2021/12/8 上午2:40
     */
//    @Transactional
    public void testNotSupportsPropagation(){
        requiredAccountService.reduceMoney2();
        throw new RuntimeException("测试异常test");
    }

    /*
     * @Method testMandatoryPropagation
     * @Version  1.0
     * @Description 若该方法有事务，则reduceMoney3和addMoney1运行事务；若该方法无事务，则reduceMoney3正常执行，addMoney1抛出异常
     *  IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     * @Return void
     * @Date 2021/12/8 上午2:49
     */
//    @Transactional
    public void testMandatoryPropagation(){
        requiredAccountService.reduceMoney0();
        requiredAccountService.addMoney1();
    }

    /*
     * @Method testNeverPropagation1
     * @Version  1.0
     * @Description 若该方法无事务，则reduceMoney3和addMoney2无事务，正常执行；若该方法有事务，则抛出异常，并且reduceMoney3回滚
     *  IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
     * @param
     * @Return void
     * @Exception
     * @Date 2021/12/8 上午2:59
     */
//    @Transactional
    public void testNeverPropagation(){
        requiredAccountService.reduceMoney0();
        requiredAccountService.addMoney2();
    }

    /*
     * @Method testRequiredNewPropagation
     * @Version  1.0
     * @Description
     *  1、无论该方法有无事务，addMoney3都运行在自己的事务中，包括提交和回退。同时因为在try{}catch{}中，所以不影响其他方法
     *  2、若该方法有事务，则reduceMoney0和addMoney0任意一个抛出异常，除addMoney3外，全部回滚，否则正常执行
     *  3、若该方法无事务，则reduceMoney0和addMoney0正常执行，无回滚，addMoney3依然运行在自己的事务中
     *
     * @param
     * @Return void
     * @Exception
     * @Date 2021/12/8 上午3:24
     */
    @Transactional
    public void testRequiredNewPropagation(){
        requiredAccountService.reduceMoney0();
        try{
            requiredAccountService.addMoney3();
        }catch (Exception e){
//            e.printStackTrace();
        }
        requiredAccountService.addMoney0();
    }

    /*
     * @Method testNestedPropagation
     * @Version  1.0
     * @Description
     *   1、若该方法有事务，
     *      （1）其addMoney0和reduceMoney3无异常，则支持提交和回滚；
     *      （2）reduceMoney3出现异常，只回滚reduceMoney3
     *      （3）addMoney0出现异常，则addMoney0和reduceMoney3一起回滚
     *  2、若该方法无事务，则reduceMoney3创建一个新事务，与addMoney0无关
     * @param
     * @Return void
     * @Exception
     * @Date 2021/12/8 上午3:45
     */
//    @Transactional
    public void testNestedPropagation(){
        requiredAccountService.addMoney0();
        try{
            requiredAccountService.reduceMoney3();
        }catch (Exception e){
//            e.printStackTrace();
        }
    }
}
