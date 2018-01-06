-- Table: public.tm_site_surf_pre_3h

-- DROP TABLE public.tm_site_surf_pre_3h;

CREATE TABLE public.tm_site_surf_pre_3h
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    pre_3h double precision,
    s_d_id SERIAL,
    id SERIAL,
    CONSTRAINT tm_site_surf_pre_3h_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tm_site_surf_pre_3h
    OWNER to postgres;