package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.YqMoney;
import com.ruoyi.system.domain.YqGuest;

/**
 * 客人收入支出Mapper接口
 * 
 * @author lxl
 * @date 2023-07-25
 */
public interface YqMoneyMapper 
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
     * 删除客人收入支出
     * 
     * @param moneyId 客人收入支出主键
     * @return 结果
     */
    public int deleteYqMoneyByMoneyId(Integer moneyId);

    /**
     * 批量删除客人收入支出
     * 
     * @param moneyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYqMoneyByMoneyIds(Integer[] moneyIds);

    /**
     * 批量删除客人管理
     * 
     * @param moneyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYqGuestByGuestIds(Integer[] moneyIds);
    
    /**
     * 批量新增客人管理
     * 
     * @param yqGuestList 客人管理列表
     * @return 结果
     */
    public int batchYqGuest(List<YqGuest> yqGuestList);
    

    /**
     * 通过客人收入支出主键删除客人管理信息
     * 
     * @param moneyId 客人收入支出ID
     * @return 结果
     */
    public int deleteYqGuestByGuestId(Integer moneyId);
}
