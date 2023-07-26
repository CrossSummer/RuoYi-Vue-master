package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.YqPlan;
import com.ruoyi.system.domain.YqGuest;

/**
 * 送签计划Mapper接口
 * 
 * @author lxl
 * @date 2023-07-17
 */
public interface YqPlanMapper 
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
     * 删除送签计划
     * 
     * @param planId 送签计划主键
     * @return 结果
     */
    public int deleteYqPlanByPlanId(Long planId);

    /**
     * 批量删除送签计划
     * 
     * @param planIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYqPlanByPlanIds(Long[] planIds);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param planIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYqGuestByPlans(Long[] planIds);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param yqGuestList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchYqGuest(List<YqGuest> yqGuestList);
    

    /**
     * 通过送签计划主键删除${subTable.functionName}信息
     * 
     * @param planId 送签计划ID
     * @return 结果
     */
    public int deleteYqGuestByPlan(Long planId);
}
