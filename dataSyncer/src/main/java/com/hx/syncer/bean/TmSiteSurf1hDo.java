package com.hx.syncer.bean;

import javax.persistence.*;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "tm_site_surf_1h")
public class TmSiteSurf1hDo {
    @Column(name = "station_id_d", nullable = false)
    private float station_id_d;
    @Column(name = "lat", nullable = true)
    private float lat;
    @Column(name = "lon", nullable = true)
    private float lon;
    @Column(name = "alti", nullable = true)
    private float alti;
    @Column(name = "tem", nullable = true)
    private float tem;
    @Column(name = "prs", nullable = true)
    private float prs;
    @Column(name = "dpt", nullable = true)
    private float dpt;
    @Column(name = "win_d_inst", nullable = true)
    private float win_d_inst;
    @Column(name = "win_s_inst", nullable = true)
    private float win_s_inst;
    @Column(name = "pre_1h", nullable = true)
    private float pre_1h;
    @Column(name = "tem_max", nullable = true)
    private float tem_max;
    @Column(name = "tem_min", nullable = true)
    private float tem_min;
    @Column(name = "s_d_id", nullable = true)
    private long s_d_id;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = true, updatable = false, precision = 20, scale = 0)
    private long id;

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

    public float getWin_d_inst() {
        return win_d_inst;
    }

    public void setWin_d_inst(float win_d_inst) {
        this.win_d_inst = win_d_inst;
    }

    public float getWin_s_inst() {
        return win_s_inst;
    }

    public void setWin_s_inst(float win_s_inst) {
        this.win_s_inst = win_s_inst;
    }

    public float getPre_1h() {
        return pre_1h;
    }

    public void setPre_1h(float pre_1h) {
        this.pre_1h = pre_1h;
    }

    public float getTem_max() {
        return tem_max;
    }

    public void setTem_max(float tem_max) {
        this.tem_max = tem_max;
    }

    public float getTem_min() {
        return tem_min;
    }

    public void setTem_min(float tem_min) {
        this.tem_min = tem_min;
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
