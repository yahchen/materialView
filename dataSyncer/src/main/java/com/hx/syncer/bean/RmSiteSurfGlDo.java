package com.hx.syncer.bean;

import javax.persistence.*;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "rm_site_surf_gl")
public class RmSiteSurfGlDo {
    @Column(name = "station_id_d",nullable=false)
    private float station_id_d ;
    @Column(name = "lat",nullable=true)
    private float lat ;
    @Column(name = "lon",nullable=true)
    private float lon ;
    @Column(name = "alti",nullable=true)
    private float alti ;
    @Column(name = "station_type",nullable=true)
    private float station_type ;
    @Column(name = "day",nullable=true)
    private float day ;
    @Column(name = "hour",nullable=true)
    private float hour ;
    @Column(name = "min",nullable=true)
    private float min ;
    @Column(name = "prs_sea",nullable=true)
    private float prs_sea ;
    @Column(name = "tem",nullable=true)
    private float tem ;
    @Column(name = "prs",nullable=true)
    private float prs ;
    @Column(name = "dpt",nullable=true)
    private float dpt ;
    @Column(name = "win_d",nullable=true)
    private float win_d ;
    @Column(name = "win_s",nullable=true)
    private float win_s ;
    @Column(name = "pre_1h",nullable=true)
    private float pre_1h ;
    @Column(name = "pre_6h",nullable=true)
    private float pre_6h ;
    @Column(name = "pre_24h",nullable=true)
    private float pre_24h ;
    @Column(name = "q_prs",nullable=true)
    private float q_prs ;
    @Column(name = "q_prs_sea",nullable=true)
    private float q_prs_sea ;
    @Column(name = "q_win_d",nullable=true)
    private float q_win_d ;
    @Column(name = "q_win_s",nullable=true)
    private float q_win_s ;
    @Column(name = "q_tem",nullable=true)
    private float q_tem ;
    @Column(name = "q_dpt",nullable=true)
    private float q_dpt ;
    @Column(name = "q_pre_1h",nullable=true)
    private float q_pre_1h ;
    @Column(name = "q_pre_6h",nullable=true)
    private float q_pre_6h ;
    @Column(name = "q_pre_24h",nullable=true)
    private float q_pre_24h ;
    @Column(name = "station_id_c",nullable=true)
    private float station_id_c ;
    @Column(name = "s_d_id",nullable=true)
    private long s_d_id ;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
    private long id ;


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

    public float getStation_type() {
        return station_type;
    }

    public void setStation_type(float station_type) {
        this.station_type = station_type;
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

    public float getPrs_sea() {
        return prs_sea;
    }

    public void setPrs_sea(float prs_sea) {
        this.prs_sea = prs_sea;
    }

    public float getTem() {
        return tem;
    }

    public void setTem(float tem) {
        this.tem = tem;
    }

    public float getPrs() {
        return prs;
    }

    public void setPrs(float prs) {
        this.prs = prs;
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

    public float getPre_1h() {
        return pre_1h;
    }

    public void setPre_1h(float pre_1h) {
        this.pre_1h = pre_1h;
    }

    public float getPre_6h() {
        return pre_6h;
    }

    public void setPre_6h(float pre_6h) {
        this.pre_6h = pre_6h;
    }

    public float getPre_24h() {
        return pre_24h;
    }

    public void setPre_24h(float pre_24h) {
        this.pre_24h = pre_24h;
    }

    public float getQ_prs() {
        return q_prs;
    }

    public void setQ_prs(float q_prs) {
        this.q_prs = q_prs;
    }

    public float getQ_prs_sea() {
        return q_prs_sea;
    }

    public void setQ_prs_sea(float q_prs_sea) {
        this.q_prs_sea = q_prs_sea;
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

    public float getQ_pre_1h() {
        return q_pre_1h;
    }

    public void setQ_pre_1h(float q_pre_1h) {
        this.q_pre_1h = q_pre_1h;
    }

    public float getQ_pre_6h() {
        return q_pre_6h;
    }

    public void setQ_pre_6h(float q_pre_6h) {
        this.q_pre_6h = q_pre_6h;
    }

    public float getQ_pre_24h() {
        return q_pre_24h;
    }

    public void setQ_pre_24h(float q_pre_24h) {
        this.q_pre_24h = q_pre_24h;
    }

    public float getStation_id_c() {
        return station_id_c;
    }

    public void setStation_id_c(float station_id_c) {
        this.station_id_c = station_id_c;
    }

    public long getS_d_id() {
        return s_d_id;
    }

    public void setS_d_id(long s_d_id) {
        this.s_d_id = s_d_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
