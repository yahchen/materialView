package com.hx.bean;

import java.util.Date;

/**
 * Created by hp on 2017/10/31.
 */
public class SiteDataHead {
    private long sDId;
    private String dataLogo;
    private String dadaName;
    private String dataCode;
    private Date retrieveStartTime;
    private Date retrieveEndTime;
    private double retrieveProcessTime;
    private Date dataTime;
    private String filePath;
    private Date dataStartTime;
    private Date dataEndTime;
    private String longitudeLatitudeScope;
    private String sysConnState;
    private long dataNum;
    private String userId;
    private String systemName;
    private Integer dataType;
    private Integer siteType;
    private String returnAbnormalInfo;

    public long getsDId() {
        return sDId;
    }

    public void setsDId(long sDId) {
        this.sDId = sDId;
    }

    public String getDataLogo() {
        return dataLogo;
    }

    public void setDataLogo(String dataLogo) {
        this.dataLogo = dataLogo;
    }

    public String getDadaName() {
        return dadaName;
    }

    public void setDadaName(String dadaName) {
        this.dadaName = dadaName;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
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

    public long getDataNum() {
        return dataNum;
    }

    public void setDataNum(long dataNum) {
        this.dataNum = dataNum;
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

    public String getReturnAbnormalInfo() {
        return returnAbnormalInfo;
    }

    public void setReturnAbnormalInfo(String returnAbnormalInfo) {
        this.returnAbnormalInfo = returnAbnormalInfo;
    }
}
