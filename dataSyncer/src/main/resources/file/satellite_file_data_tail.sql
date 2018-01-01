CREATE TABLE public.satellite_file_data_tail
(
    s_f_t_id bigint NOT NULL,
    s_f_id bigint NOT NULL,
    sate_file_name character varying(160) COLLATE pg_catalog."default",
    id bigint not null,
  CONSTRAINT satellite_file_data_tail_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.satellite_file_data_tail
    OWNER to postgres;
