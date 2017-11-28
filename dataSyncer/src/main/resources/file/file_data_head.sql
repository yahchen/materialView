CREATE TABLE "public"."file_data_head" (
"s_d_id" int8 NOT NULL,
"data_logo" varchar(40) NOT NULL,
"dada_name" varchar(60),
"data_code" varchar(60),
"retrieve_start_time" timestamp(6),
"retrieve_end_time" timestamp(6),
"retrieve_process_time" float8,
"file_path" varchar(150),
"data_start_time" timestamp(6),
"data_end_time" timestamp(6),
"longitude_latitude_scope" varchar(30),
"sys_conn_state" varchar(10),
"data_num" varchar(10),
"user_id" varchar(30),
"system_name" varchar(120),
"data_type" int4,
"site_type" int4,
"return_abnormal_info" varchar(60),
"data_time" timestamp(6)
)
WITH (OIDS=FALSE);