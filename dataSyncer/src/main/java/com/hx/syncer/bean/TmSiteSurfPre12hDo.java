package com.hx.syncer.bean;

import javax.persistence.*;

/**
 * Created by yahchen on 2017/10/31.
 */
@Entity
@Table(name = "tm_site_surf_pre_12h")
public class TmSiteSurfPre12hDo {
    @Column(name = "station_id_d",nullable=false)
    private float station_id_d;
    @Column(name = "lat",nullable=true)
    private float lat ;
    @Column(name = "lon",nullable=true)
    private float lon ;
    @Column(name = "pre_12h",nullable=true)
    private float pre_12h ;
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

    public float getPre_12h() {
        return pre_12h;
    }

    public void setPre_12h(float pre_12h) {
        this.pre_12h = pre_12h;
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
