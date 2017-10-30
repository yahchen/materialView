package com.hx.bean;

import java.util.Date;

/**
 * Created by hp on 2017/10/29.
 */
public class GridDataHead {
    private Long gDId;//资料id
    private String dataLogo;//小类资料唯一标识
    private String dataCode;//资料编码
    private String dataName;//资料名称
    private Date retrieveStartTime;//检索启动时间
    private Date retrieveEndTime;//检索结束时间
    private double retrieveProcessTime;//每类资料检索耗时，单位为s
    private Date dataTime;//资料时间点
    private String filePath;//资源路径，标识格点或站点资源的路径
    private Date dataStartTime;//资料开始时间
    private Date dataEndTime;//资料结束时间
    private Integer gridfileNumMax;//总的最大文件数
    private String gridfileState;//文件状态
    private String longitudeLatitudeScope;//经纬度范围(起始经度,终止经度:起始纬度,终止纬度)
    private String sysConnState;//系统连接cimiss服务器状态（0：正常，1：异常）
    private String dataNum;//资料（要素或文件）个数,记录的行数
    private String returnAbnormalInfo;//接口返回码和返回信息
    private String userId;//CIMISS系统用户ID
    private String systemName;//业务系统名称(区分使用人员)
    private Integer dataType;//资料类型，1:站点 2:格点 3:文件
    private Integer siteType;//站点类型，1:区域(中国)站点 2:全球站点(用于画二维分布图时，区分：区域/全球)
    private String elements;
    private String validTime;//时效
    private String fcstLevel;//层次

    public Long getgDId() {
        return gDId;
    }

    public void setgDId(Long gDId) {
        this.gDId = gDId;
    }

    public String getDataLogo() {
        return dataLogo;
    }

    public void setDataLogo(String dataLogo) {
        this.dataLogo = dataLogo;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Date getRetrieveStartTime() {
        return retrieveStartTime;
    }

    public void setRetrieveStartTime(Date retrieveStartTime) {
        this.retrieveStartTime = retrieveStartTime;
    }

    public Date getRetrieveEndTime() {
        return retrieveEndTime;
    }

    public void setRetrieveEndTime(Date retrieveEndTime) {
        this.retrieveEndTime = retrieveEndTime;
    }

    public double getRetrieveProcessTime() {
        return retrieveProcessTime;
    }

    public void setRetrieveProcessTime(double retrieveProcessTime) {
        this.retrieveProcessTime = retrieveProcessTime;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getDataStartTime() {
        return dataStartTime;
    }

    public void setDataStartTime(Date dataStartTime) {
        this.dataStartTime = dataStartTime;
    }

    public Date getDataEndTime() {
        return dataEndTime;
    }

    public void setDataEndTime(Date dataEndTime) {
        this.dataEndTime = dataEndTime;
    }

    public Integer getGridfileNumMax() {
        return gridfileNumMax;
    }

    public void setGridfileNumMax(Integer gridfileNumMax) {
        this.gridfileNumMax = gridfileNumMax;
    }

    public String getGridfileState() {
        return gridfileState;
    }

    public void setGridfileState(String gridfileState) {
        this.gridfileState = gridfileState;
    }

    public String getLongitudeLatitudeScope() {
        return longitudeLatitudeScope;
    }

    public void setLongitudeLatitudeScope(String longitudeLatitudeScope) {
        this.longitudeLatitudeScope = longitudeLatitudeScope;
    }

    public String getSysConnState() {
        return sysConnState;
    }

    public void setSysConnState(String sysConnState) {
        this.sysConnState = sysConnState;
    }

    public String getDataNum() {
        return dataNum;
    }

    public void setDataNum(String dataNum) {
        this.dataNum = dataNum;
    }

    public String getReturnAbnormalInfo() {
        return returnAbnormalInfo;
    }

    public void setReturnAbnormalInfo(String returnAbnormalInfo) {
        this.returnAbnormalInfo = returnAbnormalInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getFcstLevel() {
        return fcstLevel;
    }

    public void setFcstLevel(String fcstLevel) {
        this.fcstLevel = fcstLevel;
    }
}
