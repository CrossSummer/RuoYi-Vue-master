package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 送签计划对象 yq_plan
 * 
 * @author lxl
 * @date 2023-07-17
 */
public class YqPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计划ID */
    private Long planId;

    /** 计划名称 */
    @Excel(name = "计划名称")
    private String planName;

    /** 收件日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收件日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptDate;

    /** 录指纹日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "录指纹日期时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fingerprintDatetime;

    /** 出行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date travelDate;

    /** 签证国 */
    @Excel(name = "签证国")
    private String visaCountry;

    /** 送签日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "送签日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitDate;

    /** 送签城市 */
    @Excel(name = "送签城市")
    private String submitCity;

    /** 销售 */
    @Excel(name = "销售")
    private String salePerson;

    /** 客户 */
    @Excel(name = "客户")
    private String custom;

    /** 客人名(...等) */
    @Excel(name = "客人名(...等)")
    private String guestEq;

    /** 客人数 */
    @Excel(name = "客人数")
    private Long guestNum;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /**
     * 计划类型
     * 1-团队;2-个签;3-其他
     */
    @Excel(name = "计划类型")
    private int plantype;

    /** 支出(计划) */
    @Excel(name = "支出(计划)")
    private String planCost;

    /** 收入(计划) */
    @Excel(name = "收入(计划)")
    private String planIncome;

    /** 利润(计划) */
    @Excel(name = "利润(计划)")
    private String planProfit;

    /** 客人信息 */
    private List<YqGuest> yqGuestList;

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }
    public Long getPlanId() 
    {
        return planId;
    }

    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }
    public String getPlanName() 
    {
        return planName;
    }

    public void setReceiptDate(Date receiptDate) 
    {
        this.receiptDate = receiptDate;
    }
    public Date getReceiptDate() 
    {
        return receiptDate;
    }

    public void setFingerprintDatetime(Date fingerprintDatetime) 
    {
        this.fingerprintDatetime = fingerprintDatetime;
    }
    public Date getFingerprintDatetime() 
    {
        return fingerprintDatetime;
    }

    public void setTravelDate(Date travelDate) 
    {
        this.travelDate = travelDate;
    }
    public Date getTravelDate() 
    {
        return travelDate;
    }

    public void setVisaCountry(String visaCountry) 
    {
        this.visaCountry = visaCountry;
    }
    public String getVisaCountry() 
    {
        return visaCountry;
    }

    public void setSubmitDate(Date submitDate) 
    {
        this.submitDate = submitDate;
    }
    public Date getSubmitDate() 
    {
        return submitDate;
    }

    public void setSubmitCity(String submitCity) 
    {
        this.submitCity = submitCity;
    }
    public String getSubmitCity() 
    {
        return submitCity;
    }

    public void setSalePerson(String salePerson) 
    {
        this.salePerson = salePerson;
    }
    public String getSalePerson() 
    {
        return salePerson;
    }

    public void setCustom(String custom) 
    {
        this.custom = custom;
    }
    public String getCustom() 
    {
        return custom;
    }

    public void setGuestEq(String guestEq) 
    {
        this.guestEq = guestEq;
    }
    public String getGuestEq() 
    {
        return guestEq;
    }

    public void setGuestNum(Long guestNum) 
    {
        this.guestNum = guestNum;
    }
    public Long getGuestNum() 
    {
        return guestNum;
    }

    public void setAccount(String account) 
    {
        this.account = account;
    }
    public String getAccount() 
    {
        return account;
    }

    public void setNotes(String notes) 
    {
        this.notes = notes;
    }
    public String getNotes() 
    {
        return notes;
    }

    public List<YqGuest> getYqGuestList()
    {
        return yqGuestList;
    }
    public void setYqGuestList(List<YqGuest> yqGuestList)
    {
        this.yqGuestList = yqGuestList;
    }

    public int getPlantype() {
        return plantype;
    }
    public void setPlantype(int plantype) {
        this.plantype = plantype;
    }

    public String getPlanCost() {
        return planCost;
    }
    public void setPlanCost(String planCost) {
        this.planCost = planCost;
    }

    public String getPlanIncome() {
        return planIncome;
    }
    public void setPlanIncome(String planIncome) {
        this.planIncome = planIncome;
    }

    public String getPlanProfit() {
        return planProfit;
    }
    public void setPlanProfit(String planProfit) {
        this.planProfit = planProfit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("planName", getPlanName())
            .append("receiptDate", getReceiptDate())
            .append("fingerprintDatetime", getFingerprintDatetime())
            .append("travelDate", getTravelDate())
            .append("visaCountry", getVisaCountry())
            .append("submitDate", getSubmitDate())
            .append("submitCity", getSubmitCity())
            .append("salePerson", getSalePerson())
            .append("custom", getCustom())
            .append("guestEq", getGuestEq())
            .append("guestNum", getGuestNum())
            .append("account", getAccount())
            .append("notes", getNotes())
            .append("plantype", getPlantype())
            .append("yqGuestList", getYqGuestList())
            .toString();
    }
}
