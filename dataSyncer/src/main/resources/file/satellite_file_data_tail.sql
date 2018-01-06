CREATE TABLE public.satellite_file_data_tail
(
    s_f_id bigint NOT NUL,
    sate_file_name character varying(160) COLLATE pg_catalog."default",
    id SERIAL,
    CONSTRAINT satellite_file_data_head_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.satellite_file_data_tail
    OWNER to postgres;
