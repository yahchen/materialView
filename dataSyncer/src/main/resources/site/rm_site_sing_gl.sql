-- Table: public.rm_site_sing_gl

-- DROP TABLE public.rm_site_sing_gl;

CREATE TABLE public.rm_site_sing_gl
(
    station_id_c character varying(255) COLLATE pg_catalog."default",
    lat double precision,
    lon double precision,
    day double precision,
    hour double precision,
    min double precision,
    flight_stat double precision,
    flight_heigh double precision,
    tem double precision,
    win_d double precision,
    win_s double precision,
    q_flight_heigh double precision,
    q_tem double precision,
    q_win_d double precision,
    q_win_s double precision,
    s_d_id bigint not null,
    id bigint not null,
    CONSTRAINT rm_site_sing_gl_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.rm_site_sing_gl
    OWNER to postgres;