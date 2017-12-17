-- Table: public.tm_site_surf_1h

-- DROP TABLE public.tm_site_surf_1h;

CREATE TABLE public.tm_site_surf_1h
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    alti double precision,
    tem double precision,
    prs double precision,
    dpt double precision,
    win_d_inst double precision,
    win_s_inst double precision,
    pre_1h double precision,
    tem_max double precision,
    tem_min double precision,
    s_d_id bigint,
    id bigint not null,
    CONSTRAINT tm_site_surf_1h_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tm_site_surf_1h
    OWNER to postgres;


﻿INSERT INTO public.tm_site_surf_1h(
	station_id_d, lat, lon, alti, tem, prs, dpt, win_d_inst, win_s_inst, pre_1h, tem_max, tem_min, s_d_id)
	VALUES (754059.00,29.85,120.58,15.00,15.90,999999.00,999999.00,34.00,1.80,0.00,16.00,15.80,1),
    (57477.00,30.08,112.22,38.40,14.60,1018.00,14.10,227.00,1.00,0.00,14.60,13.90,2),
    (808697.00,24.95,112.93,1254.00,11.60,999999.00,999999.00,340.00,0.00,0.10,11.70,11.40,3),
    (878060.00,36.45,107.80,1215.00,6.20,999999.00,999999.00,999999.00,999999.00,0.00,6.20,5.90,4),
    (761258.00,41.78,123.32,0.00,999999.00,999999.00,999999.00,999999.00,999999.00,0.00,999999.00,999999.00,5),
    (836151.00,29.84,104.46,526.30,15.50,967.90,999999.00,199.00,0.60,0.00,15.50,14.60,6),
    (703710.00,26.80,118.94,874.00,16.50,999999.00,999999.00,339.00,1.70,0.00,16.50,16.20,7),
    (876165.00,33.44,105.28,1335.00,7.70,999999.00,999999.00,999999.00,999999.00,0.00,7.70,7.30,8),
    (814320.00,30.32,111.98,40.00,14.10,999999.00,11.40,0.00,0.00,0.00,14.20,13.50,9),
    (836246.00,30.06,103.38,953.40,12.90,911.50,999999.00,204.00,1.40,0.00,12.90,12.70,10),
    (703519.00,27.26,120.24,70.00,22.60,1004.70,15.50,12.00,0.80,0.00,22.60,20.00,11),
    (808700.00,25.11,112.90,197.00,16.20,999999.00,999999.00,999999.00,999999.00,0.00,16.20,15.90,12),
    (754062.00,30.03,120.37,10.00,16.60,999999.00,999999.00,345.00,0.90,0.00,16.60,15.90,13);