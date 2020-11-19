package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备对象 equipment
 * 
 * @author TheBestBadGuy
 * @date 2020-11-19
 */
public class Equipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private Long monitorId;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String monitorModel;

    /** rtsp播放地址 */
    @Excel(name = "rtsp播放地址")
    private String monitorRtspAddress;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private Integer monitorType;

    public void setMonitorId(Long monitorId) 
    {
        this.monitorId = monitorId;
    }

    public Long getMonitorId() 
    {
        return monitorId;
    }
    public void setMonitorModel(String monitorModel) 
    {
        this.monitorModel = monitorModel;
    }

    public String getMonitorModel() 
    {
        return monitorModel;
    }
    public void setMonitorRtspAddress(String monitorRtspAddress) 
    {
        this.monitorRtspAddress = monitorRtspAddress;
    }

    public String getMonitorRtspAddress() 
    {
        return monitorRtspAddress;
    }
    public void setMonitorType(Integer monitorType) 
    {
        this.monitorType = monitorType;
    }

    public Integer getMonitorType() 
    {
        return monitorType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("monitorId", getMonitorId())
            .append("monitorModel", getMonitorModel())
            .append("monitorRtspAddress", getMonitorRtspAddress())
            .append("monitorType", getMonitorType())
            .toString();
    }
}
