CREATE TABLE "public"."file_data_head" (
"s_d_id" bigint NOT NULL,
"data_logo" character varying(255) COLLATE pg_catalog."default" NOT NULL,
"data_name" character varying(255) COLLATE pg_catalog."default",
"data_code" character varying(255) COLLATE pg_catalog."default",
"retrieve_start_time" timestamp without time zone,
"retrieve_end_time" timestamp without time zone,
"retrieve_process_time" double precision,
"file_path" character varying(255) COLLATE pg_catalog."default",
"data_start_time" timestamp without time zone,
"data_end_time" timestamp without time zone,
"longitude_latitude_scope" character varying(255) COLLATE pg_catalog."default",
"sys_conn_state" character varying(255) COLLATE pg_catalog."default",
"data_num" character varying(255) COLLATE pg_catalog."default",
"user_id" character varying(255) COLLATE pg_catalog."default",
"system_name" character varying(255) COLLATE pg_catalog."default",
"data_type" int4,
"mode_type" int4,
"return_abnormal_info" character varying(255) COLLATE pg_catalog."default",
"data_time" timestamp without time zone,
CONSTRAINT file_data_head_pkey PRIMARY KEY (s_d_id)
)
WITH (OIDS=FALSE);