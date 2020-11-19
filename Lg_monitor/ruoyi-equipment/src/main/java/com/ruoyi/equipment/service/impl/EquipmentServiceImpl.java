package com.ruoyi.equipment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.EquipmentMapper;
import com.ruoyi.equipment.domain.Equipment;
import com.ruoyi.equipment.service.IEquipmentService;

/**
 * 设备Service业务层处理
 * 
 * @author TheBestBadGuy
 * @date 2020-11-19
 */
@Service
public class EquipmentServiceImpl implements IEquipmentService 
{
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 查询设备
     * 
     * @param monitorId 设备ID
     * @return 设备
     */
    @Override
    public Equipment selectEquipmentById(Long monitorId)
    {
        return equipmentMapper.selectEquipmentById(monitorId);
    }

    /**
     * 查询设备列表
     * 
     * @param equipment 设备
     * @return 设备
     */
    @Override
    public List<Equipment> selectEquipmentList(Equipment equipment)
    {
        return equipmentMapper.selectEquipmentList(equipment);
    }

    /**
     * 新增设备
     * 
     * @param equipment 设备
     * @return 结果
     */
    @Override
    public int insertEquipment(Equipment equipment)
    {
        return equipmentMapper.insertEquipment(equipment);
    }

    /**
     * 修改设备
     * 
     * @param equipment 设备
     * @return 结果
     */
    @Override
    public int updateEquipment(Equipment equipment)
    {
        return equipmentMapper.updateEquipment(equipment);
    }

    /**
     * 批量删除设备
     * 
     * @param monitorIds 需要删除的设备ID
     * @return 结果
     */
    @Override
    public int deleteEquipmentByIds(Long[] monitorIds)
    {
        return equipmentMapper.deleteEquipmentByIds(monitorIds);
    }

    /**
     * 删除设备信息
     * 
     * @param monitorId 设备ID
     * @return 结果
     */
    @Override
    public int deleteEquipmentById(Long monitorId)
    {
        return equipmentMapper.deleteEquipmentById(monitorId);
    }
}
