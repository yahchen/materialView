package com.hx.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/8.
 */
public class SiteDataOrigin {

    private String data_logo;//": "RSURF_CH",    -----资料标示
    private String data_code;//": "SURF_CHN_MUL_HOR",   -----接口参数 资料代码  类似身份证号
    private String data_name;//": "中国地面逐小时资料",  ------资料名  类似身份证人名
    private String retrieve_start_time;//: "2017-07-20 09:16:47",  -----任务启动时间
    private String retrieve_end_time;//": "2017-07-20 09:18:01",   -----任务结束时间
    private String retrieve_process_time;//": "59.368",   -----程序耗时
    private String data_time;//": "201707170000",  -----资料时间点
    private String file_path;//": "./savefiles/RSURF_CH/201707170000/rec_RAWST_201707170000_g_0300_0300.dat",    ----资料输出文件路径
    private String data_start_time;//": "2017-07-16 21:00:00",   ------资料起始时间（检索系统会处理时间点形成时间段）
    private String data_end_time;//": "2017-07-17 03:00:00",    -----资料结束时间
    private String longitude_latitude_scope;//": "73.33,135.05:3.51,53.33",   ----资料的经纬度范围
    private long data_num;//": "364526",   -----一次任务得到的资料站台数（预处理前的资料行数,即一行一个站的记录）
    private int sys_conn_state;//": "0",  ------cimiss接口连接状态 0表示成功连接服务器
    private String return_abnormal_info;//": "0:Query Succeed",   -----调用接口后 返回码和返回码信息
    private String user_id;//": "NMC_SZYB_TSW",   ----cimiss接口的使用账号
    private String system_name;//": "Numerical Weather Prediction Center of CMA(global)",   -----系统用户名，即可以以此区分不同模式类型，例如区域模式和全球模式 （人为规定）
    private int data_type;//": "1",  ----资料类型 1:站点 2:格点 3:文件（资料本身）
    private int mode_type;//": "1",  ----站点类型 1:区域(中国)站点 2:全球站点（资料本身）
    private Map<String,List> elements = new HashMap<>();

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

    public String getRetrieve_start_time() {
        return retrieve_start_time;
    }

    public void setRetrieve_start_time(String retrieve_start_time) {
        this.retrieve_start_time = retrieve_start_time;
    }

    public String getRetrieve_end_time() {
        return retrieve_end_time;
    }

    public void setRetrieve_end_time(String retrieve_end_time) {
        this.retrieve_end_time = retrieve_end_time;
    }

    public String getRetrieve_process_time() {
        return retrieve_process_time;
    }

    public void setRetrieve_process_time(String retrieve_process_time) {
        this.retrieve_process_time = retrieve_process_time;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getData_start_time() {
        return data_start_time;
    }

    public void setData_start_time(String data_start_time) {
        this.data_start_time = data_start_time;
    }

    public String getData_end_time() {
        return data_end_time;
    }

    public void setData_end_time(String data_end_time) {
        this.data_end_time = data_end_time;
    }

    public String getLongitude_latitude_scope() {
        return longitude_latitude_scope;
    }

    public void setLongitude_latitude_scope(String longitude_latitude_scope) {
        this.longitude_latitude_scope = longitude_latitude_scope;
    }

    public long getData_num() {
        return data_num;
    }

    public void setData_num(long data_num) {
        this.data_num = data_num;
    }

    public int getSys_conn_state() {
        return sys_conn_state;
    }

    public void setSys_conn_state(int sys_conn_state) {
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

    public int getMode_type() {
        return mode_type;
    }

    public void setMode_type(int mode_type) {
        this.mode_type = mode_type;
    }

    public Map<String,List> getElements() {
        return elements;
    }

    public void setElements(Map<String,List> elements) {
        this.elements = elements;
    }
}
