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
import com.ruoyi.system.domain.YqMoney;
import com.ruoyi.system.service.IYqMoneyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客人收入支出Controller
 * 
 * @author lxl
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/system/money")
public class YqMoneyController extends BaseController
{
    @Autowired
    private IYqMoneyService yqMoneyService;

    /**
     * 查询客人收入支出列表
     * "@ss.hasPermi('system:money:list')"
     */
    @PreAuthorize("@ss.hasRole('admin')")
    @GetMapping("/list")
    public TableDataInfo list(YqMoney yqMoney)
    {
        startPage();
        List<YqMoney> list = yqMoneyService.selectYqMoneyList(yqMoney);
        return getDataTable(list);
    }

    /**
     * 导出客人收入支出列表
     */
    @PreAuthorize("@ss.hasPermi('system:money:export')")
    @Log(title = "客人收入支出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YqMoney yqMoney)
    {
        List<YqMoney> list = yqMoneyService.selectYqMoneyList(yqMoney);
        ExcelUtil<YqMoney> util = new ExcelUtil<YqMoney>(YqMoney.class);
        util.exportExcel(response, list, "客人收入支出数据");
    }

    /**
     * 获取客人收入支出详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:money:query')")
    @GetMapping(value = "/{moneyId}")
    public AjaxResult getInfo(@PathVariable("moneyId") Integer moneyId)
    {
        return success(yqMoneyService.selectYqMoneyByMoneyId(moneyId));
    }

    /**
     * 新增客人收入支出
     */
    @PreAuthorize("@ss.hasPermi('system:money:add')")
    @Log(title = "客人收入支出", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YqMoney yqMoney)
    {
        return toAjax(yqMoneyService.insertYqMoney(yqMoney));
    }

    /**
     * 修改客人收入支出
     */
    @PreAuthorize("@ss.hasPermi('system:money:edit')")
    @Log(title = "客人收入支出", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YqMoney yqMoney)
    {
        return toAjax(yqMoneyService.updateYqMoney(yqMoney));
    }

    /**
     * 删除客人收入支出
     */
    @PreAuthorize("@ss.hasPermi('system:money:remove')")
    @Log(title = "客人收入支出", businessType = BusinessType.DELETE)
	@DeleteMapping("/{moneyIds}")
    public AjaxResult remove(@PathVariable Integer[] moneyIds)
    {
        return toAjax(yqMoneyService.deleteYqMoneyByMoneyIds(moneyIds));
    }
}
