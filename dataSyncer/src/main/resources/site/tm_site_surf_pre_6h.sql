-- Table: public.tm_site_surf_pre_6h

-- DROP TABLE public.tm_site_surf_pre_6h;

CREATE TABLE public.tm_site_surf_pre_6h
(
    station_id_d double precision NOT NULL,
    lat double precision,
    lon double precision,
    pre_6h double precision,
    s_d_id bigint,
        id bigint not null,
    CONSTRAINT tm_site_surf_pre_6h_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tm_site_surf_pre_6h
    OWNER to postgres;