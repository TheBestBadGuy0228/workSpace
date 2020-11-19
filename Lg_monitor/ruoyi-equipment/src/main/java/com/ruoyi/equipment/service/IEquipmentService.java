package com.ruoyi.equipment.service;

import java.util.List;
import com.ruoyi.equipment.domain.Equipment;

/**
 * 设备Service接口
 * 
 * @author TheBestBadGuy
 * @date 2020-11-19
 */
public interface IEquipmentService 
{
    /**
     * 查询设备
     * 
     * @param monitorId 设备ID
     * @return 设备
     */
    public Equipment selectEquipmentById(Long monitorId);

    /**
     * 查询设备列表
     * 
     * @param equipment 设备
     * @return 设备集合
     */
    public List<Equipment> selectEquipmentList(Equipment equipment);

    /**
     * 新增设备
     * 
     * @param equipment 设备
     * @return 结果
     */
    public int insertEquipment(Equipment equipment);

    /**
     * 修改设备
     * 
     * @param equipment 设备
     * @return 结果
     */
    public int updateEquipment(Equipment equipment);

    /**
     * 批量删除设备
     * 
     * @param monitorIds 需要删除的设备ID
     * @return 结果
     */
    public int deleteEquipmentByIds(Long[] monitorIds);

    /**
     * 删除设备信息
     * 
     * @param monitorId 设备ID
     * @return 结果
     */
    public int deleteEquipmentById(Long monitorId);
}
