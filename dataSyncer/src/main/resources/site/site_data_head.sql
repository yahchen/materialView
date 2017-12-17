﻿-- Table: public.site_data_head

-- DROP TABLE public.site_data_head;

CREATE TABLE public.site_data_head
(
    s_d_id bigint NOT NULL,
    data_logo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    dada_name character varying(255) COLLATE pg_catalog."default",
    data_code character varying(255) COLLATE pg_catalog."default",
    retrieve_start_time timestamp without time zone,
    retrieve_end_time timestamp without time zone,
    retrieve_process_time double precision,
    data_time timestamp without time zone,
    file_path character varying(255) COLLATE pg_catalog."default",
    data_start_time timestamp without time zone,
    data_end_time timestamp without time zone,
    longitude_latitude_scope character varying(255) COLLATE pg_catalog."default",
    sys_conn_state character varying(255) COLLATE pg_catalog."default",
    data_num character varying(255) COLLATE pg_catalog."default",
    user_id character varying(255) COLLATE pg_catalog."default",
    system_name character varying(255) COLLATE pg_catalog."default",
    data_type integer,
    mode_type integer,
    return_abnormal_info character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT site_data_head_pkey PRIMARY KEY (s_d_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.site_data_head
    OWNER to postgres;