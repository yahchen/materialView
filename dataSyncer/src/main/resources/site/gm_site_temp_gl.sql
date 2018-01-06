-- Table: public.gm_site_temp_gl

-- DROP TABLE public.gm_site_temp_gl;

CREATE TABLE public.gm_site_temp_gl
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    alti double precision,
    day double precision,
    hour double precision,
    min double precision,
    prs_hwc double precision,
    evss double precision,
    gph double precision,
    tem double precision,
    dpt double precision,
    win_d double precision,
    win_s double precision,
    time_dev_wq double precision,
    lat_dev double precision,
    lon_dev double precision,
    q_prs_hwc double precision,
    q_gph double precision,
    q_tem double precision,
    q_dpt double precision,
    q_win_d double precision,
    q_win_s double precision,
    q_lat_dev double precision,
    q_lon_dev double precision,
    s_d_id SERIAL,
    id SERIAL,
    CONSTRAINT gm_site_temp_gl_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.gm_site_temp_gl
    OWNER to postgres;