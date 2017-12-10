CREATE TABLE public.satellite_file_data_head
(
    s_f_id bigint NOT NULL,
    data_logo character varying(40) COLLATE pg_catalog."default" NOT NULL,
    data_name character varying(60) COLLATE pg_catalog."default",
    data_code character varying(60) COLLATE pg_catalog."default",
    retrieve_start_time timestamp without time zone,
    retrieve_end_time timestamp without time zone,
    retrieve_process_time double precision,
    data_time timestamp without time zone,
    file_path character varying(150) COLLATE pg_catalog."default",
    data_start_time timestamp without time zone,
    data_end_time timestamp without time zone,
    longitude_latitude_scope character varying(30) COLLATE pg_catalog."default",
    data_num character varying(10) COLLATE pg_catalog."default",
    total_count character varying(10) COLLATE pg_catalog."default",
    sys_conn_state character varying(10) COLLATE pg_catalog."default",
    return_abnormal_info character varying(256) COLLATE pg_catalog."default",
    user_id character varying(30) COLLATE pg_catalog."default",
    system_name character varying(120) COLLATE pg_catalog."default",
    data_type integer,
    mode_type integer,
    sate_name character varying(64) COLLATE pg_catalog."default",
    sate_file_num character varying(10) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.satellite_file_data_head
    OWNER to postgres;
