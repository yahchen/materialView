-- Table: public."ASCAT_MTB"

-- DROP TABLE public."ASCAT_MTB";


CREATE TABLE "ASCAT_MTB"
(
  sat_id integer,
  instrument_id integer,
  scan_time timestamp without time zone,
  obs_lat double precision,
  obs_lon double precision,
  obs_bt1 integer,
  obs_bt2 integer,
  obs_bt3 integer,
  obs_bt4 integer,
  obs_bt5 integer,
  file_name_time timestamp without time zone,
  surface_height double precision,
  f_d_id double precision,
  id bigint NOT NULL,
  CONSTRAINT ascat_mtb PRIMARY KEY (id )
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;




ALTER TABLE public."ASCAT_MTB"
    OWNER to postgres;






INSERT INTO public."ASCAT_MTB"(
	sat_id, instrument_id, scan_time, obs_lat, obs_lon, obs_bt1, obs_bt2, obs_bt3, obs_bt4, obs_bt5, file_name_time, surface_height, f_d_id)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);


INSERT INTO "ASCAT_MTB"(
            sat_id, instrument_id, scan_time, obs_lat, obs_lon, obs_bt1,
            obs_bt2, obs_bt3, obs_bt4, obs_bt5, file_name_time, surface_height,
            f_d_id,id)
    VALUES (15, 10, '2017-10-29 23:16:01', 44, 55, null,
            null, null, null, null, null, null,
            null,57);


DELETE FROM public."ASCAT_MTB"
	WHERE <condition>;