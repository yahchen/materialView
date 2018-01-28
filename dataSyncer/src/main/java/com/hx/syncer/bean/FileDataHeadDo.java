package com.hx.syncer.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "file_data_head")
public class FileDataHeadDo{

    @Column(name="s_d_id", nullable=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_d_id;
    @Column(name = "data_logo" ,nullable=true)
    private String data_logo ;
    @Column(name = "data_name" ,nullable=true)
    private String data_name ;
    @Column(name = "data_code" ,nullable=true)
    private String data_code ;
    @Column(name = "retrieve_start_time" ,nullable=true)
    private Timestamp retrieve_start_time ;
    @Column(name = "retrieve_end_time" ,nullable=true)
    private Timestamp retrieve_end_time ;
    @Column(name = "retrieve_process_time" ,nullable=true)
    private float retrieve_process_time ;
    @Column(name = "file_path" ,nullable=true)
    private String file_path ;
    @Column(name = "data_start_time" ,nullable=true)
    private Timestamp data_start_time ;
    @Column(name = "data_end_time" ,nullable=true)
    private Timestamp data_end_time ;
    @Column(name = "longitude_latitude_scope" ,nullable=true)
    private String longitude_latitude_scope ;
    @Column(name = "sys_conn_state" ,nullable=true)
    private String sys_conn_state ;
    @Column(name = "data_num" ,nullable=true)
    private String data_num ;
    @Column(name = "user_id" ,nullable=true)
    private String user_id ;
    @Column(name = "system_name" ,nullable=true)
    private String system_name ;
    @Column(name = "data_type" ,nullable=true)
    private int data_type ;
    @Column(name = "mode_type" ,nullable=true)
    private int mode_type ;
    @Column(name = "return_abnormal_info" ,nullable=true)
    private String return_abnormal_info ;
    @Column(name = "data_time" ,nullable=true)
    private Timestamp data_time ;

    @javax.persistence.Id
    @Column(name="id",unique=true, nullable=true, updatable=false, precision=20, scale=0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getS_d_id() {
        return s_d_id;
    }

    public void setS_d_id(long s_d_id) {
        this.s_d_id = s_d_id;
    }

    public String getData_logo() {
        return data_logo;
    }

    public void setData_logo(String data_logo) {
        this.data_logo = data_logo;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public String getData_code() {
        return data_code;
    }

    public void setData_code(String data_code) {
        this.data_code = data_code;
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

    public float getRetrieve_process_time() {
        return retrieve_process_time;
    }

    public void setRetrieve_process_time(float retrieve_process_time) {
        this.retrieve_process_time = retrieve_process_time;
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

    public String getLongitude_latitude_scope() {
        return longitude_latitude_scope;
    }

    public void setLongitude_latitude_scope(String longitude_latitude_scope) {
        this.longitude_latitude_scope = longitude_latitude_scope;
    }

    public String getSys_conn_state() {
        return sys_conn_state;
    }

    public void setSys_conn_state(String sys_conn_state) {
        this.sys_conn_state = sys_conn_state;
    }

    public String getData_num() {
        return data_num;
    }

    public void setData_num(String data_num) {
        this.data_num = data_num;
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

    public String getReturn_abnormal_info() {
        return return_abnormal_info;
    }

    public void setReturn_abnormal_info(String return_abnormal_info) {
        this.return_abnormal_info = return_abnormal_info;
    }

    public Timestamp getData_time() {
        return data_time;
    }

    public void setData_time(Timestamp data_time) {
        this.data_time = data_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
