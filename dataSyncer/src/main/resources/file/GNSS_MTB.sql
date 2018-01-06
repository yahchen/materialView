-- Table: public."GNSS_MTB"

-- DROP TABLE public."GNSS_MTB";


CREATE TABLE "GNSS_MTB"
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
  s_f_id SERIAL,
  id SERIAL,
  CONSTRAINT gnss_mtb PRIMARY KEY (id )
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;




ALTER TABLE public."GNSS_MTB"
    OWNER to postgres;






INSERT INTO public."GNSS_MTB"(
	sat_id, instrument_id, scan_time, obs_lat, obs_lon, obs_bt1, obs_bt2, obs_bt3, obs_bt4, obs_bt5, file_name_time, surface_height, f_d_id)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);


DELETE FROM public."GNSS_MTB"
	WHERE <condition>;