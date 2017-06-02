CREATE TABLE public.materia
(
    m_id bigint NOT NULL,
    data_code bigint,
    data_name text,
    retrieve_start_time timestamp,
    retrieve_end_time timestamp,
    retrieve_process_time int,
    data_time timestamp,
    data_start_time timestamp,
    data_end_time timestamp,
    longitude_latitude_scope text,
    data_num bigint,
    sys_conn_state int,
    return_abnormal_info text,
    user_id bigint,
    system_name text,
    data_type int,
    site_type int,
    material_type int,
    resource_path text,
    CONSTRAINT materia_pkey PRIMARY KEY (m_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.materia
    OWNER to postgres;