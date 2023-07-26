package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.YqGuest;
import com.ruoyi.system.mapper.YqMoneyMapper;
import com.ruoyi.system.domain.YqMoney;
import com.ruoyi.system.service.IYqMoneyService;

/**
 * 客人收入支出Service业务层处理
 * 
 * @author lxl
 * @date 2023-07-25
 */
@Service
public class YqMoneyServiceImpl implements IYqMoneyService 
{
    @Autowired
    private YqMoneyMapper yqMoneyMapper;

    /**
     * 查询客人收入支出
     * 
     * @param moneyId 客人收入支出主键
     * @return 客人收入支出
     */
    @Override
    public YqMoney selectYqMoneyByMoneyId(Integer moneyId)
    {
        return yqMoneyMapper.selectYqMoneyByMoneyId(moneyId);
    }

    /**
     * 查询客人收入支出列表
     * 
     * @param yqMoney 客人收入支出
     * @return 客人收入支出
     */
    @Override
    public List<YqMoney> selectYqMoneyList(YqMoney yqMoney)
    {
        return yqMoneyMapper.selectYqMoneyList(yqMoney);
    }

    /**
     * 新增客人收入支出
     * 
     * @param yqMoney 客人收入支出
     * @return 结果
     */
    @Transactional
    @Override
    public int insertYqMoney(YqMoney yqMoney)
    {
        int rows = yqMoneyMapper.insertYqMoney(yqMoney);
        insertYqGuest(yqMoney);
        return rows;
    }

    /**
     * 修改客人收入支出
     * 
     * @param yqMoney 客人收入支出
     * @return 结果
     */
    @Transactional
    @Override
    public int updateYqMoney(YqMoney yqMoney)
    {
        yqMoneyMapper.deleteYqGuestByGuestId(yqMoney.getMoneyId());
        insertYqGuest(yqMoney);
        return yqMoneyMapper.updateYqMoney(yqMoney);
    }

    /**
     * 批量删除客人收入支出
     * 
     * @param moneyIds 需要删除的客人收入支出主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteYqMoneyByMoneyIds(Integer[] moneyIds)
    {
        yqMoneyMapper.deleteYqGuestByGuestIds(moneyIds);
        return yqMoneyMapper.deleteYqMoneyByMoneyIds(moneyIds);
    }

    /**
     * 删除客人收入支出信息
     * 
     * @param moneyId 客人收入支出主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteYqMoneyByMoneyId(Integer moneyId)
    {
        yqMoneyMapper.deleteYqGuestByGuestId(moneyId);
        return yqMoneyMapper.deleteYqMoneyByMoneyId(moneyId);
    }

    /**
     * 新增客人管理信息
     * 
     * @param yqMoney 客人收入支出对象
     */
    public void insertYqGuest(YqMoney yqMoney)
    {
        List<YqGuest> yqGuestList = yqMoney.getYqGuestList();
        Integer moneyId = yqMoney.getMoneyId();

                Long mid = Long.valueOf(moneyId.longValue());
        if (StringUtils.isNotNull(yqGuestList))
        {
            List<YqGuest> list = new ArrayList<YqGuest>();
            for (YqGuest yqGuest : yqGuestList)
            {
                yqGuest.setGuestId(mid);
                list.add(yqGuest);
            }
            if (list.size() > 0)
            {
                yqMoneyMapper.batchYqGuest(list);
            }
        }
    }
}
