-- Table: "AMSUA_MTA_EUMS"

-- DROP TABLE "AMSUA_MTA_EUMS";

CREATE TABLE "AMSUA_MTA_EUMS"
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
  CONSTRAINT amsua_mta_eums PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);



ALTER TABLE "AMSUA_MTA_EUMS"
  OWNER TO postgres;



DELETE FROM public."AMSUA_MTA_EUMS"
	WHERE <condition>;
