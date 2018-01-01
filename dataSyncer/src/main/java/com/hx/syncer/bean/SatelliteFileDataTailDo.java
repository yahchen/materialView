package com.hx.syncer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "satellite_file_data_tail")
public class SatelliteFileDataTailDo {

    @Column(name="s_f_t_id",nullable=false)
    private long s_f_t_id;
    @Column(name = "s_f_id" ,nullable=false)
    private long s_f_id ;
    @Column(name = "sate_file_name" ,nullable=true)
    private String sate_file_name ;

    @javax.persistence.Id
    @Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
    private long id;


    public long getS_f_t_id() {
        return s_f_t_id;
    }

    public void setS_f_t_id(long s_f_t_id) {
        this.s_f_t_id = s_f_t_id;
    }

    public long getS_f_id() {
        return s_f_id;
    }

    public void setS_f_id(long s_f_id) {
        this.s_f_id = s_f_id;
    }

    public String getSate_file_name() {
        return sate_file_name;
    }

    public void setSate_file_name(String sate_file_name) {
        this.sate_file_name = sate_file_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
