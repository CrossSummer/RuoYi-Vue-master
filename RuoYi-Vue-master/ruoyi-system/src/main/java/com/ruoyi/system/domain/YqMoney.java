package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客人收入支出对象 yq_money
 * 
 * @author lxl
 * @date 2023-07-25
 */
public class YqMoney extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer moneyId;

    /** 客人ID */
    @Excel(name = "客人ID")
    private Integer guestId;

    /** 客人所属计划 */
    @Excel(name = "客人所属计划")
    private Integer guesetPlan;

    /** 支出(客人) */
    @Excel(name = "支出(客人)")
    private String guestCost;

    /** 收入(客人) */
    @Excel(name = "收入(客人)")
    private String guestIncome;

    /** 利润(客人) */
    @Excel(name = "利润(客人)")
    private String guestProfit;

    /** 客人管理信息 */
    private List<YqGuest> yqGuestList;

    public void setMoneyId(Integer moneyId) 
    {
        this.moneyId = moneyId;
    }

    public Integer getMoneyId() 
    {
        return moneyId;
    }
    public void setGuestId(Integer guestId) 
    {
        this.guestId = guestId;
    }

    public Integer getGuestId() 
    {
        return guestId;
    }
    public void setGuesetPlan(Integer guesetPlan) 
    {
        this.guesetPlan = guesetPlan;
    }

    public Integer getGuesetPlan() 
    {
        return guesetPlan;
    }
    public void setGuestCost(String guestCost) 
    {
        this.guestCost = guestCost;
    }

    public String getGuestCost() 
    {
        return guestCost;
    }
    public void setGuestIncome(String guestIncome) 
    {
        this.guestIncome = guestIncome;
    }

    public String getGuestIncome() 
    {
        return guestIncome;
    }
    public void setGuestProfit(String guestProfit) 
    {
        this.guestProfit = guestProfit;
    }

    public String getGuestProfit() 
    {
        return guestProfit;
    }

    public List<YqGuest> getYqGuestList()
    {
        return yqGuestList;
    }

    public void setYqGuestList(List<YqGuest> yqGuestList)
    {
        this.yqGuestList = yqGuestList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("moneyId", getMoneyId())
            .append("guestId", getGuestId())
            .append("guesetPlan", getGuesetPlan())
            .append("guestCost", getGuestCost())
            .append("guestIncome", getGuestIncome())
            .append("guestProfit", getGuestProfit())
            .append("yqGuestList", getYqGuestList())
            .toString();
    }
}
