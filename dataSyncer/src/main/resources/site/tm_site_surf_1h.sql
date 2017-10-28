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
    CONSTRAINT tm_site_surf_1h_pkey PRIMARY KEY (station_id_d)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tm_site_surf_1h
    OWNER to postgres;