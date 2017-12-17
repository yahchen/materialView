package com.hx.syncer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "gm_site_temp_gl")
public class GmSiteTempGlDo {
    @javax.persistence.Id
    @Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
    private long id;
    @Column(name = "station_id_d",nullable=false)
    private float station_id_d ;
    @Column(name = "lat",nullable=false)
    private float lat ;
    @Column(name = "lon",nullable=false)
    private float lon ;
    @Column(name = "alti",nullable=false)
    private float alti ;
    @Column(name = "day",nullable=false)
    private float day ;
    @Column(name = "hour",nullable=false)
    private float hour ;
    @Column(name = "min",nullable=false)
    private float min ;
    @Column(name = "prs_hwc",nullable=false)
    private float prs_hwc ;
    @Column(name = "evss",nullable=false)
    private float evss ;
    @Column(name = "gph",nullable=false)
    private float gph ;
    @Column(name = "tem",nullable=false)
    private float tem ;
    @Column(name = "dpt",nullable=false)
    private float dpt ;
    @Column(name = "win_d",nullable=false)
    private float win_d ;
    @Column(name = "win_s",nullable=false)
    private float win_s ;
    @Column(name = "time_dev_wq",nullable=false)
    private float time_dev_wq ;
    @Column(name = "lat_dev",nullable=false)
    private float lat_dev ;
    @Column(name = "lon_dev",nullable=false)
    private float lon_dev ;
    @Column(name = "q_prs_hwc",nullable=false)
    private float q_prs_hwc ;
    @Column(name = "q_gph",nullable=false)
    private float q_gph ;
    @Column(name = "q_tem",nullable=false)
    private float q_tem ;
    @Column(name = "q_dpt",nullable=false)
    private float q_dpt ;
    @Column(name = "q_win_d",nullable=false)
    private float q_win_d ;
    @Column(name = "q_win_s",nullable=false)
    private float q_win_s ;
    @Column(name = "q_lat_dev",nullable=false)
    private float q_lat_dev ;
    @Column(name = "q_lon_dev",nullable=false)
    private float q_lon_dev ;
    @Column(name = "s_d_id",nullable=false)
    private long s_d_id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getStation_id_d() {
        return station_id_d;
    }

    public void setStation_id_d(float station_id_d) {
        this.station_id_d = station_id_d;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getAlti() {
        return alti;
    }

    public void setAlti(float alti) {
        this.alti = alti;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getPrs_hwc() {
        return prs_hwc;
    }

    public void setPrs_hwc(float prs_hwc) {
        this.prs_hwc = prs_hwc;
    }

    public float getEvss() {
        return evss;
    }

    public void setEvss(float evss) {
        this.evss = evss;
    }

    public float getGph() {
        return gph;
    }

    public void setGph(float gph) {
        this.gph = gph;
    }

    public float getTem() {
        return tem;
    }

    public void setTem(float tem) {
        this.tem = tem;
    }

    public float getDpt() {
        return dpt;
    }

    public void setDpt(float dpt) {
        this.dpt = dpt;
    }

    public float getWin_d() {
        return win_d;
    }

    public void setWin_d(float win_d) {
        this.win_d = win_d;
    }

    public float getWin_s() {
        return win_s;
    }

    public void setWin_s(float win_s) {
        this.win_s = win_s;
    }

    public float getTime_dev_wq() {
        return time_dev_wq;
    }

    public void setTime_dev_wq(float time_dev_wq) {
        this.time_dev_wq = time_dev_wq;
    }

    public float getLat_dev() {
        return lat_dev;
    }

    public void setLat_dev(float lat_dev) {
        this.lat_dev = lat_dev;
    }

    public float getLon_dev() {
        return lon_dev;
    }

    public void setLon_dev(float lon_dev) {
        this.lon_dev = lon_dev;
    }

    public float getQ_prs_hwc() {
        return q_prs_hwc;
    }

    public void setQ_prs_hwc(float q_prs_hwc) {
        this.q_prs_hwc = q_prs_hwc;
    }

    public float getQ_gph() {
        return q_gph;
    }

    public void setQ_gph(float q_gph) {
        this.q_gph = q_gph;
    }

    public float getQ_tem() {
        return q_tem;
    }

    public void setQ_tem(float q_tem) {
        this.q_tem = q_tem;
    }

    public float getQ_dpt() {
        return q_dpt;
    }

    public void setQ_dpt(float q_dpt) {
        this.q_dpt = q_dpt;
    }

    public float getQ_win_d() {
        return q_win_d;
    }

    public void setQ_win_d(float q_win_d) {
        this.q_win_d = q_win_d;
    }

    public float getQ_win_s() {
        return q_win_s;
    }

    public void setQ_win_s(float q_win_s) {
        this.q_win_s = q_win_s;
    }

    public float getQ_lat_dev() {
        return q_lat_dev;
    }

    public void setQ_lat_dev(float q_lat_dev) {
        this.q_lat_dev = q_lat_dev;
    }

    public float getQ_lon_dev() {
        return q_lon_dev;
    }

    public void setQ_lon_dev(float q_lon_dev) {
        this.q_lon_dev = q_lon_dev;
    }

    public long getS_d_id() {
        return s_d_id;
    }

    public void setS_d_id(long s_d_id) {
        this.s_d_id = s_d_id;
    }
}
