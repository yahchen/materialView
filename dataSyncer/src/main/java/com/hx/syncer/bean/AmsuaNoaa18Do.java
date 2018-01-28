package com.hx.syncer.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "AMSUA_NOAA18")
public class AmsuaNoaa18Do {
    @Column(name = "sat_id")
    private int sat_id;
    @Column(name = "instrument_id",nullable=true)
    private int instrument_id ;
    @Column(name = "scan_time",nullable=true)
    private Timestamp scan_time ;
    @Column(name = "obs_lat",nullable=true)
    private float obs_lat ;
    @Column(name = "obs_lon",nullable=true)
    private float obs_lon ;
    @Column(name = "obs_bt1",nullable=true)
    private int obs_bt1 ;
    @Column(name = "obs_bt2",nullable=true)
    private int obs_bt2 ;
    @Column(name = "obs_bt3",nullable=true)
    private int obs_bt3 ;
    @Column(name = "obs_bt4",nullable=true)
    private int obs_bt4 ;
    @Column(name = "obs_bt5",nullable=true)
    private int obs_bt5 ;
    @Column(name = "file_name_time",nullable=true)
    private Timestamp file_name_time ;
    @Column(name = "surface_height",nullable=true)
    private float surface_height ;
    @Column(name = "s_f_id",nullable=false)
    private long s_f_id;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
    private long id ;

    public int getSat_id() {
        return sat_id;
    }

    public void setSat_id(int sat_id) {
        this.sat_id = sat_id;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public Timestamp getScan_time() {
        return scan_time;
    }

    public void setScan_time(Timestamp scan_time) {
        this.scan_time = scan_time;
    }

    public float getObs_lat() {
        return obs_lat;
    }

    public void setObs_lat(float obs_lat) {
        this.obs_lat = obs_lat;
    }

    public float getObs_lon() {
        return obs_lon;
    }

    public void setObs_lon(float obs_lon) {
        this.obs_lon = obs_lon;
    }

    public int getObs_bt1() {
        return obs_bt1;
    }

    public void setObs_bt1(int obs_bt1) {
        this.obs_bt1 = obs_bt1;
    }

    public int getObs_bt2() {
        return obs_bt2;
    }

    public void setObs_bt2(int obs_bt2) {
        this.obs_bt2 = obs_bt2;
    }

    public int getObs_bt3() {
        return obs_bt3;
    }

    public void setObs_bt3(int obs_bt3) {
        this.obs_bt3 = obs_bt3;
    }

    public int getObs_bt4() {
        return obs_bt4;
    }

    public void setObs_bt4(int obs_bt4) {
        this.obs_bt4 = obs_bt4;
    }

    public int getObs_bt5() {
        return obs_bt5;
    }

    public void setObs_bt5(int obs_bt5) {
        this.obs_bt5 = obs_bt5;
    }

    public Timestamp getFile_name_time() {
        return file_name_time;
    }

    public void setFile_name_time(Timestamp file_name_time) {
        this.file_name_time = file_name_time;
    }

    public float getSurface_height() {
        return surface_height;
    }

    public void setSurface_height(float surface_height) {
        this.surface_height = surface_height;
    }

    public long getS_f_id() {
        return s_f_id;
    }

    public void setS_f_id(long s_f_id) {
        this.s_f_id = s_f_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
