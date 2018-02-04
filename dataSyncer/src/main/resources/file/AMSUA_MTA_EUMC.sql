-- Table: "AMSUA_MTA_EUMC"

-- DROP TABLE "AMSUA_MTA_EUMC";

CREATE TABLE "AMSUA_MTA_EUMC"
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
  CONSTRAINT amsua_mta_eumc PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "AMSUA_MTA_EUMC"
  OWNER TO postgres;


INSERT INTO "AMSUA_MTA_EUMC"(
            sat_id, instrument_id, scan_time, obs_lat, obs_lon, obs_bt1,
            obs_bt2, obs_bt3, obs_bt4, obs_bt5, file_name_time, surface_height,
            s_f_id, id)
    VALUES (?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?,
            ?, ?);


DELETE FROM "AMSUA_MTA_EUMC"
 WHERE <condition>;