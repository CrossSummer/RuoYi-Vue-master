package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.YqMoney;

/**
 * 客人收入支出Service接口
 * 
 * @author lxl
 * @date 2023-07-25
 */
public interface IYqMoneyService 
{
    /**
     * 查询客人收入支出
     * 
     * @param moneyId 客人收入支出主键
     * @return 客人收入支出
     */
    public YqMoney selectYqMoneyByMoneyId(Integer moneyId);

    /**
     * 查询客人收入支出列表
     * 
     * @param yqMoney 客人收入支出
     * @return 客人收入支出集合
     */
    public List<YqMoney> selectYqMoneyList(YqMoney yqMoney);

    /**
     * 新增客人收入支出
     * 
     * @param yqMoney 客人收入支出
     * @return 结果
     */
    public int insertYqMoney(YqMoney yqMoney);

    /**
     * 修改客人收入支出
     * 
     * @param yqMoney 客人收入支出
     * @return 结果
     */
    public int updateYqMoney(YqMoney yqMoney);

    /**
     * 批量删除客人收入支出
     * 
     * @param moneyIds 需要删除的客人收入支出主键集合
     * @return 结果
     */
    public int deleteYqMoneyByMoneyIds(Integer[] moneyIds);

    /**
     * 删除客人收入支出信息
     * 
     * @param moneyId 客人收入支出主键
     * @return 结果
     */
    public int deleteYqMoneyByMoneyId(Integer moneyId);
}
