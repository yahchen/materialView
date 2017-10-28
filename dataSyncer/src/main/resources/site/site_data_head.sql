﻿-- Table: public.site_data_head

-- DROP TABLE public.site_data_head;

CREATE TABLE public.site_data_head
(
    s_d_id bigint NOT NULL,
    data_logo character varying(40) COLLATE pg_catalog."default" NOT NULL,
    dada_name character varying(60) COLLATE pg_catalog."default",
    retrieve_start_time timestamp without time zone,
    retrieve_end_time timestamp without time zone,
    retrieve_process_time double precision,
    data_time character varying(30) COLLATE pg_catalog."default",
    file_path character varying(150) COLLATE pg_catalog."default",
    data_start_time timestamp without time zone,
    data_end_time timestamp without time zone,
    longitude_latitude_scope character varying(30) COLLATE pg_catalog."default",
    sys_conn_state character varying(10) COLLATE pg_catalog."default",
    data_num bigint,
    user_id character varying(30) COLLATE pg_catalog."default",
    system_name character varying(30) COLLATE pg_catalog."default",
    data_type integer,
    site_type integer,
    return_abnormal_info character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT site_data_head_pkey PRIMARY KEY (s_d_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.site_data_head
    OWNER to postgres;