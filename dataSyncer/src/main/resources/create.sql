CREATE TABLE public.materia
(
    m_id bigint NOT NULL,
    data_code bigint,
    data_name VARCHAR(50),
    retrieve_start_time timestamp,
    retrieve_end_time timestamp,
    retrieve_process_time int,
    data_time timestamp,
    data_start_time timestamp,
    data_end_time timestamp,
    longitude_latitude_scope VARCHAR(50),
    data_num bigint,
    sys_conn_state int,
    return_abnormal_info VARCHAR(50),
    user_id bigint,
    system_name VARCHAR(50),
    data_type int,
    site_type int,
    material_type int,
    resource_path VARCHAR(120),
    CONSTRAINT materia_pkey PRIMARY KEY (m_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.materia
    OWNER to postgres;