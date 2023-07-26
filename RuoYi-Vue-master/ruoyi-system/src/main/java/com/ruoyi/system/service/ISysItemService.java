package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysItem;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-07-13
 */
public interface ISysItemService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param itemNo 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysItem selectSysItemByItemNo(Long itemNo);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysItem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysItem> selectSysItemList(SysItem sysItem);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysItem 【请填写功能名称】
     * @return 结果
     */
    public int insertSysItem(SysItem sysItem);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysItem 【请填写功能名称】
     * @return 结果
     */
    public int updateSysItem(SysItem sysItem);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param itemNos 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysItemByItemNos(Long[] itemNos);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param itemNo 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysItemByItemNo(Long itemNo);
}
