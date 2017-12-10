package com.hx.bean;

public class BehaviorRecordParam {
    private String modeType;//模式类型  1:全球 2:区域  3检验
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String materialType;//资料类型 大类(站点、格点、卫星、文件)
    private String materialName;//资料名称
    private String sateName;//系统名称
    private String timeConsumeIndex;//0表示全部   1表示<=1s  2表示 1-2s  3表示2-5s 4 表示>5s
    private String timeConsume;//耗时
    private String succFail;//成功 or 失败

    private Integer pageNo;//页码
    private Integer pageSize;//每页显示记录数

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSateName() {
        return sateName;
    }

    public void setSateName(String sateName) {
        this.sateName = sateName;
    }

    public String getSuccFail() {
        return succFail;
    }

    public void setSuccFail(String succFail) {
        this.succFail = succFail;
    }

    public String getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(String timeConsume) {
        this.timeConsume = timeConsume;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTimeConsumeIndex() {
        return timeConsumeIndex;
    }

    public void setTimeConsumeIndex(String timeConsumeIndex) {
        this.timeConsumeIndex = timeConsumeIndex;
    }

    public String getModeType() {
        return modeType;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }
}
