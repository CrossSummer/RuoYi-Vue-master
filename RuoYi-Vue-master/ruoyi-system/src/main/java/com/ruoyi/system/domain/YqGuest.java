package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ${subTable.functionName}对象 yq_guest
 * 
 * @author lxl
 * @date 2023-07-17
 */
public class YqGuest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客人ID */
    private Long guestId;

    /** 中文姓名 */
    @Excel(name = "中文姓名")
    private String ppChinesename;

    /** 姓(英文) */
    @Excel(name = "姓(英文)")
    private String ppFamilyname;

    /** 名(英文) */
    @Excel(name = "名(英文)")
    private String ppFirstname;

    /** 性别 */
    @Excel(name = "性别")
    private String ppGender;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ppBirthDate;

    /** 出生地点 */
    @Excel(name = "出生地点")
    private String ppBirthPlace;

    /** 国籍 */
    @Excel(name = "国籍")
    private String ppNationality;

    /** 手机 */
    @Excel(name = "手机")
    private String guestPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String guestEmail;

    /** 护照国家码 */
    @Excel(name = "护照国家码")
    private String ppCountryCode;

    /** 护照号码 */
    @Excel(name = "护照号码")
    private String ppNo;

    /** 护照类型 */
    @Excel(name = "护照类型")
    private String ppType;

    /** 护照签发日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "护照签发日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ppIssueDate;

    /** 护照签发地点 */
    @Excel(name = "护照签发地点")
    private String ppIssuePlace;

    /** 护照有效期至 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "护照有效期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ppExpireDate;

    /** 护照签发机关 */
    @Excel(name = "护照签发机关")
    private String ppIssueOrganization;

    /** 所属计划 */
    @Excel(name = "所属计划")
    private Long plan;

    /** 支出(客人) */
    @Excel(name = "支出(客人)")
    private String guestCost;

    /** 收入(客人) */
    @Excel(name = "收入(客人)")
    private String guestIncome;

    /** 利润(客人) */
    @Excel(name = "利润(客人)")
    private String guestProfit;

    public void setGuestId(Long guestId) 
    {
        this.guestId = guestId;
    }
    public Long getGuestId() 
    {
        return guestId;
    }

    public void setPpChinesename(String ppChinesename) 
    {
        this.ppChinesename = ppChinesename;
    }
    public String getPpChinesename() 
    {
        return ppChinesename;
    }

    public void setPpFamilyname(String ppFamilyname) 
    {
        this.ppFamilyname = ppFamilyname;
    }
    public String getPpFamilyname() 
    {
        return ppFamilyname;
    }

    public void setPpFirstname(String ppFirstname) 
    {
        this.ppFirstname = ppFirstname;
    }
    public String getPpFirstname() 
    {
        return ppFirstname;
    }

    public void setPpGender(String ppGender) {
        this.ppGender = ppGender;
    }
    public String getPpGender() {
        return ppGender;
    }

    public void setPpBirthDate(Date ppBirthDate) {
        this.ppBirthDate = ppBirthDate;
    }
    public Date getPpBirthDate() {
        return ppBirthDate;
    }

    public void setPpBirthPlace(String ppBirthPlace) {
        this.ppBirthPlace = ppBirthPlace;
    }
    public String getPpBirthPlace() {
        return ppBirthPlace;
    }

    public void setPpNationality(String ppNationality) {
        this.ppNationality = ppNationality;
    }
    public String getPpNationality() {
        return ppNationality;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }
    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }
    public String getGuestEmail() {
        return guestEmail;
    }

    public void setPpCountryCode(String ppCountryCode) {
        this.ppCountryCode = ppCountryCode;
    }
    public String getPpCountryCode() {
        return ppCountryCode;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }
    public String getPpNo() {
        return ppNo;
    }

    public void setPpType(String ppType) {
        this.ppType = ppType;
    }
    public String getPpType() {
        return ppType;
    }

    public void setPpIssueDate(Date ppIssueDate) {
        this.ppIssueDate = ppIssueDate;
    }
    public Date getPpIssueDate() {
        return ppIssueDate;
    }

    public void setPpIssuePlace(String ppIssuePlace) {
        this.ppIssuePlace = ppIssuePlace;
    }
    public String getPpIssuePlace() {
        return ppIssuePlace;
    }

    public void setPpExpireDate(Date ppExpireDate) {
        this.ppExpireDate = ppExpireDate;
    }
    public Date getPpExpireDate() {
        return ppExpireDate;
    }

    public void setPpIssueOrganization(String ppIssueOrganization) {
        this.ppIssueOrganization = ppIssueOrganization;
    }
    public String getPpIssueOrganization() {
        return ppIssueOrganization;
    }

    public void setPlan(Long plan) {
        this.plan = plan;
    }
    public Long getPlan() {
        return plan;
    }

    public String getGuestCost() {
        return guestCost;
    }
    public void setGuestCost(String guestCost) {
        this.guestCost = guestCost;
    }

    public String getGuestIncome() {
        return guestIncome;
    }
    public void setGuestIncome(String guestIncome) {
        this.guestIncome = guestIncome;
    }

    public String getGuestProfit() {
        return guestProfit;
    }
    public void setGuestProfit(String guestProfit) {
        this.guestProfit = guestProfit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("guestId", getGuestId())
            .append("ppChinesename", getPpChinesename())
            .append("ppFamilyname", getPpFamilyname())
            .append("ppFirstname", getPpFirstname())
            .append("ppGender", getPpGender())
            .append("ppBirthDate", getPpBirthDate())
            .append("ppBirthPlace", getPpBirthPlace())
            .append("ppNationality", getPpNationality())
            .append("guestPhone", getGuestPhone())
            .append("guestEmail", getGuestEmail())
            .append("ppCountryCode", getPpCountryCode())
            .append("ppNo", getPpNo())
            .append("ppType", getPpType())
            .append("ppIssueDate", getPpIssueDate())
            .append("ppIssuePlace", getPpIssuePlace())
            .append("ppExpireDate", getPpExpireDate())
            .append("ppIssueOrganization", getPpIssueOrganization())
            .append("plan", getPlan())
            .toString();
    }
}
