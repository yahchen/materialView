-- Table: public.tm_site_surf_pre_12h

-- DROP TABLE public.tm_site_surf_pre_12h;

CREATE TABLE public.tm_site_surf_pre_12h
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    pre_12h double precision,
    s_d_id bigint,
    CONSTRAINT tm_site_surf_pre_12h_pkey PRIMARY KEY (station_id_d)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tm_site_surf_pre_12h
    OWNER to postgres;