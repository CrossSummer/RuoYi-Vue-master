package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_item
 * 
 * @author ruoyi
 * @date 2023-07-13
 */
public class SysItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long itemNo;

    /** 姓(英文) */
    @Excel(name = "姓(英文)")
    private String familyName;

    /** 名(英文) */
    @Excel(name = "名(英文)")
    private String firstName;

    /** 中文姓名 */
    @Excel(name = "中文姓名")
    private String chineseName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 护照号 */
    @Excel(name = "护照号")
    private String passportNo;

    /** 出生地 */
    @Excel(name = "出生地")
    private String placeOfBirth;

    /** 签发地 */
    @Excel(name = "签发地")
    private String placeOfIssue;

    /** 签发日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签发日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfIssue;

    /** 失效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfExpire;

    public void setItemNo(Long itemNo) 
    {
        this.itemNo = itemNo;
    }

    public Long getItemNo() 
    {
        return itemNo;
    }
    public void setFamilyName(String familyName) 
    {
        this.familyName = familyName;
    }

    public String getFamilyName() 
    {
        return familyName;
    }
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public void setChineseName(String chineseName) 
    {
        this.chineseName = chineseName;
    }

    public String getChineseName() 
    {
        return chineseName;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() 
    {
        return dateOfBirth;
    }
    public void setPassportNo(String passportNo) 
    {
        this.passportNo = passportNo;
    }

    public String getPassportNo() 
    {
        return passportNo;
    }
    public void setPlaceOfBirth(String placeOfBirth) 
    {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPlaceOfBirth() 
    {
        return placeOfBirth;
    }
    public void setPlaceOfIssue(String placeOfIssue) 
    {
        this.placeOfIssue = placeOfIssue;
    }

    public String getPlaceOfIssue() 
    {
        return placeOfIssue;
    }
    public void setDateOfIssue(Date dateOfIssue) 
    {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfIssue() 
    {
        return dateOfIssue;
    }
    public void setDateOfExpire(Date dateOfExpire) 
    {
        this.dateOfExpire = dateOfExpire;
    }

    public Date getDateOfExpire() 
    {
        return dateOfExpire;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemNo", getItemNo())
            .append("familyName", getFamilyName())
            .append("firstName", getFirstName())
            .append("chineseName", getChineseName())
            .append("sex", getSex())
            .append("dateOfBirth", getDateOfBirth())
            .append("passportNo", getPassportNo())
            .append("placeOfBirth", getPlaceOfBirth())
            .append("placeOfIssue", getPlaceOfIssue())
            .append("dateOfIssue", getDateOfIssue())
            .append("dateOfExpire", getDateOfExpire())
            .toString();
    }
}
