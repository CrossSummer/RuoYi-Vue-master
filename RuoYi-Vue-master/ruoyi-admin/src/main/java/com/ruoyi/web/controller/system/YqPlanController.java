package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.YqPlan;
import com.ruoyi.system.service.IYqPlanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 送签计划Controller
 * 
 * @author lxl
 * @date 2023-07-17
 */
@RestController
@RequestMapping("/system/plan")
public class YqPlanController extends BaseController
{
    @Autowired
    private IYqPlanService yqPlanService;

    /**
     * 查询送签计划列表
     * "@ss.hasRole('admin')"
     * "@ss.hasPermi('system:plan:list')"
     */
    @PreAuthorize("@ss.hasPermi('system:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(YqPlan yqPlan)
    {
        startPage();
        List<YqPlan> list = yqPlanService.selectYqPlanList(yqPlan);
        return getDataTable(list);
    }

    /**
     * 导出送签计划列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:export')")
    @Log(title = "送签计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YqPlan yqPlan)
    {
        List<YqPlan> list = yqPlanService.selectYqPlanList(yqPlan);
        ExcelUtil<YqPlan> util = new ExcelUtil<YqPlan>(YqPlan.class);
        util.exportExcel(response, list, "送签计划数据");
    }

    /**
     * 获取送签计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:plan:query')")
    @GetMapping(value = "/{planId}")
    public AjaxResult getInfo(@PathVariable("planId") Long planId)
    {
        return success(yqPlanService.selectYqPlanByPlanId(planId));
    }

    /**
     * 新增送签计划
     */
    @PreAuthorize("@ss.hasPermi('system:plan:add')")
    @Log(title = "送签计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YqPlan yqPlan)
    {
        return toAjax(yqPlanService.insertYqPlan(yqPlan));
    }

    /**
     * 修改送签计划
     */
    @PreAuthorize("@ss.hasPermi('system:plan:edit')")
    @Log(title = "送签计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YqPlan yqPlan)
    {
        return toAjax(yqPlanService.updateYqPlan(yqPlan));
    }

    /**
     * 删除送签计划
     */
    @PreAuthorize("@ss.hasPermi('system:plan:remove')")
    @Log(title = "送签计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planIds}")
    public AjaxResult remove(@PathVariable Long[] planIds)
    {
        return toAjax(yqPlanService.deleteYqPlanByPlanIds(planIds));
    }
}
