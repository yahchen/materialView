-- Table: public.rm_site_surf_ch

-- DROP TABLE public.rm_site_surf_ch;

CREATE TABLE public.rm_site_surf_ch
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    alti double precision,
    station_type double precision,
    day double precision,
    hour double precision,
    prs_sea double precision,
    tem double precision,
    prs double precision,
    dpt double precision,
    win_d_inst double precision,
    win_s_inst double precision,
    pre_1h double precision,
    pre_6h double precision,
    pre_24h double precision,
    q_prs double precision,
    q_prs_sea double precision,
    q_win_d_inst double precision,
    q_win_s_inst double precision,
    q_tem double precision,
    q_dpt double precision,
    q_pre_1h double precision,
    q_pre_6h double precision,
    q_pre_24h double precision,
    station_id_c double precision,
    s_d_id bigint not null,
    id bigint not null,
    CONSTRAINT rm_site_surf_ch_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.rm_site_surf_ch
    OWNER to postgres;