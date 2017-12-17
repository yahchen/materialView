--- Table: "AMSUA_MTB_EUMP"

-- DROP TABLE "AMSUA_MTB_EUMP";

CREATE TABLE "AMSUA_MTB_EUMP"
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
  CONSTRAINT amsua_mtb_eump PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);



ALTER TABLE "AMSUA_MTB_EUMP"
  OWNER TO postgres;



DELETE FROM public."AMSUA_MTB_EUMP"
	WHERE <condition>;
