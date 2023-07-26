package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.YqPlan;

/**
 * 送签计划Service接口
 * 
 * @author lxl
 * @date 2023-07-17
 */
public interface IYqPlanService 
{
    /**
     * 查询送签计划
     * 
     * @param planId 送签计划主键
     * @return 送签计划
     */
    public YqPlan selectYqPlanByPlanId(Long planId);

    /**
     * 查询送签计划列表
     * 
     * @param yqPlan 送签计划
     * @return 送签计划集合
     */
    public List<YqPlan> selectYqPlanList(YqPlan yqPlan);

    /**
     * 新增送签计划
     * 
     * @param yqPlan 送签计划
     * @return 结果
     */
    public int insertYqPlan(YqPlan yqPlan);

    /**
     * 修改送签计划
     * 
     * @param yqPlan 送签计划
     * @return 结果
     */
    public int updateYqPlan(YqPlan yqPlan);

    /**
     * 批量删除送签计划
     * 
     * @param planIds 需要删除的送签计划主键集合
     * @return 结果
     */
    public int deleteYqPlanByPlanIds(Long[] planIds);

    /**
     * 删除送签计划信息
     * 
     * @param planId 送签计划主键
     * @return 结果
     */
    public int deleteYqPlanByPlanId(Long planId);
}
