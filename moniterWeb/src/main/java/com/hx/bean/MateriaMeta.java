package com.hx.bean;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by wangyaohui on 2017/6/2.
 */
@Service
public class MateriaMeta {
    private long m_id;
    private long data_code;
    private String data_name;
    private Timestamp retrieve_start_time;
    private Timestamp retrieve_end_time;
    private long retrieve_process_time;
    private Timestamp data_time;
    private Timestamp data_start_time;
    private Timestamp data_end_time;
    private String longitude_latitude_scope;
    private long data_num;
    private int sys_conn_state;
    private String return_abnormal_info;
    private long user_id;
    private String system_name;
    private int data_type;
    private int mode_type;
    private int material_type;
    private String resource_path;

    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public long getData_code() {
        return data_code;
    }

    public void setData_code(long data_code) {
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

    public long getRetrieve_process_time() {
        return retrieve_process_time;
    }

    public void setRetrieve_process_time(long retrieve_process_time) {
        this.retrieve_process_time = retrieve_process_time;
    }

    public Timestamp getData_time() {
        return data_time;
    }

    public void setData_time(Timestamp data_time) {
        this.data_time = data_time;
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
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

    public int getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(int material_type) {
        this.material_type = material_type;
    }

    public String getResource_path() {
        return resource_path;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }
}
