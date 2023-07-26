package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.YqGuest;
import com.ruoyi.system.mapper.YqPlanMapper;
import com.ruoyi.system.domain.YqPlan;
import com.ruoyi.system.service.IYqPlanService;

/**
 * 送签计划Service业务层处理
 * 
 * @author lxl
 * @date 2023-07-17
 */
@Service
public class YqPlanServiceImpl implements IYqPlanService 
{
    @Autowired
    private YqPlanMapper yqPlanMapper;

    /**
     * 查询送签计划
     * 
     * @param planId 送签计划主键
     * @return 送签计划
     */
    @Override
    public YqPlan selectYqPlanByPlanId(Long planId)
    {
        return yqPlanMapper.selectYqPlanByPlanId(planId);
    }

    /**
     * 查询送签计划列表
     * 
     * @param yqPlan 送签计划
     * @return 送签计划
     */
    @Override
    public List<YqPlan> selectYqPlanList(YqPlan yqPlan)
    {
        return yqPlanMapper.selectYqPlanList(yqPlan);
    }

    /**
     * 新增送签计划
     * 
     * @param yqPlan 送签计划
     * @return 结果
     */
    @Transactional
    @Override
    public int insertYqPlan(YqPlan yqPlan)
    {
        int rows = yqPlanMapper.insertYqPlan(yqPlan);
        insertYqGuest(yqPlan);
        return rows;
    }

    /**
     * 修改送签计划
     * 
     * @param yqPlan 送签计划
     * @return 结果
     */
    @Transactional
    @Override
    public int updateYqPlan(YqPlan yqPlan)
    {
        yqPlanMapper.deleteYqGuestByPlan(yqPlan.getPlanId());
        insertYqGuest(yqPlan);
        return yqPlanMapper.updateYqPlan(yqPlan);
    }

    /**
     * 批量删除送签计划
     * 
     * @param planIds 需要删除的送签计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteYqPlanByPlanIds(Long[] planIds)
    {
        yqPlanMapper.deleteYqGuestByPlans(planIds);
        return yqPlanMapper.deleteYqPlanByPlanIds(planIds);
    }

    /**
     * 删除送签计划信息
     * 
     * @param planId 送签计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteYqPlanByPlanId(Long planId)
    {
        yqPlanMapper.deleteYqGuestByPlan(planId);
        return yqPlanMapper.deleteYqPlanByPlanId(planId);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param yqPlan 送签计划对象
     */
    public void insertYqGuest(YqPlan yqPlan)
    {
        List<YqGuest> yqGuestList = yqPlan.getYqGuestList();
        Long planId = yqPlan.getPlanId();
        if (StringUtils.isNotNull(yqGuestList))
        {
            List<YqGuest> list = new ArrayList<YqGuest>();
            for (YqGuest yqGuest : yqGuestList)
            {
                yqGuest.setPlan(planId);
                list.add(yqGuest);
            }
            if (list.size() > 0)
            {
                yqPlanMapper.batchYqGuest(list);
            }
        }
    }
}
