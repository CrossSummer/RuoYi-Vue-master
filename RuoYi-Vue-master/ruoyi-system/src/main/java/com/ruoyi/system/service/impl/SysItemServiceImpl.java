package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysItemMapper;
import com.ruoyi.system.domain.SysItem;
import com.ruoyi.system.service.ISysItemService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-13
 */
@Service
public class SysItemServiceImpl implements ISysItemService 
{
    @Autowired
    private SysItemMapper sysItemMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param itemNo 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysItem selectSysItemByItemNo(Long itemNo)
    {
        return sysItemMapper.selectSysItemByItemNo(itemNo);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysItem 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysItem> selectSysItemList(SysItem sysItem)
    {
        return sysItemMapper.selectSysItemList(sysItem);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysItem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysItem(SysItem sysItem)
    {
        return sysItemMapper.insertSysItem(sysItem);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysItem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysItem(SysItem sysItem)
    {
        return sysItemMapper.updateSysItem(sysItem);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param itemNos 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysItemByItemNos(Long[] itemNos)
    {
        return sysItemMapper.deleteSysItemByItemNos(itemNos);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param itemNo 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysItemByItemNo(Long itemNo)
    {
        return sysItemMapper.deleteSysItemByItemNo(itemNo);
    }
}
