package com.hx.syncer.bean;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/10/29.
 */
@Entity
@Table(name = "grid_data_head")
public class GridDataHeadDo {

    @Column(name="g_d_id",nullable=false)
    private long g_d_id;
    @Column(name = "data_logo",nullable=false)
    private String data_logo;//": "RSURF_CH",    -----资料标示
    @Column(name = "data_code",nullable=false)
    private String data_code;//": "SURF_CHN_MUL_HOR",   -----接口参数 资料代码  类似身份证号
    @Column(name = "data_name",nullable=true)
    private String data_name;//": "中国地面逐小时资料",  ------资料名  类似身份证人名
    @Column(name = "retrieve_start_time",nullable=true)
    private Timestamp retrieve_start_time;//: "2017-07-20 09:16:47",  -----任务启动时间
    @Column(name = "retrieve_end_time",nullable=true)
    private Timestamp retrieve_end_time;//": "2017-07-20 09:18:01",   -----任务结束时间
    @Column(name = "retrieve_process_time",nullable=true)
    private double retrieve_process_time;//": "59.368",   -----程序耗时
    @Column(name = "data_time",nullable=true)
    private Timestamp data_time;//": "201707170000",  -----资料时间点
    @Column(name = "file_path",nullable=true)
    private String file_path;//": "./savefiles/RSURF_CH/201707170000/rec_RAWST_201707170000_g_0300_0300.dat",    ----资料输出文件路径
    @Column(name = "data_start_time",nullable=true)
    private Timestamp data_start_time;//": "2017-07-16 21:00:00",   ------资料起始时间（检索系统会处理时间点形成时间段）
    @Column(name = "data_end_time",nullable=true)
    private Timestamp data_end_time;//": "2017-07-17 03:00:00",    -----资料结束时间
    @Column(name = "gridfile_num_max",nullable=true)
    private int gridfileNumMax;
    @Column(name = "gridfile_state",nullable=true)
    private String gridfile_state;
    @Column(name = "longitude_latitude_scope",nullable=true)
    private String longitude_latitude_scope;//": "73.33,135.05:3.51,53.33",   ----资料的经纬度范围
    @Column(name = "sys_conn_state",nullable=true)
    private String sys_conn_state;//": "0",  ------cimiss接口连接状态 0表示成功连接服务器
    @Column(name = "data_num",nullable=true)
    private String data_num;//": "364526",   -----一次任务得到的资料站台数（预处理前的资料行数,即一行一个站的记录）
    @Column(name = "return_abnormal_info",nullable=true)
    private String return_abnormal_info;//": "0:Query Succeed",   -----调用接口后 返回码和返回码信息
    @Column(name = "user_id",nullable=true)
    private String user_id;//": "NMC_SZYB_TSW",   ----cimiss接口的使用账号
    @Column(name = "system_name",nullable=true)
    private String system_name;//": "Numerical Weather Prediction Center of CMA(global)",   -----系统用户名，即可以以此区分不同模式类型，例如区域模式和全球模式 （人为规定）
    @Column(name = "data_type",nullable=true)
    private int data_type;//": "1",  ----资料类型 1:站点 2:格点 3:文件（资料本身）
    @Column(name = "site_type",nullable=true)
    private int site_type;//": "1",  ----站点类型 1:区域(中国)站点 2:全球站点（资料本身）
    @Column(name = "elements",nullable=true)
    private String elements;
    @Column(name = "validTime",nullable=true)
    private String validTime;
    @Column(name = "fcstLevel",nullable=true)
    private String fcstLevel;

    @javax.persistence.Id//": "主键",
    @Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
    private long id;

    public long getG_d_id() {
        return g_d_id;
    }

    public void setG_d_id(long g_d_id) {
        this.g_d_id = g_d_id;
    }

    public String getData_logo() {
        return data_logo;
    }

    public void setData_logo(String data_logo) {
        this.data_logo = data_logo;
    }

    public String getData_code() {
        return data_code;
    }

    public void setData_code(String data_code) {
        this.data_code = data_code;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public Timestamp getRetrieve_start_time() {
        return retrieve_start_time;
    }

    public void setRetrieve_start_time(Timestamp retrieve_start_time) {
        this.retrieve_start_time = retrieve_start_time;
    }

    public Timestamp getRetrieve_end_time() {
        return retrieve_end_time;
    }

    public void setRetrieve_end_time(Timestamp retrieve_end_time) {
        this.retrieve_end_time = retrieve_end_time;
    }

    public double getRetrieve_process_time() {
        return retrieve_process_time;
    }

    public void setRetrieve_process_time(double retrieve_process_time) {
        this.retrieve_process_time = retrieve_process_time;
    }

    public Timestamp getData_time() {
        return data_time;
    }

    public void setData_time(Timestamp data_time) {
        this.data_time = data_time;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Timestamp getData_start_time() {
        return data_start_time;
    }

    public void setData_start_time(Timestamp data_start_time) {
        this.data_start_time = data_start_time;
    }

    public Timestamp getData_end_time() {
        return data_end_time;
    }

    public void setData_end_time(Timestamp data_end_time) {
        this.data_end_time = data_end_time;
    }

    public long getGridfileNumMax() {
        return gridfileNumMax;
    }

    public void setGridfileNumMax(int gridfileNumMax) {
        this.gridfileNumMax = gridfileNumMax;
    }

    public String getGridfile_state() {
        return gridfile_state;
    }

    public void setGridfile_state(String gridfile_state) {
        this.gridfile_state = gridfile_state;
    }

    public String getLongitude_latitude_scope() {
        return longitude_latitude_scope;
    }

    public void setLongitude_latitude_scope(String longitude_latitude_scope) {
        this.longitude_latitude_scope = longitude_latitude_scope;
    }

    public String getData_num() {
        return data_num;
    }

    public void setData_num(String data_num) {
        this.data_num = data_num;
    }

    public String getSys_conn_state() {
        return sys_conn_state;
    }

    public void setSys_conn_state(String sys_conn_state) {
        this.sys_conn_state = sys_conn_state;
    }

    public String getReturn_abnormal_info() {
        return return_abnormal_info;
    }

    public void setReturn_abnormal_info(String return_abnormal_info) {
        this.return_abnormal_info = return_abnormal_info;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public int getData_type() {
        return data_type;
    }

    public void setData_type(int data_type) {
        this.data_type = data_type;
    }

    public int getSite_type() {
        return site_type;
    }

    public void setSite_type(int site_type) {
        this.site_type = site_type;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
